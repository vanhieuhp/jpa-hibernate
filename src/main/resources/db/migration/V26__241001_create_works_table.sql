CREATE TABLE if not exists workers
(
    id   VARCHAR(255) NOT NULL,
    name VARCHAR(255) NULL,
    CONSTRAINT pk_workers PRIMARY KEY (id)
);

CREATE TABLE if not exists worker_tasks
(
    id        VARCHAR(255) NOT NULL,
    name      VARCHAR(255) NULL,
    worker_id VARCHAR(255) NULL,
    CONSTRAINT pk_worker_tasks PRIMARY KEY (id)
);

ALTER TABLE worker_tasks
    ADD CONSTRAINT FK_WORKER_TASKS_ON_WORKER FOREIGN KEY (worker_id) REFERENCES workers (id);