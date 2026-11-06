CREATE TABLE subjects(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    SLUG VARCHAR(255) NOT NULL UNIQUE,
    display_order INT NOT NULL DEFAULT 0,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

INSERT INTO subjects (name, SLUG, display_order) VALUES
('Polity',      'polity',      1),
    ('History',     'history',     2),
    ('Geography',   'geography',   3),
    ('Economy',     'economy',     4),
    ('Environment', 'environment', 5);