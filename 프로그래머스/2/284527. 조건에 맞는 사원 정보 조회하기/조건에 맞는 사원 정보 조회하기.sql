-- 코드를 작성해주세요
select sum(SCORE) as SCORE, g.EMP_NO, EMP_NAME, POSITION, EMAIL
from HR_EMPLOYEES e join HR_DEPARTMENT d on e.DEPT_ID=d.DEPT_ID
                    join HR_GRADE g on g.EMP_NO=e.EMP_NO
where g.year='2022'
group by EMP_NO 
order by SCORE desc
limit 1