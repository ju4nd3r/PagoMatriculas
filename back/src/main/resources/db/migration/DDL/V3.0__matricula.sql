create table matricula (
 matriculaId int(11) not null auto_increment,
 usuarioId int(11) not null,
 ofertaAcademicaId int(11) not null,
 valor double(2) not null,
 primary key (matriculaId),
 foreign key (usuarioId) references usuario(id),
 foreign key (ofertaAcademicaId) references OfertaAcademica(ofertaAcademicaId)
);