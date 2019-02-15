create table type (
	id varchar(2000) primary key
);


drop table type cascade;
insert into type(id ) values('молоко');
insert into type(id ) values('сыр');
insert into type(id ) values('мороженое');
select * from type;


create table product (
	id serial primary key,
	name varchar(2000),
	type_id varchar(2000) references type(id ),
	expired_date timestamp,
	price int
);

drop table product;
insert into product(name, type_id, expired_date, price) values('адыгейский', 'сыр', '2019-03-14 24:00:00', 500);
insert into product(name, type_id, expired_date, price) values('российский', 'сыр', '2019-10-14 24:00:00', 700);
insert into product(name, type_id, expired_date, price) values('голландский', 'сыр', '2019-01-14 24:00:00', 400);
insert into product(name, type_id, expired_date, price) values('мороженое чистая линия', 'мороженое', '2019-02-20 24:00:00', 70);
insert into product(name, type_id, expired_date, price) values('мороженое эскимо', 'мороженое', '2019-05-14 24:00:00', 50);
insert into product(name, type_id, expired_date, price) values('мороженое талосто', 'мороженое', '2019-02-14 24:00:00', 100);
insert into product(name, type_id, expired_date, price) values('молоко бурёнка', 'молоко', '2019-03-15 24:00:00', 65);
insert into product(name, type_id, expired_date, price) values('молоко луговое', 'молоко', '2019-03-22 24:00:00', 70);
insert into product(name, type_id, expired_date, price) values('молоко настоящее', 'молоко', '2019-12-23 24:00:00', 110);
select * from product;



--1. Написать запрос получение всех продуктов с типом "СЫР"
select * from product as u
where u.type_id = 'сыр';

--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
select * from product as u
where u.name like '%мороженое%';

--3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
select * from product as u
where u.expired_date between '2019-03-01 00:00:00' and '2019-04-01 00:00:00';

--4. Написать запрос, который выводит самый дорогой продукт.
select max(u.price) from product as u;

--5. Написать запрос, который выводит количество всех продуктов определенного типа.
select count(*) from product as u
where u.type_id = 'сыр' and u.type_id is not null;

--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select count(*) from product as u
where u.type_id = 'сыр' or u.type_id = 'молоко';

--7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.  
select * from product as u
where u.expired_date < now() + interval '10 day';

--8. Вывести все продукты и их тип.
select (c.name, i.id) from type as i
inner join product as c on i.id = c.type_id;
