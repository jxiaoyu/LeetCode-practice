# Write your MySQL query statement below

# if you're doing an UPDATE/INSERT/DELETE on a table, you can't reference that table in an inner query (you can however reference a field from that outer table...)

DELETE
FROM
    Person
WHERE
    Id NOT IN (
        SELECT
            Id
        FROM
            (
                SELECT
                    min(Id) AS Id
                FROM
                    Person
                GROUP BY
                    Email
            ) p
    );