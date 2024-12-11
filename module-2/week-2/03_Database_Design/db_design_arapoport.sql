START TRANSACTION;

CREATE TABLE member (
	member_id serial,
	last_name varchar(50) NOT NULL,
	first_name varchar (50) NOT NULL,
	email_address varchar (50) NOT NULL,
	phone_number varchar(50),
	date_of_birth date NOT NULL,
	reminder_emails boolean NOT NULL,
	CONSTRAINT PK_member PRIMARY KEY (member_id)
);

CREATE TABLE interest (
	group_id serial,
	name varchar(50) NOT NULL,
	CONSTRAINT PK_group PRIMARY KEY (group_id),
	CONSTRAINT UQ_group_name UNIQUE (name)
);

CREATE TABLE event (
	event_id serial,
	name varchar(50) NOT NULL,
	start_date_and_time timestamp NOT NULL,
	duration numeric(5, 2) NOT NULL,
	group_id int,
	CONSTRAINT PK_event PRIMARY KEY (event_id),
	CONSTRAINT FK_event_group FOREIGN KEY (group_id) REFERENCES interest (group_id),
	CONSTRAINT CHK_duration CHECK (duration >= 0.50)
);

CREATE TABLE member_interest (
	member_id int NOT NULL,
	group_id int NOT NULL,
	CONSTRAINT PK_member_interest PRIMARY KEY (member_id, group_id)
);

CREATE TABLE member_event (
	member_id int NOT NULL,
	event_id int NOT NULL,
	CONSTRAINT PK_member_event PRIMARY KEY (member_id, event_id)
);

INSERT INTO member (last_name, first_name, email_address, phone_number, date_of_birth, reminder_emails)
VALUES ('Hurts', 'Jalen', 'jalen.hurts@eagles.com', NULL, '1998-08-07', FALSE),
('Leclerc', 'Charles', 'charles_leclerc@ferrari.it', NULL, '1997-10-26', TRUE),
('Carey', 'Mariah', 'christmas_queen@gmail.com', NULL, '1969-03-27', FALSE),
('Girma', 'Naomi', 'naomi_girma@sdwave.com', NULL, '2000-06-14', TRUE),
('Swift', 'Taylor', 'tswift13@gmail.com', NULL, '1989-12-13', FALSE),
('Smith', 'Sophia', 'ssmith@uswnl.com', NULL, '2000-08-10', FALSE),
('Reynolds', 'Ryan', 'not_not_deadpool@hotmail.com', NULL, '1976-10-23', TRUE),
('McElhenney', 'Rob', 'mac@fightmilk.com', NULL, '1977-04-14', TRUE);

INSERT INTO interest (name) 
VALUES ('Sports'),
('Music'),
('Entertainment');

INSERT INTO event (name, start_date_and_time, duration, group_id) 
VALUES ('Playoffs', '2024-01-15 20:00:00 EST', 4.0, (SELECT group_id FROM interest WHERE name = 'Sports')),
('Monaco Grand Prix', '2024-05-26 09:00:00 EST', 2.5, (SELECT group_id FROM interest WHERE name = 'Sports')),
('Concert', '2024-10-18 20:00:00 EST', 3.25, (SELECT group_id FROM interest WHERE name = 'Music')),
('Movie Premiere', '2024-04-20 18:00:00', 1.0, (SELECT group_id FROM interest WHERE name = 'Entertainment'));

INSERT INTO member_interest (member_id, group_id)
VALUES ((SELECT member_id FROM member WHERE last_name = 'Hurts'), (SELECT group_id FROM interest WHERE name = 'Sports')),
((SELECT member_id FROM member WHERE last_name = 'Leclerc'), (SELECT group_id FROM interest WHERE name = 'Sports')),
((SELECT member_id FROM member WHERE last_name = 'Carey'), (SELECT group_id FROM interest WHERE name = 'Music')),
((SELECT member_id FROM member WHERE last_name = 'Girma'), (SELECT group_id FROM interest WHERE name = 'Sports')),
((SELECT member_id FROM member WHERE last_name = 'Smith'), (SELECT group_id FROM interest WHERE name = 'Sports')),
((SELECT member_id FROM member WHERE last_name = 'Swift'), (SELECT group_id FROM interest WHERE name = 'Music')),
((SELECT member_id FROM member WHERE last_name = 'Reynolds'), (SELECT group_id FROM interest WHERE name = 'Entertainment')),
((SELECT member_id FROM member WHERE last_name = 'McElhenney'), (SELECT group_id FROM interest WHERE name = 'Entertainment'));

INSERT INTO member_event (member_id, event_id) 
VALUES ((SELECT member_id FROM member WHERE last_name = 'Hurts'), (SELECT event_id FROM event WHERE name = 'Playoffs')),
((SELECT member_id FROM member WHERE last_name = 'Hurts'), (SELECT event_id FROM event WHERE name = 'Monaco Grand Prix')),
((SELECT member_id FROM member WHERE last_name = 'Leclerc'), (SELECT event_id FROM event WHERE name = 'Monaco Grand Prix')),
((SELECT member_id FROM member WHERE last_name = 'Swift'), (SELECT event_id FROM event WHERE name = 'Monaco Grand Prix')),
((SELECT member_id FROM member WHERE last_name = 'Reynolds'), (SELECT event_id FROM event WHERE name = 'Monaco Grand Prix')),
((SELECT member_id FROM member WHERE last_name = 'McElhenney'), (SELECT event_id FROM event WHERE name = 'Monaco Grand Prix')),
((SELECT member_id FROM member WHERE last_name = 'Smith'), (SELECT event_id FROM event WHERE name = 'Playoffs')),
((SELECT member_id FROM member WHERE last_name = 'Girma'), (SELECT event_id FROM event WHERE name = 'Playoffs')),
((SELECT member_id FROM member WHERE last_name = 'Swift'), (SELECT event_id FROM event WHERE name = 'Playoffs')),
((SELECT member_id FROM member WHERE last_name = 'Swift'), (SELECT event_id FROM event WHERE name = 'Concert')),
((SELECT member_id FROM member WHERE last_name = 'Carey'), (SELECT event_id FROM event WHERE name = 'Concert')),
((SELECT member_id FROM member WHERE last_name = 'Reynolds'), (SELECT event_id FROM event WHERE name = 'Concert')),
((SELECT member_id FROM member WHERE last_name = 'Reynolds'), (SELECT event_id FROM event WHERE name = 'Movie Premiere')),
((SELECT member_id FROM member WHERE last_name = 'McElhenney'), (SELECT event_id FROM event WHERE name = 'Movie Premiere'));

COMMIT;

