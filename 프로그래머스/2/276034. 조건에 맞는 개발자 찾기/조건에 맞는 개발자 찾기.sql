-- 코드를 작성해주세요
select distinct id, email, FIRST_NAME, LAST_NAME
from DEVELOPERS as d join SKILLCODES as s on d.SKILL_CODE & s.CODE > 0
where s.NAME in ('C#', 'Python')
order by id