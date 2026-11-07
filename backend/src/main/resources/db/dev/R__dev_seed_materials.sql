INSERT INTO materials (subject_id, day_number, topic, title, content_type, object_key, file_size_bytes, published)
SELECT s.id, v.day_number, v.topic, v.title, 'application/pdf', v.object_key, v.size, v.published
FROM (VALUES
    ('polity',  1, 'Constitution', 'Preamble notes',     'polity/day1/preamble.pdf',  120000, true),
    ('polity',  2, 'Rights',       'Draft rights notes', 'polity/day2/rights.pdf',     90000, false),
    ('history', 1, 'Ancient India','Indus Valley notes', 'history/day1/indus.pdf',    150000, true)
) AS v(slug, day_number, topic, title, object_key, size, published)
JOIN subjects s ON s.slug = v.slug
WHERE NOT EXISTS (SELECT 1 FROM materials m WHERE m.object_key = v.object_key);
