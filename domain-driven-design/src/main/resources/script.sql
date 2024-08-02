create table persons (
                         id bigserial,
                         name varchar(255) not null,
                         age int not null,
                         constraint persons_id_pk primary key(id)
);

insert into persons (name, age)
values ('Carlos', 15);

insert into persons (name, age)
values ('Angela', 31);

insert into persons (name, age)
values ('Joao', 18);