create schema vectorx;

create table vectorx.tbano(
	id serial,
    ano integer not null unique,
    descricao varchar(255),
	PRIMARY KEY (id)  
);
create table vectorx.tbtipo(
	id serial primary key,
	descricao varchar(50) not null unique
);

create table vectorx.tbdata(
	id serial,
	fkano integer,
	fktipo integer,
	datainicio timestamp  not null,
	datafim timestamp not null,
	descricao varchar(50),
	primary key (id),
	foreign key (fkano) REFERENCES vectorx.tbano(id),
	foreign key (fktipo) REFERENCES vectorx.tbtipo(id)
	
);
insert into vectorx.tbano (ano) values (2015);
insert into vectorx.tbano (ano) values (2016);
insert into vectorx.tbano (ano) values (2013);
insert into vectorx.tbano (ano) values (2014);

insert into vectorx.tbtipo (descricao) values ('Feriado Nacional');
insert into vectorx.tbtipo (descricao) values ('Ponto Facultativo');

insert into vectorx.tbdata (fkano,fktipo,datainicio,datafim,descricao) values (1,1,'2015-01-01 00:00:00','2015-01-01 23:59:59','Confraternização universal');
insert into vectorx.tbdata (fkano,fktipo,datainicio,datafim,descricao) values (1,2,'2015-02-20 00:00:00','2015-02-20 23:59:59','Carnaval');
insert into vectorx.tbdata (fkano,fktipo,datainicio,datafim,descricao) values (1,2,'2015-02-21 00:00:00','2015-02-21 23:59:59','Carnaval');
insert into vectorx.tbdata (fkano,fktipo,datainicio,datafim,descricao) values (1,2,'2015-02-22 00:00:00','2015-02-22 14:00:00','Quarta-feira de Cinzas');
insert into vectorx.tbdata (fkano,fktipo,datainicio,datafim,descricao) values (1,1,'2015-11-02 00:00:00','2015-11-02 23:59:59','Finados');