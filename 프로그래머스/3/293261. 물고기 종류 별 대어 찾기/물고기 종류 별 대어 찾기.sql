-- 코드를 작성해주세요
select ID, FISH_NAME, LENGTH
from FISH_INFO i join FISH_NAME_INFO n on i.FISH_TYPE = n.FISH_TYPE
where (i.FISH_TYPE, LENGTH) in (
    select FISH_TYPE, max(LENGTH)
    from FISH_INFO
    group by FISH_TYPE)
order by ID