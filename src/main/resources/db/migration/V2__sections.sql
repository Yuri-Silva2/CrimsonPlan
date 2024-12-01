CREATE TABLE sections(
    id SERIAL UNIQUE PRIMARY KEY NOT NULL,
    title VARCHAR(15) NOT NULL,
    archived BOOLEAN DEFAULT FALSE,
    charts_id BIGINT NOT NULL,
    CONSTRAINT fk_charts_id FOREIGN KEY (charts_id) REFERENCES charts(id)
);