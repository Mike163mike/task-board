CREATE TABLE IF NOT EXISTS employee
(
    id      serial PRIMARY KEY,
    surname varchar(60),
    name    varchar(60)
);

CREATE TABLE IF NOT EXISTS version_release
(
    id          serial PRIMARY KEY,
    start_date  date,
    finish_date date
);

CREATE TABLE IF NOT EXISTS project
(
    id   serial PRIMARY KEY,
    name varchar(60)
);

CREATE TABLE IF NOT EXISTS board
(
    id         serial PRIMARY KEY,
    project_id int REFERENCES project
);

CREATE TABLE IF NOT EXISTS task
(
    id                 serial PRIMARY KEY,
    name               varchar(255),
    status             character varying,
    author_id          int REFERENCES employee,
    developer_id       int REFERENCES employee,
    version_release_id int REFERENCES version_release,
    board_id           int REFERENCES board
);

--rollback drop table employee, version_release, project, board, task;