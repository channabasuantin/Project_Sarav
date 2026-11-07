CREATE TABLE materials (
    id              BIGSERIAL PRIMARY KEY,
    subject_id      BIGINT       NOT NULL REFERENCES subjects(id),
    day_number      INT          NOT NULL,
    topic           VARCHAR(255) NOT NULL,
    title           VARCHAR(255) NOT NULL,
    content_type    VARCHAR(100) NOT NULL,
    object_key      VARCHAR(500) NOT NULL,
    file_size_bytes BIGINT       NOT NULL DEFAULT 0,
    published       BOOLEAN      NOT NULL DEFAULT FALSE,
    created_at      TIMESTAMPTZ  NOT NULL DEFAULT NOW()
);

CREATE INDEX idx_materials_subject_day ON materials(subject_id, day_number);


