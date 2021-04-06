create table OfertaAcademica (
 ofertaAcademicaId int(11) not null auto_increment,
 nivelAcademico varchar(100) not null,
 fechaLimitePago date not null,
 fechaExtraordinariaPago date not null,
 valor double(2) not null,
 primary key (ofertaAcademicaId)
);