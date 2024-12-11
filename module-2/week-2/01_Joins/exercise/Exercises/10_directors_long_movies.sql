-- 10. The names of directors who have directed a movie over 3 hours [180 minutes], sorted alphabetically.
-- (15 rows)

SELECT DISTINCT person_name FROM person
JOIN movie ON director_id = person_id
WHERE length_minutes > 180
ORDER BY person_name ASC;