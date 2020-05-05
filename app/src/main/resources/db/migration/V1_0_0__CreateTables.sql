create sequence hibernate_sequence start with 1 increment by 1
create table custom_field_defination (id bigint not null, code varchar(25), created_date timestamp, deleted boolean, label varchar(50), modified_date timestamp, type varchar(15), valid_value varchar(255), primary key (id))
create table customer (id bigint not null, created_date timestamp, deleted boolean, email varchar(50), first_name varchar(30), last_name varchar(30), modified_date timestamp, remarks varchar(255), sales_guid varchar(33), primary key (id))
create table customer_extra_attributes (id bigint not null, cf_code varchar(25), cf_value_string varchar(255), customer_id bigint, primary key (id))
create table customer_tags (id bigint not null, tags varchar(50), customer_id bigint, primary key (id))
create table lead (id bigint not null, created_date timestamp, lead_source varchar(15), lead_type varchar(15), remarks varchar(255), sales_guid varchar(33), status varchar(10), title varchar(255), primary key (id))
create table prospect (id bigint not null, amount float, created_date timestamp, deleted boolean, modified_date timestamp, name varchar(15), conversion_probaility float, remarks varchar(255), sales_guid varchar(33), sales_stage varchar(15), primary key (id))
