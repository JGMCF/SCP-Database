CREATE TABLE site (
    site_id SERIAL PRIMARY KEY,
    latitude DECIMAL(11,8) NOT NULL,
    longitude DECIMAL(11,8) NOT NULL
);

CREATE TABLE research (
    research_id SERIAL PRIMARY KEY,
    research_state status_t NOT NULL,
    research_type research_t NOT NULL,
    risk INT NOT NULL,
    cost INT NOT NULL
);

CREATE TABLE squad (
    squad_id SERIAL PRIMARY KEY,
    squad_codename VARCHAR(30) UNIQUE,
    specialties field_operation_t[]
);

CREATE TABLE mission (
    mission_id SERIAL PRIMARY KEY,
    mission_date DATE DEFAULT CURRENT_DATE NOT NULL,
    location_latitude DECIMAL(11,8),
    location_longitude DECIMAL(11,8),
    mission_status status_t NOT NULL,
    total_casualties INT DEFAULT 0,
    description VARCHAR(400)
);

-- #### --



CREATE TABLE employee (
    employee_id SERIAL PRIMARY KEY,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    works_at INT NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    salary INT NOT NULL,
    admission_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_employee_site 
        FOREIGN KEY (works_at) 
        REFERENCES site(site_id),
    CONSTRAINT chk_cpf 
        CHECK (cpf ~ '^[0-9]{11}$')
);

CREATE TABLE researcher (
    employee_id INT PRIMARY KEY,
    member_of INT NOT NULL,
    specialty research_t[],

    CONSTRAINT fk_researcher_employee 
        FOREIGN KEY (employee_id) 
        REFERENCES employee(employee_id) 
        ON DELETE CASCADE,

    CONSTRAINT fk_researcher_team 
        FOREIGN KEY (member_of) 
        REFERENCES research_team(team_id)
);



CREATE TABLE research_team (
    team_id SERIAL PRIMARY KEY,
    site_id INT NOT NULL,
    competence_level INT,
    research_affinities research_t[],

    CONSTRAINT team_site
        FOREIGN KEY (site_id)
        REFERENCES site(site_id)

);

CREATE TABLE research_manager (
    employee_id INT PRIMARY KEY,
    leads INT NOT NULL,

    CONSTRAINT fk_research_manager_employee 
        FOREIGN KEY (employee_id)
        REFERENCES employee(employee_id) 
        ON DELETE CASCADE,
    CONSTRAINT fk_research_manager_team 
        FOREIGN KEY (leads)
        REFERENCES research_team(team_id)
);

CREATE TABLE site_manager (
    employee_id INT PRIMARY KEY,
    manages INT NOT NULL,

    CONSTRAINT fk_site_manager_manager 
        FOREIGN KEY (employee_id) 
        REFERENCES research_manager(employee_id) 
        ON DELETE CASCADE,
    CONSTRAINT fk_site_manager_site
        FOREIGN KEY (manages)
        REFERENCES site(site_id)
);

CREATE TABLE creature (
    creature_id SERIAL PRIMARY KEY,
    creature_codename VARCHAR(50) UNIQUE NOT NULL,
    contained_in INT,
    creature_type creature_t,
    aggressiveness_level INT,
    class creature_class,
    name VARCHAR(30),
    description VARCHAR(500),

    CONSTRAINT fk_creature_site
        FOREIGN KEY (contained_in) 
        REFERENCES site(site_id)
);

CREATE TABLE ability (
    creature_id INT NOT NULL,
    ability_id INT NOT NULL,
    name VARCHAR(20) NOT NULL,
    description VARCHAR(500),
    frequency INT,
    ability_type creature_t NOT NULL,
    PRIMARY KEY (creature_id, ability_id),

    CONSTRAINT fk_ability_creature 
        FOREIGN KEY (creature_id)
        REFERENCES creature(creature_id)
);

CREATE TABLE agent (
    employee_id INT PRIMARY KEY,
    member_of INT NOT NULL,
    squad_role agent_role NOT NULL,

    CONSTRAINT fk_agent_employee 
        FOREIGN KEY (employee_id)
        REFERENCES employee(employee_id) 
        ON DELETE CASCADE,

    CONSTRAINT fk_agent_squad 
        FOREIGN KEY (member_of)
        REFERENCES squad(squad_id)
);

CREATE TABLE commander (
    employee_id INT PRIMARY KEY, 
    commands INT NOT NULL,

    CONSTRAINT fk_commander_agent 
        FOREIGN KEY (employee_id)
        REFERENCES agent(employee_id) 
        ON DELETE CASCADE,

    CONSTRAINT fk_commander_squad 
        FOREIGN KEY (commands)
        REFERENCES squad(squad_id)
);

-- Tabelas relacionais

CREATE TABLE team_conducts_research (
    team_id INT NOT NULL,
    research_id INT NOT NULL,
    PRIMARY KEY (team_id, research_id),

    CONSTRAINT fk_participating_team 
        FOREIGN KEY (team_id)
        REFERENCES research_team(team_id),

    CONSTRAINT fk_research_being_conducted 
        FOREIGN KEY (research_id)
        REFERENCES research(research_id)
);

CREATE TABLE research_on_creature (
    research_id INT NOT NULL,
    creature_id INT NOT NULL,
    PRIMARY KEY (research_id, creature_id),

    CONSTRAINT fk_research_id 
        FOREIGN KEY (research_id)
        REFERENCES research(research_id),

    CONSTRAINT fk_creature_being_researched 
        FOREIGN KEY (creature_id)
        REFERENCES creature(creature_id)
);

CREATE TABLE squad_mission (
    squad_id INT NOT NULL,
    mission_id INT NOT NULL,
    creature_id INT NULL,
    PRIMARY KEY (squad_id, mission_id),

    CONSTRAINT fk_squad_mission_squad 
        FOREIGN KEY (squad_id)
        REFERENCES squad(squad_id),

    CONSTRAINT fk_squad_mission_mission
        FOREIGN KEY (mission_id)
        REFERENCES mission(mission_id),

    CONSTRAINT fk_creature 
        FOREIGN KEY (creature_id)
        REFERENCES creature(creature_id)
);