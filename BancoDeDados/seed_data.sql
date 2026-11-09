    -- ==========================================
    -- 1. TABELAS INDEPENDENTES (Pai)
    -- ==========================================

    -- 5 Sites (Usando IDs customizados com letras/números via trigger)
    INSERT INTO site (site_number, latitude, longitude) VALUES
    ('SITE-001', 46.23961100, -119.26998900),
    ('SITE-002', 37.24310000, -115.79300000),
    ('SITE-003', 50.08781100, 14.42046000),
    ('SITE-004', -30.03464700, -51.21765800),
    ('', 35.67622200, 139.65030000);

    -- 5 Equipes de Pesquisa
    INSERT INTO research_team (competence_level, research_affinities) VALUES
    (5, ARRAY['botanics'::research_t, 'eletronics'::research_t]),
    (4, ARRAY['geology'::research_t]),
    (3, ARRAY['psycology'::research_t, 'chemistry'::research_t]),
    (5, ARRAY['anomaly_testing'::research_t]),
    (2, ARRAY['anatomy'::research_t]);

    -- 5 Pesquisas
    INSERT INTO research (research_state, research_type, risk, cost) VALUES
    ('planned', 'botanics', 4, 15000),
    ('on-going', 'geology', 5, 50000),
    ('failure', 'engineering', 2, 8000),
    ('sucess', 'physics', 5, 120000),
    ('sucess', 'engineering', 3, 22000);

    -- 5 Esquadrões (Usando IDs customizados ou apenas números para testar o auto-prefixo)
    INSERT INTO squad (squad_id, name, specialties) VALUES
    ('SQD-001', 'Alpha-1 (Red Right Hand)', ARRAY['capture'::field_operation_t]),
    ('SQD-002', 'Beta-7 (Maz Hatters)', ARRAY['recon'::field_operation_t]),
    ('SQD-003', 'Gamma-5 (Red Herrings)', ARRAY['invasion'::field_operation_t, 'assault'::field_operation_t]),
    ('SQD-004', 'Epsilon-11 (Nine-Tailed Fox)', ARRAY['capture'::field_operation_t]),
    ('', 'Nu-7 (Hammer Down)', ARRAY['foraging'::field_operation_t]);

    -- 5 Missões 
    INSERT INTO mission (mission_date, location_latitude, location_longitude, mission_status, total_casualties, description) VALUES
    ('2026-01-15', 12.34567800, 45.67891200, 'planned', 0, 'Varredura tática em armazém abandonado.'),
    ('2026-02-20', -15.82670000, -47.92180000, 'on-going', 2, 'Contenção de brecha de segurança de nível médio.'),
    ('2026-03-10', 51.50740000, -0.12780000, 'failure', 5, 'Resgate de equipe de investigadores desaparecidos.'),
    ('2026-04-05', 48.85660000, 2.35220000, 'sucess', 0, 'Investigação de fenômeno ótico anômalo urbano.'),
    ('2026-05-12', -33.86880000, 151.20930000, 'sucess', 1, 'Interceptação de carregamento de artefatos anômalos.');


    -- ==========================================
    -- 2. FUNCIONÁRIOS E DERIVADOS
    -- ==========================================

    -- 5 Empregados (Distribuídos entre os 5 sites diferentes)
    INSERT INTO employee (cpf, works_at, first_name, last_name, salary) VALUES
    ('11144477735', 'SITE-001', 'John', 'Doe', 4500),
    ('22255588846', 'SITE-002', 'Jane', 'Smith', 6000),
    ('33366699957', 'SITE-003', 'Robert', 'Oppenheimer', 9500),
    ('44477700068', 'SITE-004', 'Clarice', 'Starling', 5200),
    ('55588811179', 'SITE-005', 'Hilda', 'Berg', 4800),
    ('12345678901', 'SITE-003', 'Phoenix', 'Raffaella', 329055);

    -- 2 Pesquisadores (vinculados a empregados e equipes de pesquisa)
    INSERT INTO researcher (cpf, member_of, specialty) VALUES
    ('11144477735', 1, ARRAY['engineering'::research_t]),
    ('44477700068', 3, ARRAY['geology'::research_t]);

    -- 2 Gerentes de Pesquisa (vinculados a empregados e equipes)
    INSERT INTO research_manager (cpf, leads) VALUES
    ('22255588846', 2),
    ('33366699957', 4);

    -- 1 Gerente de Site (vinculado a um research_manager e a um site)
    INSERT INTO site_manager (cpf, manages) VALUES
    ('22255588846', 'SITE-001');

    -- 5 Criaturas (Anomalias contidas nos sites)
    INSERT INTO creature (creature_id, contained_in, creature_type, aggressiveness_level, class, name, description) VALUES
    ('SCP-173', 'SITE-002', 'physical', 5, 'Euclid', 'The Sculpture', 'Move-se apenas quando não há linha de visão direta.'),
    ('SCP-096', 'SITE-004', 'psychological', 5, 'Euclid', 'The Shy Guy', 'Entra em fúria incontrolável se alguém ver seu rosto.'),
    ('SCP-682', 'SITE-001', 'biological', 5, 'Keter', 'Hard-to-Destroy Reptile', 'Capacidade de regeneração e adaptação extrema.'),
    ('SCP-999', 'SITE-003', 'biological', 1, 'Safe', 'The Tickle Monster', 'Massa gelatinosa laranja com efeito euforizante.'),
    ('SCP-049', 'SITE-005', 'anomalous', 3, 'Euclid', 'Plague Doctor', 'Entidade humanóide que busca curar a "Pestilência".');

    -- 5 Habilidades das Criaturas (Entidade fraca vinculada às criaturas)
    INSERT INTO ability (creature_id, name, description, frequency, ability_type) VALUES
    ('SCP-173', 'Snap', 'Quebra o pescoço da vítima instantaneamente.', 10, 'physical'),
    ('SCP-096', 'Rage State', 'Aceleração supersônica em direção ao alvo.', 100, 'psychological'),
    ('SCP-682', 'Adaptation', 'Gera imunidade instantânea a qualquer dano sofrido.', 50, 'biological'),
    ('SCP-999', 'Euphoria', 'Emite feromônios que induzem felicidade extrema.', 20, 'biological'),
    ('SCP-049', 'The Touch', 'Causa morte cerebral imediata por toque direto.', 5, 'anomalous');

    -- 2 Agentes (vinculados a empregados e esquadrões)
    INSERT INTO agent (cpf, member_of, squad_role) VALUES
    ('12345678901', 'SQD-001', 'assault'),
    ('55588811179', 'SQD-004', 'recon');

    -- 1 Comandante (vinculado a agente e esquadrão)
    INSERT INTO commander (cpf, commands) VALUES
    ('12345678901', 'SQD-001');


    -- ==========================================
    -- 3. TABELAS RELACIONAIS
    -- ==========================================

    -- 5 Relações de Equipes conduzindo Pesquisas
    INSERT INTO team_conducts_research (team_id, research_id) VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5);

    -- 5 Relações de Pesquisas sobre Criaturas
    INSERT INTO research_on_creature (research_id, creature_id) VALUES
    (1, 'SCP-682'),
    (2, 'SCP-173'),
    (3, 'SCP-096'),
    (4, 'SCP-049'),
    (5, 'SCP-999');

    -- 5 Missões de Esquadrão 
    -- (Nota: As missões 1 e 4 possuem criaturas associadas, acionando a trigger de validação de 'capture' no esquadrão correspondente)
    INSERT INTO squad_mission (squad_id, mission_id, creature_id) VALUES
    ('SQD-001', 1, 'SCP-173'), -- SQD-001 tem a especialidade 'capture', logo passa com sucesso
    ('SQD-002', 2, NULL),    -- Sem criatura, passa direto
    ('SQD-003', 3, NULL),    -- Sem criatura, passa direto
    ('SQD-004', 4, 'SCP-096'); -- SQD-004 tem a especialidade 'capture', passa com sucesso