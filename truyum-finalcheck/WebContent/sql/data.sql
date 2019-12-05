
/*script to insert data into menu_item table-TYUC001*/
insert into menu_item values(1,'Sandwich',99.00,'Yes','2017-03-15','Main Course','Yes'),
(2,'Burger',129.00,'Yes','2017-12-23','Main Course','No'),
(3,'Pizza',149.00,'Yes','2017-08-21','Main Course','No'),
(4,'French Fries',57.00,'No','2017-07-02','Starters','Yes'),
(5,'Chocolate Brownie',32.00,'Yes','2022-02-11','Dessert','Yes'); 
/*script to fetch data from menu_item table-TYUC001*/
mysql> select me_id, me_name,me_price,me_active,me_date_of_launch from menu_item;


/*script to fetch data from menu_item table-TYUC002*/
mysql> select*from menu_item where me_date_of_launch <=now() and me_active='Yes';


/*script to fetch data from menu_item table-TYUC003*/
mysql> select*from menu_item where me_id=1;
/*script to edit data in menu_item table-TYUC003*/
mysql> update menu_item set me_name='Biscuits',me_price=120.00,me_active='No',me_date_of_launch='2016=02-12',me_category='Starters',me_free_delivery='No' where me_id=3;


/*script to insert data in user table-TYUC004*/
mysql> insert into user values(1,'Ays'),(2,'Naddy');
/*script to insert data in cart table-TYUC004*/
mysql> insert into cart values(1,1,1),(2,1,3),(3,1,5);


/*script to fetch data from menu_item table-TYUC005*/
mysql> select mi.me_id,mi.me_name,mi.me_price,mi.me_active,mi.me_date_of_launch,mi.me_category,mi.me_free_delivery from menu_item mi inner join cart ct on mi.me_id=ct.ct_pr_id and ct.ct_us_id;
/*script to get total price of all menu items in cart-TYUC005*/
mysql> select sum(me_price) from menu_item inner join cart on menu_item.me_id=cart.ct_pr_id and cart.ct_us_id;


/*script to remove data from cart-TYUC006*/
mysql> delete from cart where ct_us_id=1 and ct_pr_id=1;
