CREATE TABLE client
(
    nom text
);

CREATE TABLE msg
(
    id integer not null,
    expediteur text,
    receveur text,
    message text
)