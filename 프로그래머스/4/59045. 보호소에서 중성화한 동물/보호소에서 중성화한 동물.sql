-- 코드를 입력하세요
SELECT a.animal_id, a.animal_type, a.name
from animal_ins a
left join animal_outs b
on a.animal_id = b.animal_id
where a.sex_upon_intake like 'Intact %'
and (b.sex_upon_outcome like '%Spayed%' or b.sex_upon_outcome like '%Neutered%')
order by a.animal_id