# Write your MySQL query statement below
SELECT
    d.NAME Department,
    e1.NAME Employee,
    e1.Salary
FROM
    Employee e1
INNER JOIN Department d ON e1.DepartmentId = d.Id
WHERE
    3 > (
        SELECT
            count(DISTINCT(e2.Salary))
        FROM
            Employee e2
        WHERE
            e2.Salary > e1.Salary
        AND e1.DepartmentId = e2.DepartmentId
    );