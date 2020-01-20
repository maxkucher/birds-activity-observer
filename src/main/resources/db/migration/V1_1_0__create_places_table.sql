create table  if not exists places(
    id serial  PRIMARY KEY,
    label varchar,
    longitude numeric,
    latitude numeric
)
