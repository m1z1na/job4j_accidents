CREATE TABLE IF NOT EXISTS accident_types (
  id serial primary key,
  accident_id int references accidents(id) UNIQUE,
  type_id int references types(id)
);