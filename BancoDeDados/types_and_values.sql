

-- Definicao de tipos estaticos de dado para tabelas presentes em tables.sql


-- Tipo de pesquisa, tambem usado para se referir as especialidades da entidade pesquisador
CREATE TYPE research_t AS ENUM ('botanics', 'geology', 'engineering',  'eletronics', 'psycology', 'anatomy', 'anomaly_testing', 'physics', 'chemistry');

-- Tipos de operacao de campo, usado para denotar as especialidades de um esquadrao especifico.
-- Se um esquadrao possui a especialidade captura, ele pode sem inserido na tabela missao_captura
CREATE TYPE field_operation_t AS ENUM ('recon', 'combat', 'capture', 'foraging', 'invasion');

-- Possiveis status de pesquisas e missoes
CREATE TYPE status_t AS ENUM ('planned', 'on-going', 'failure', 'sucess');

-- Tipos de criatura baseado em tangibilidade 
CREATE TYPE creature_t AS ENUM ('physical', 'ephemeral');

-- Classes de criatura, usado para agrupar e descrever risco, dentre outros fatores
CREATE TYPE creature_class AS ENUM ('safe', 'euclid', 'keter', 'thaumiel', 'explained');

-- Posiveis possocpes que um agente de campo pode ter em um esquadrao
CREATE TYPE agent_role AS ENUM ('medic', 'marksman', 'comms_spec', 'pointman', 'scout', 'heavy_weapons', 'assault');



-- Definicao de sequencias para manutencao de chaves primarias

CREATE SEQUENCE site_seq START 1 INCREMENT 1;
CREATE SEQUENCE creature_seq START 2 INCREMENT 1;
CREATE SEQUENCE squad_seq START 1 INCREMENT 1;