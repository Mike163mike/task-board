--liquibase formatted sql
--changeset user:Mike
--preconditions onFail:CONTINUE onError:CONTINUE

ALTER TABLE employee ADD COLUMN email varchar(255);

ALTER TABLE employee ADD COLUMN password varchar(255);

--rollback delete from employee column email, password;