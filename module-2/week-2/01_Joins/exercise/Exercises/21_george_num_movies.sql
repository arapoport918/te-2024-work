-- 21. For every person in the person table with the first name of "George", list the number of movies they've been in. Name the count column 'num_of_movies'.
-- Include all Georges, even those that have not appeared in any movies. Display the names in alphabetical order. 
-- (59 rows)

SELECT person_name, COUNT(title) AS num_of_movies FROM person
LEFT OUTER JOIN movie_actor ON actor_id = person_id 
LEFT OUTER JOIN movie USING (movie_id)
WHERE person_name LIKE 'George %' 
GROUP BY person_id
ORDER BY person_name ASC;