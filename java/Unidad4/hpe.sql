select cloth_uuid from hpe.clothes
where production_date = ('14182cb2-0a15-48d5-9adf-b89169ad84e3__3bb8d1bc-c794-415d-9d72-ec70c69127d0__3f8cceac-00f1-49dc-bab1-ade63fb57ffd');

select turn_uuid from hpe.turns
where substr(start_hour, 3) in (
	select hour_uuid from hpe.hours
    where hour >= 8 AND hour <= 23
) AND substr(end_hour, 3) in (
	select hour_uuid from hpe.hours
    where hour >= 9 AND (hour <= 23 OR hour = 0)
);

select s.keyword from distribution_log d join stores s on destination_store = (s.store_uuid_1 + s.store_uuid_2 + s.store_uuid_3 + s.store_uuid_4 departamentos+ s.store_uuid_5);

