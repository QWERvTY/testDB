DROP TABLE IF EXISTS user;

CREATE TABLE user(
	id VARCHAR(20) PRIMARY KEY,
	name VARCHAR(20) NOT NULL,
	location VARCHAR(14),
	birthday TIMESTAMP

);

INSERT INTO user (id, name, location, birthday) VALUES ('user2', 'YS', 'Busan', '19961204');

