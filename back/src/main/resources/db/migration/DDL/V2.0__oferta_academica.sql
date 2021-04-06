create table oferta_academica (
 id int(11) not null auto_increment,
 nivel_academico varchar(100) not null,
 fecha_limite_pago date not null,
 fecha_extraordinaria_pago date not null,
 valor double(2) not null,
 primary key (id)
);