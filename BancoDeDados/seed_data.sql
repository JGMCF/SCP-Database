INSERT INTO site (latitude, longitude) VALUES
(46.23961100, -119.26998900),
(37.24310000, -115.79300000);

INSERT INTO research_team (competence_level, research_affinities) VALUES
(5, ARRAY['anatomy'::research_t, 'anomaly_testing'::research_t]),
(4, ARRAY['physics'::research_t]);

INSERT INTO research (research_state, research_type, risk, cost) VALUES
('on-going', 'anatomy', 4, 15000),
('sucess', 'physics', 5, 50000);

INSERT INTO squad (squad_code, specialties) VALUES
('SQD-001', ARRAY['capture'::field_operation_t, 'combat'::field_operation_t]),
('SQD-002', ARRAY['recon'::field_operation_t]);

INSERT INTO mission (mission_date, location_latitude, location_longitude, mission_status, total_casualties, description) VALUES
('2026-01-15', 12.34567800, 45.67891200, 'sucess', 0, 'Varredura tatica em setor isolado.'),
('2026-02-20', -15.82670000, -47.92180000, 'on-going', 2, 'Contencao de criatura.');

INSERT INTO employee (cpf, works_at, first_name, last_name, salary) VALUES
('11144477735', 1, 'Phoenix', 'Raffaella', 4500),
('22255588846', 1, 'Jane', 'Doe', 6000),
('33366699957', 2, 'Ju', 'Fufu', 9500),
('44477700068', 2, 'Dialyn', 'zzz', 5200),
('55555823914', 2, 'Taiga', 'Aisaka', 5200);

INSERT INTO researcher (employee_id, member_of, specialty) VALUES
(1, 1, ARRAY['anatomy'::research_t]),
(4, 1, ARRAY['anatomy'::research_t]);

INSERT INTO research_manager (employee_id, leads) VALUES
(2, 1);

INSERT INTO site_manager (employee_id, manages) VALUES
(2, 1);

INSERT INTO agent (employee_id, member_of, squad_role) VALUES
(3, 1, 'assault');

INSERT INTO commander (employee_id, commands) VALUES
(3, 1);

INSERT INTO creature (creature_code, contained_in, creature_type, aggressiveness_level, class, name, description) VALUES
('SCP-173', 1, 'physical', 5, 'euclid', 'The Sculpture', 'Move-se apenas quando não há linha de visão direta.'),
('SCP-682', 2, 'physical', 5, 'keter', 'Hard-to-Destroy Reptile', 'Capacidade de regeneração e adaptação extrema.');

INSERT INTO ability (creature_id, ability_id, name, description, frequency, ability_type) VALUES
(1, 1, 'Snap', 'Quebra o pescoço da vítima instantaneamente.', 10, 'physical'),
(2, 1, 'Adaptation', 'Gera imunidade instantânea a qualquer dano sofrido.', 50, 'physical');

INSERT INTO team_conducts_research (team_id, research_id) VALUES
(1, 1),
(2, 2);

INSERT INTO research_on_creature (research_id, creature_id) VALUES
(1, 2),
(2, 1);

INSERT INTO squad_mission (squad_id, mission_id, creature_id) VALUES
(1, 1, 1),
(2, 2, NULL);