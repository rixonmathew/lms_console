select count(1) from item_instance_property

select count(1) from item_instance

select count (1) from item_property

select count (1) from item

delete from item_instance_property

delete from item_instance

delete from item_property

delete from item

select * from item


select * from item


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


select * from item_instance_property

select * from item where id = 12976

select * from item_property where item_id = 12976
