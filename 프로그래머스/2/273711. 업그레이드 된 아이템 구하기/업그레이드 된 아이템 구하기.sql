-- 코드를 작성해주세요
select c.ITEM_ID, c.ITEM_NAME, c.RARITY
from ITEM_INFO p
join ITEM_TREE t on p.ITEM_ID = t.PARENT_ITEM_ID
join ITEM_INFO c on c.ITEM_ID = t.ITEM_ID
where p.RARITY = 'RARE'
order by c.ITEM_ID desc