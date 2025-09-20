-- 코드를 입력하세요
SELECT month(start_date) as month, car_id, count(*) as records
from car_rental_company_rental_history
where start_date between '2022-08-01' and '2022-10-31'
    and car_id in
    (
        select car_id
        from car_rental_company_rental_history
        where start_date between '2022-08-01' and '2022-10-31'
        group by car_id having count(*) >= 5
    )
group by car_id, month having records > 0
order by month asc, car_id desc;
