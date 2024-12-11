-- 16. The names and birthdays of actors born in the 1950s who acted in movies that were released in 1985.
-- Order the results by actor from oldest to youngest.
-- (20 rows)

SELECT DISTINCT person_name, birthday FROM person
JOIN movie_actor ON actor_id = person_id
JOIN movie USING (movie_id)
WHERE (birthday BETWEEN '1949-12-31' AND '1960-01-01') AND (release_date BETWEEN '1984-12-31' AND '1986-01-01')
ORDER BY birthday ASC;