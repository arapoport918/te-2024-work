-- 3. List the first and last name of all authors, separated by a space, (name the column 'author') and the average star rating of their books (name the column 'average_rating').
-- Order by the average rating, lowest first. Where there is a tie in average rating, use a secondary order of author (full name), ascending.
-- (16 rows)

SELECT (p.first_name || ' ' || p.last_name) AS author, AVG(b.star_rating) AS average_rating
FROM person p
JOIN book_author ba ON ba.author_id = p.person_id
JOIN book b ON b.book_id = ba.book_id
GROUP BY author
ORDER BY average_rating, author