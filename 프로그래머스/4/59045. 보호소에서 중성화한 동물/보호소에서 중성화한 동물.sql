-- 코드를 입력하세요
SELECT i.animal_id, i.animal_type, i.name
from animal_ins as i
join animal_outs as o on i.animal_id = o.animal_id
where o.sex_upon_outcome <> i.sex_upon_intake
order by i.animal_id