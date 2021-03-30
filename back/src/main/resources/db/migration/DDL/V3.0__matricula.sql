create table matricula (
 id int(11) not null auto_increment,
 id_usuario int(11) not null,
 id_oferta_academica int(11) not null,
 primary key (id),
 foreign key (id_usuario) references usuario(id),
 foreign key (id_oferta_academica) references oferta_academica(id)
);