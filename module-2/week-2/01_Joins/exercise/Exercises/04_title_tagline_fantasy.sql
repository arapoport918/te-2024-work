-- 4. The titles and taglines of all the movies that are in the Fantasy genre. 
-- Order the results by title (A-Z).
-- (81 rows)

SELECT title, tagline FROM movie m 
JOIN movie_genre mg USING (movie_id)
JOIN genre g USING (genre_id)
WHERE genre_name = 'Fantasy'
ORDER BY title;