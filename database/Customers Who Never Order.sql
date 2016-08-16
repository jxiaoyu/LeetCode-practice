# Write your MySQL query statement below
select Name as Customers from Customers a left join Orders b on a.Id = b.CustomerId  where ISNULL(b.CustomerId)