Use desafiomobile2;

create table cliente (
id int auto_increment not null primary key,
nome varchar(255) not null,
cpf varchar(11) not null,
endereco varchar(1000) not null,
datanasc date not null
);

create table pedido (
id int auto_increment not null primary key,
clienteid int not null,
valortotal double not null,
dataped timestamp not null
);

ALTER TABLE pedido
ADD CONSTRAINT `fk_clienteid`
FOREIGN KEY(`clienteid`) REFERENCES `cliente`(`id`);