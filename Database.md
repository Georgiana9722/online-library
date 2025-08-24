create database if not exists online-library;

use online-library;

create table if not exists books(barcode varchar(100) primary key, name varchar(100), author varchar(100), price int, quantity int);

create table if not exists users(username varchar(100) primary key,password varchar(100), firstname varchar(100),lastname varchar(100),address text, phone varchar(100),mailid varchar(100),usertype int);

insert into books values('9780134190523', 'Data Structures Through C++', 'G.S. Blejan', 525, 20);

insert into books values('9780134190564','The Go Programming Language','Alan A. A. Donovan and Brian W. Kernighan',400,8);

insert into books values('978013305254','C++ Primer','Stanley Lippman and Josée Lajoie and Barbara Moo',976,13);

commit;