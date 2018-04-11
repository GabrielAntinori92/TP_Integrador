create database tp_integrador;
use tp_integrador;

create table ganadores(
	id int auto_increment,
    nombre varchar(20) not null,
    puntos int not null,
    
    constraint PK_id_ganadores primary key(id)
);