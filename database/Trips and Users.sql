# Write your MySQL query statement below
SELECT
    t.Request_at `Day`,
    round(
        sum(
            CASE
            WHEN t. STATUS LIKE 'cancelled_%' THEN
                1
            ELSE
                0
            END
        ) / count(*),
        2
    ) `Cancellation Rate`
FROM
    Trips t
INNER JOIN Users u ON t.Client_Id = u.Users_Id
AND u.Banned = 'No'
WHERE
    t.Request_at BETWEEN '2013-10-01'
AND '2013-10-03'
GROUP BY
    t.Request_at