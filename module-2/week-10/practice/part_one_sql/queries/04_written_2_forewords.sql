-- 4. List the first and last name of all persons, separated by a space, (name the column 'full_name') who have written at least 2 forewords.
-- Include the count of forewords written by each person (name the column 'foreword_count').
-- Order by full_name ascending.
-- (7 rows)

SELECT p.first_name || ' ' || p.last_name AS full_name, COUNT(b.foreword_by) AS foreword_count
FROM book b
JOIN person p ON b.foreword_by = p.person_id
GROUP BY full_name
HAVING COUNT(b.foreword_by) >= 2
ORDER BY full_name ASC;

