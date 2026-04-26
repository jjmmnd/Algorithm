-- 코드를 작성해주세요
select c.id as id, c.genotype as genotype, p.genotype as PARENT_GENOTYPE
from ECOLI_DATA c join ECOLI_DATA p on c.PARENT_ID = p.id
where c.GENOTYPE & p.GENOTYPE = p.GENOTYPE
order by c.id