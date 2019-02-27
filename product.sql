create table type (
	id serial primary key,
	name varchar(2000)
);


--drop table type cascade;
insert into type(name ) values('молоко');
insert into type(name) values('сыр');
insert into type(name) values('мороженое');
select * from type;


create table product (
	id serial primary key,
	name varchar(2000),
	type_id int references type(id ),
	expired_date timestamp,
	number int,
	price int
);

--drop table product;
insert into product(name, type_id, expired_date, number, price) values('адыгейский', 2, '2019-03-14 24:00:00', 100, 500);
insert into product(name, type_id, expired_date, number, price) values('российский', 2, '2019-10-14 24:00:00', 150, 700);
insert into product(name, type_id, expired_date, number, price) values('голландский', 2, '2019-01-14 24:00:00', 230, 400);
insert into product(name, type_id, expired_date, number, price) values('мороженое чистая линия', 3, '2019-02-20 24:00:00', 9, 70);
insert into product(name, type_id, expired_date, number, price) values('мороженое эскимо', 3, '2019-05-14 24:00:00', 55, 50);
insert into product(name, type_id, expired_date, number, price) values('мороженое талосто', 3, '2019-02-14 24:00:00', 3, 100);
insert into product(name, type_id, expired_date, number, price) values('молоко бурёнка', 1, '2019-03-15 24:00:00', 8, 65);
insert into product(name, type_id, expired_date, number, price) values('молоко луговое', 1, '2019-03-22 24:00:00', 555, 70);
insert into product(name, type_id, expired_date, number, price) values('молоко настоящее', 1, '2019-12-23 24:00:00', 17, 110);
select * from product;



--1. Написать запрос получение всех продуктов с типом "СЫР"
select * from product as u left join type t on u.type_id = t.id
where t.name = 'сыр';

--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
select * from product as u
where u.name like '%мороженое%';

--3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
select * from product as u
where u.expired_date < now() + interval '30 day'
order by name;

--4. Написать запрос, который выводит самый дорогой продукт.
select p.price, p.name from product as p
where p.price = (
  select max(price) from product
  );

--5. Написать запрос, который выводит количество всех продуктов определенного типа.
select
        u.name as product_name,
	u.number
from 
	product as u
where 
	u.type_id = '2' and u.type_id is not null;

--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select * from product as u
where u.type_id = '2' or u.type_id = '1';

--7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.  
select u.name, u.type_id from product as u
where u.number < 10;

--8. Вывести все продукты и их тип.
select 
        p.name as product_name,
        t.name as product_type
from
        product p
        inner join type t on p.type_id = t.id;