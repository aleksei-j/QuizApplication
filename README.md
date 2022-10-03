SQL script

CREATE TABLE question (id serial PRIMARY KEY, question varchar(80), topic varchar(80), difficulty_level int);
CREATE TABLE answers (id serial PRIMARY KEY, question_Id int, answer varchar(80), is_correct boolean);

INSERT INTO question (question, topic, difficulty_level) VALUES ('In which Italian city can you find the Colosseum?','Geography',1);
INSERT INTO answers (question_id, answer, is_correct) VALUES (1, 'Venice', false);
INSERT INTO answers (question_id, answer, is_correct) VALUES (1, 'Rome', true);
INSERT INTO answers (question_id, answer, is_correct) VALUES (1, 'Naples', false);
INSERT INTO answers (question_id, answer, is_correct) VALUES (1, 'Milan', false);

INSERT INTO question (question, topic, difficulty_level) VALUES ('In the TV show New Girl, which actress plays Jessica Day?','People',4);
INSERT INTO answers (question_id, answer, is_correct) VALUES (2, 'Zooey Deschanel', true);
INSERT INTO answers (question_id, answer, is_correct) VALUES (2, 'Kaley Cuoco', false);
INSERT INTO answers (question_id, answer, is_correct) VALUES (2, 'Jennifer Aniston', false);
INSERT INTO answers (question_id, answer, is_correct) VALUES (2, 'Alyson Hannigan', false);

INSERT INTO question (question, topic, difficulty_level) VALUES ('What is the largest canyon in the world?','Geography',1);
INSERT INTO answers (question_id, answer, is_correct) VALUES (3, 'Verdon Gorge, France', false);
INSERT INTO answers (question_id, answer, is_correct) VALUES (3, 'King’s Canyon, Australia', false);
INSERT INTO answers (question_id, answer, is_correct) VALUES (3, 'Grand Canyon, USA', true);
INSERT INTO answers (question_id, answer, is_correct) VALUES (3, 'Fjaðrárgljúfur Canyon, Iceland', false);

INSERT INTO question (question, topic, difficulty_level) VALUES ('How long is the border between the United States and Canada?','Geography',1);
INSERT INTO answers (question_id, answer, is_correct) VALUES (4, '3,525 miles', false);
INSERT INTO answers (question_id, answer, is_correct) VALUES (4, '4,525 miles', false);
INSERT INTO answers (question_id, answer, is_correct) VALUES (4, '5,525 miles', true);
INSERT INTO answers (question_id, answer, is_correct) VALUES (4, '6,525 miles', false);

INSERT INTO question (question, topic, difficulty_level) VALUES ('What is the largest active volcano in the world?','Geography',3);
INSERT INTO answers (question_id, answer, is_correct) VALUES (5, 'Mount Etna', false);
INSERT INTO answers (question_id, answer, is_correct) VALUES (5, 'Mount Vesuvius', false);
INSERT INTO answers (question_id, answer, is_correct) VALUES (5, 'Mouna Loa', true);
INSERT INTO answers (question_id, answer, is_correct) VALUES (5, 'Mount Batur', false);

INSERT INTO question (question, topic, difficulty_level) VALUES ('When did Lenin die?','People',4);
INSERT INTO answers (question_id, answer, is_correct) VALUES (6, '21 January 1924', true);
INSERT INTO answers (question_id, answer, is_correct) VALUES (6, '21 January 1934', false);
INSERT INTO answers (question_id, answer, is_correct) VALUES (6, '21 January 1944', false);
INSERT INTO answers (question_id, answer, is_correct) VALUES (6, '21 January 1954', false);

INSERT INTO question (question, topic, difficulty_level) VALUES ('When was the book “To Kill a Mockingbird” by Harper Lee published?','Literature',4);
INSERT INTO answers (question_id, answer, is_correct) VALUES (7, '1950', false);
INSERT INTO answers (question_id, answer, is_correct) VALUES (7, '1960', true);
INSERT INTO answers (question_id, answer, is_correct) VALUES (7, '1970', false);
INSERT INTO answers (question_id, answer, is_correct) VALUES (7, '1980', false);
