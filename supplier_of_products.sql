create table order (id bigserial not null, supplier_id bigint, primary key (id));
create table orders_products (order_id bigint not null, product_id bigint not null);
create table product (id bigserial not null, title varchar(255), primary key (id));
create table supplier (id bigserial not null, full_name varchar(255), phone varchar(255), primary key (id));
alter table if exists order add constraint FK5p4mrx1khhue6pws5synronys foreign key (supplier_id) references supplier on delete cascade;
alter table if exists orders_products add constraint FK974rl0yjnonmcsyjugya87ssv foreign key (product_id) references product;
alter table if exists orders_products add constraint FKcwfij3cb3reo3c7f5ivqrhcck foreign key (order_id) references order;
