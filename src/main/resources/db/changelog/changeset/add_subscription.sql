--liquibase formatted sql
--changeset user:Mike
--preconditions onFail:CONTINUE onError:CONTINUE

ALTER TABLE employee ADD COLUMN subscription boolean;

--rollback delete from employee column subscription;