create table product_component
(
    id serial not null
        constraint product_components_pk
            primary key,
    quantity int not null,
    component_id integer
        constraint product_components_component_id_fk
            references component,
    product_id integer
        constraint product_components_product_id_fk
            references product

);