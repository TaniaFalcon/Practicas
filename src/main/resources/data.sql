insert into userdata (iduser, username, password) values(nextval('erp.usersequence'),'tania','1234');
insert into userdata (iduser, username, password) values(nextval('erp.usersequence'),'kilian','1234');
insert into itemdata (iditem, itemcode, description, state, price, creationdate, username) values(nextval('erp.itemsequence'),'345','descripcion1','ACTIVE','2343',now(),1);
insert into itemdata (iditem, itemcode, description, state, price, creationdate, username) values(nextval('erp.itemsequence'),'248','descripcion2','DISCONTINUED','520',now(),1);
insert into itemdata (iditem, itemcode, description, state, price, creationdate, username) values(nextval('erp.itemsequence'),'145','descripcion3','ACTIVE','1547',now(),1);
insert into pricereduction (idpricereduction, reducedprice, startdate, enddate, iditem) values(nextval('erp.pricereductionsequence'),'100','2023-03-20','2023-04-20',1);
insert into supplier (idsupplier, name, country) values (nextval('erp.suppliersequence'),'Empresa1','Spain');
insert into item_supplier (iditem, idsupplier) values (1,1);
insert into desactiveitems (iddesactive, reason, register, item, username) values (nextval('erp.desactivesequence'),'FLAW',now(),2,1);