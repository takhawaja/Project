create table JOB_STAGE
(
    ID SERIAL NOT NULL primary key,
    NAME varchar(24) not null check (NAME <> ''),
    ORDINAL int not null
);

create table CUSTOMER
(
    ID SERIAL NOT NULL primary key,
    NAME varchar(24) not null check (NAME <> ''),
    ADDRESS varchar(24) not null check (ADDRESS <> ''),
    PHONE varchar(24) not null check (PHONE <> '')
);


create table PRODUCT
(
    ID SERIAL NOT NULL primary key,
    NAME varchar(24) not null check (NAME <> ''),
    DESCRIPTION varchar(24)
);


create table JOB
(
    ID SERIAL NOT NULL
        primary key,
    NAME VARCHAR(24) not null check (NAME <> ''),
    DESCRIPTION VARCHAR(255) not null check ( DESCRIPTION <> '' ),
    JOB_STAGE_ID INT NOT NULL,
    CUSTOMER_ID INT NOT NULL,
    PRODUCT_ID INT NOT NULL,
    foreign key (PRODUCT_ID) references PRODUCT(ID),
    foreign key (CUSTOMER_ID) references customer(ID),
    foreign key (JOB_STAGE_ID) references JOB_STAGE(ID)

);

insert into JOB_STAGE(name,ORDINAL) values('Pre-Production',1);
insert into JOB_STAGE(name,ORDINAL) values('Production',2);
insert into JOB_STAGE(name,ORDINAL) values('Close-Out',3);







