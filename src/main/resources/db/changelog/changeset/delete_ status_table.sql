--liquibase formatted sql
--changeset user:Mike
--context:test
--preconditions onFail:CONTINUE onError:CONTINUE

DROP TABLE status CASCADE;