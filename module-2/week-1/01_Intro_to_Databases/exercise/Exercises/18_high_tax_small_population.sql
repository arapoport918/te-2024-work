-- 18. The name, population, and sales tax of all records in the state table with a sales tax of at least 7% or have a population of less than 1,000,000 (17 rows)

SELECT state_name, population, sales_tax FROM state WHERE population < 1000000 OR sales_tax >= 7;