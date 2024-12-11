-- 8. The genres of movies that Robert De Niro has appeared in that were released in 2010 or later, sorted alphabetically.
-- (6 rows)

SELECT DISTINCT genre_name from genre
JOIN movie_genre USING (genre_id)
JOIN movie USING (movie_id)
JOIN movie_actor ma USING (movie_id)
JOIN person p ON p.person_id = ma.actor_id
WHERE person_name = 'Robert De Niro' AND release_date > '2009-12-31'
ORDER BY genre_name;