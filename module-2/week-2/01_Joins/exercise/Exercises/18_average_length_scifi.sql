-- 18. The average length of movies in the "Science Fiction" genre. Name the column 'average_length'.
-- (1 row, expected result between 110-120)

SELECT AVG(length_minutes) AS average_length FROM movie
JOIN movie_genre USING (movie_id)
JOIN genre USING (genre_id)
WHERE genre_name = 'Science Fiction';