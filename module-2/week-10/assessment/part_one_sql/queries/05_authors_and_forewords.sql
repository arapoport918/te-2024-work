-- 5. List all book titles and the first and last name of the person who wrote the foreword (name the column 'foreword_author') for books that Moishe Reiling was an author.
-- Order by book title (A-Z).
-- Tip: make sure to add a space between the author's first and last names.
-- (5 rows)

SELECT b.book_title, p.first_name || ' ' || p.last_name AS foreword_author FROM person p
JOIN book b ON b.foreword_by = p.person_id
JOIN book_author ba USING(book_id)
JOIN person fb ON b.foreword_by = fb.person_id
WHERE ba.author_id = 3 
ORDER BY b.book_title;
