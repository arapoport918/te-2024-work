-- 1. The titles and release dates of movies that Tom Hanks has appeared in. 
-- Order the results by release date, newest to oldest.
-- (47 rows)

SELECT title, release_date FROM movie m 
JOIN movie_actor ma USING(movie_id)
JOIN person p ON p.person_id = ma.actor_id
WHERE p.person_name = 'Tom Hanks'
ORDER BY m.release_date DESC;