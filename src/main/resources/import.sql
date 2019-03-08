create database campeonato;

use campeonato;

CREATE TABLE `partida`(
	`id`int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `time1`varchar(20),
    `time2`varchar(20),
    `local`varchar(20),
	`campeonato_id` int(11) NOT NULL,
    KEY `campeonato_id`(`campeonato_id`),
	CONSTRAINT `emprestimo_ibfk_1` FOREIGN KEY (`campeonato_id`) REFERENCES `campeonato` (`id`))
    ;

    


create table `campeonato`(
	`id` int (11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`nome` varchar(30) NOT NULL,
    `fase` varchar(20) 
    );