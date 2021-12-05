use meiduo;
create table goods(
gid SMALLINT primary key,
gname varchar(50),
gprice FLOAT,
gdate date
);
insert into goods values(1,'茄子',2.25,'2021-11-28'),
(2,'牛肉',37.0,'2021-11-28'),
(3,'绿茶',3,'2021-10-2');

use meiduo;
create table people(
pid varchar(10) primary key,
ppassword varchar(10)
);
insert into people VALUES ('5001190219','12345678'),
('106117','12345678');