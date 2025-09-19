-- 코드를 작성해주세요
select f.id, n.fish_name, f.length
from fish_info as f
join fish_name_info as n on f.fish_type = n.fish_type
where f.fish_type in
(
    select fish_type
    from fish_info
    group by fish_type having length = max(length)
)
order by f.id asc;