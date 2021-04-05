CREATE TABLE account (
                         id SERIAL PRIMARY KEY,
                         name TEXT,
                         email TEXT,
                         phone TEXT,
                         UNIQUE (phone)
);

CREATE TABLE ticket (
                        id SERIAL PRIMARY KEY,
                        row integer,
                        cell integer,
                        account_id integer,
                        UNIQUE (row, cell)
);