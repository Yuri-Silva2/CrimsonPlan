CREATE TABLE tasks(
    id SERIAL UNIQUE PRIMARY KEY NOT NULL,
    previous_tasks_id BIGINT DEFAULT NULL,
    next_tasks_id BIGINT DEFAULT NULL,
    title VARCHAR(30) NOT NULL,
    description TEXT,
    responsible_id BIGINT DEFAULT NULL,
    reserve_responsible_id BIGINT DEFAULT NULL,
    completed BOOLEAN DEFAULT FALSE,
    completion_date TIMESTAMP,
    deadline_date TIMESTAMP NOT NULL,
    sections_id BIGINT NOT NULL,
    CONSTRAINT fk_previous_task FOREIGN KEY(previous_tasks_id) REFERENCES tasks(id),
    CONSTRAINT fk_next_task FOREIGN KEY(next_tasks_id) REFERENCES tasks(id),
    CONSTRAINT fk_responsible FOREIGN KEY(responsible_id) REFERENCES users(id),
    CONSTRAINT fk_reserve_responsible FOREIGN KEY(reserve_responsible_id) REFERENCES users(id),
    CONSTRAINT fk_sections_id FOREIGN KEY (sections_id) REFERENCES sections(id)
);