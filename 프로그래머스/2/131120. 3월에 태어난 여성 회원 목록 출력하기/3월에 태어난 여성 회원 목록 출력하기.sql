-- 코드를 입력하세요
SELECT member_id, member_name, gender, date_format(date_of_birth, '%Y-%m-%d') as date_of_birth
from MEMBER_PROFILE
where month(date_of_birth) = 3 and TLNO > 0 and gender = 'W'
order by member_id asc;