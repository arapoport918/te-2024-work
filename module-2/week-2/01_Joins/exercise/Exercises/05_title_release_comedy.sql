-- 5. The titles and release dates of all the movies that are in the Comedy genre. 
-- Order the results by release date, earliest to latest. 
-- (220 rows)

SELECT title, release_date FROM movie m 
JOIN movie_genre mg USING (movie_id)
JOIN genre g USING (genre_id)
WHERE genre_name = 'Comedy'
ORDER BY release_date ASC;