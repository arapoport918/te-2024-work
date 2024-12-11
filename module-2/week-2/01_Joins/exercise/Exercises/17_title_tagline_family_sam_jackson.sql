-- 17. The titles and taglines of movies that are in the "Family" genre that Samuel L. Jackson has acted in.
-- Order the results alphabetically by movie title.
-- (4 rows)

SELECT title, tagline FROM movie
JOIN movie_actor USING (movie_id)
JOIN person ON person_id = actor_id
JOIN movie_genre USING (movie_id)
JOIN genre USING (genre_id)
WHERE person_name = 'Samuel L. Jackson' AND genre_name = 'Family'
ORDER BY title ASC;