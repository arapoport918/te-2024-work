-- 3. For all actors with the last name of "Jones", display the actor's name and movie titles they appeared in. 
-- Order the results by the actor names (A-Z) and then by movie title (A-Z). 
-- (48 rows)

SELECT person_name, title FROM person p 
JOIN movie_actor ma ON ma.actor_id = p.person_id
JOIN movie m USING (movie_id)
WHERE person_name LIKE '% Jones'
ORDER BY person_name ASC, title ASC;