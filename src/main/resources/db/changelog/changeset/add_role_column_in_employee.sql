--liquibase formatted sql
--changeset user:Mike
--preconditions onFail:CONTINUE onError:CONTINUE

ALTER TABLE employee ADD COLUMN role character varying;

--rollback delete from employee column email, password;