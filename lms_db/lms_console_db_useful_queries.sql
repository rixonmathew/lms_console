#query to see all books properties
SELECT it.id,
       it.name,
       it.description,
       it.item_type_id,
       it_ty.type,
       it_prop.property_id,
       prop.name,
       it_prop.property_value      
  FROM item it,
       item_property it_prop,
       property prop,
       item_type it_ty   
 where it.id = it_prop.item_id
   and prop.id = it_prop.property_id
   and it_ty.id = it.item_type_id
   
 --To see all sequences
SELECT * FROM information_schema.sequences


--To see teh count of instances available for each item
select it.id item_id,
       it.name,
       it.description,
       it_ty.type as item_type,
       count(1) as items_available
   from item it,
        item_type it_ty,
        item_instance it_in
  where it.item_type_id = it_ty.id
    and it_in.item_id = it.id
    and it.name like '%Charlie%'
group by it.id,it.name,it.description,it_ty.type