create table orders_products (order_id bigint not null, product_id bigint not null);
create table product (id bigserial not null, title varchar(255), primary key (id));
create table product_order (id bigserial not null, supplier_id bigint, primary key (id));
create table supplier (id bigserial not null, full_name varchar(255), phone varchar(255), primary key (id));
alter table if exists orders_products add constraint FK974rl0yjnonmcsyjugya87ssv foreign key (product_id) references product;
alter table if exists orders_products add constraint FKjn32cmwq6ajmcpu70t3h1c110 foreign key (order_id) references product_order;
alter table if exists product_order add constraint FKdjkpcnrh61m0o1qymcqlmsuhw foreign key (supplier_id) references supplier on delete cascade;

