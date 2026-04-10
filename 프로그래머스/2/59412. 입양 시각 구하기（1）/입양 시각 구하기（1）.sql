-- 코드를 입력하세요
SELECT hour(DATETIME) as HOUR, count(*) as COUNT
from ANIMAL_OUTS
where (hour(DATETIME) between 9 and 19) and 
    (minute(DATETIME) between 00 and 59)
group by HOUR
order by HOUR