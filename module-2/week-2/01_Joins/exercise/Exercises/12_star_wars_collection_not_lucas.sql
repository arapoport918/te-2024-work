-- 12. The titles of the movies in the "Star Wars Collection" that weren't directed by George Lucas, sorted alphabetically.
-- (5 rows)

SELECT title FROM movie
JOIN collection USING (collection_id)
JOIN person ON person_id = director_id
WHERE person_name != 'George Lucas' AND collection_name = 'Star Wars Collection'
ORDER BY title ASC;