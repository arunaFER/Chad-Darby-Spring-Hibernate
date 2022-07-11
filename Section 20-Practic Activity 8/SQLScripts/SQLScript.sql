drop table if exists employee;

create table employee (
	id int(11) not null auto_increment,
    first_name varchar(45) default null,
    last_name varchar(45) default null,
    company varchar(45) default null,
    primary key(id)
)