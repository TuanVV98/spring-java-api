create table users
(
	user_id int not null auto_increment,
    name nvarchar(50) not null,
    email nvarchar(50) not null,
    password nvarchar(70) not null,
    role nvarchar(10) not null,
    delete_at nvarchar(50) ,
    delete_user nvarchar(50),
    constraint PK_Register primary key(user_id)
);