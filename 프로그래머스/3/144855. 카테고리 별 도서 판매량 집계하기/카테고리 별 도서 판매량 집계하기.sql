-- 코드를 입력하세요
SELECT CATEGORY, sum(SALES) as TOTAL_SALES
from BOOK b join BOOK_SALES s on b.BOOK_ID = s.BOOK_ID
where date_format(SALES_DATE, '%Y-%m') = '2022-01'
group by CATEGORY
order by CATEGORY