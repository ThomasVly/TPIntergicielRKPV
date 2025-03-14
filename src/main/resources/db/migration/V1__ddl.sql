CREATE TABLE client
(
    nom text,
    isLogged boolean default false
);

CREATE TABLE msg
(
    id SERIAL PRIMARY KEY,
    expediteur text,
    receveur text,
    message text
)