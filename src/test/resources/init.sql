CREATE TABLE player
(
    id               BIGSERIAL  ,
    first_name       VARCHAR(255),
    last_name        VARCHAR(255),
    club_id          BIGINT NOT NULL,
    number           INT,
    goals            INT,
    assist           INT,
    age              INT,
    position         VARCHAR(255),
    national_team_id BIGINT,
    is_Active        BOOLEAN
);
CREATE TABLE club
(
    id            BIGSERIAL  ,
    club_name     VARCHAR(255) NOT NULL UNIQUE,
    count_players INT,
    year          INT
);
CREATE TABLE national_team
(
    id                 BIGSERIAL  ,
    national_team_name VARCHAR(255) NOT NULL UNIQUE,
    count_players      INT
);
CREATE TABLE transfer_history
(
    id               BIGSERIAL ,
    player_id        BIGINT       NOT NULL,
    player_last_name VARCHAR(255) NOT NULL,
    last_club_name   VARCHAR(255) NOT NULL,
    new_club_name    VARCHAR(255) NOT NULL,
    price            BIGINT       NOT NULL
);