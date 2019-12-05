/*script to create truyum database*/
create database if not exixts truyum;

/*script to create change to truyum database*/
use truyum;

/*script to create user table*/

create table if not exists user(
us_id int auto_increment not null,
us_name varchar(60),
primary key(us_id));

/*script to create menu_item table*/
create table if not exists menu_item(
me_id int auto_increment not null,
me_name varchar(100),
me_price numeric(8,2),
me_active varchar(3),
me_date_of_launch date,
me_category varchar(45),
me_free_delivery varchar(3),
primary key(me_id));

/*script to create cart table*/
create table if not exists cart(
ct_id int auto_increment not null,
ct_us_id int,
ct_pr_id int,
primary key(ct_id),
foreign key(ct_us_id) references user(us_id),
foreign key(ct_pr_id) references menu_item(me_id)); 