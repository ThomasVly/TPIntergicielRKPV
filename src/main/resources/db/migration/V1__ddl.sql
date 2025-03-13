CREATE TABLE client
(
    nom text,
    isLogged boolean default false
);

CREATE TABLE msg
(
    id integer not null,
    expediteur text,
    receveur text,
    message text
)