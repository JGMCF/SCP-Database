

-- Funcao para verificar se um esquadrao_missao inserido na tabela
-- capture_mission possui a especilidade de captura.
-- apenas esquadores com essa especialidade podem ser inseridos
-- na tabela.


CREATE OR REPLACE FUNCTION validate_capture_specialty()
RETURNS TRIGGER AS $$
DECLARE
    squad_specialties field_operation_t[];
BEGIN
    IF NEW.creature_id IS NOT NULL THEN
        SELECT s.specialties INTO squad_specialties
        FROM squad AS s
        WHERE s.squad_id = NEW.squad_id;
        
        IF squad_specialties IS NULL OR NOT ('capture' = ANY(squad_specialties)) THEN
            RAISE EXCEPTION 'O esquadrao nao possui a especialidade de captura necessaria para esta missao.';
        END IF;
    END IF;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Trata o atributo ability_id da entidade fraca ability, fazendo 
-- com que o numero seja incrementado por criatura, e nao globalmente
-- assim, toda criatura possui sua proria abilidade numero 1,2,3, etc.

CREATE OR REPLACE FUNCTION generate_ability_id()
RETURNS TRIGGER AS $$
BEGIN
    IF NEW.ability_id IS NULL THEN
        SELECT COALESCE(MAX(ability_id), 0) + 1 
        INTO NEW.ability_id
        FROM ability
        WHERE creature_id = NEW.creature_id;
    END IF;
    
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Trata a insercao de pks nulas para a entidade site.
-- A entidade aceita chaves personalizadas, mas, caso nao seja
-- passada uma, usa uma chave default.


-- Trigger calls

CREATE TRIGGER trg_check_capture_specialty
        BEFORE INSERT OR UPDATE ON squad_mission
        FOR EACH ROW
        EXECUTE FUNCTION validate_capture_specialty();

CREATE TRIGGER trg_set_ability_id
    BEFORE INSERT ON ability
    FOR EACH ROW
    EXECUTE FUNCTION generate_ability_id();