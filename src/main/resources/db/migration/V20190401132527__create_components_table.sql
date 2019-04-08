create table COMPONENT
(
    ID SERIAL NOT NULL
        primary key,
    NAME VARCHAR(24) not null check (NAME <> ''),
    DESCRIPTION VARCHAR(255) not null check ( DESCRIPTION <> '' ),
    WHOLESALE_PRICE DECIMAL
);