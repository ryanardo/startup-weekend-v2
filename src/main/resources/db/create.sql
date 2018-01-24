SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS events (
    idEvent INT PRIMARY KEY auto_increment,
    eventTitle VARCHAR,
    eventDescription VARCHAR
);

CREATE TABLE IF NOT EXISTS attendees (
    idAttendee INT PRIMARY KEY auto_increment,
    eventId INTEGER,
    attendeeName VARCHAR
);