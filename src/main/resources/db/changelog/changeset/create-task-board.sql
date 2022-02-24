CREATE TABLE IF NOT EXISTS status
(
    id serial PRIMARY KEY,
    status_definition varchar(20)
);

CREATE TABLE IF NOT EXISTS  employee
(
    id serial PRIMARY KEY,
    surname varchar(60),
    name varchar(60)
);

CREATE TABLE IF NOT EXISTS  release_version
(
    id serial PRIMARY KEY,
    start_date date,
    finish_date date
);

CREATE TABLE IF NOT EXISTS  tasks
(
    id serial PRIMARY KEY,
    task_name varchar(255),
    status_id int REFERENCES status,
    author_id int REFERENCES employee,
    developer_id int REFERENCES employee,
    release_version_id int REFERENCES release_version
);