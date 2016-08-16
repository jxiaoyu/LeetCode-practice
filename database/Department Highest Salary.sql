# Write your MySQL query statement below
SELECT
    dep. NAME AS Department,
    emp. NAME AS Employee,
    emp.Salary
FROM
    Department dep,
    Employee emp
WHERE
    emp.DepartmentId = dep.Id
AND emp.Salary = (
    SELECT
        max(Salary)
    FROM
        Employee e2
    WHERE
        e2.DepartmentId = dep.Id
)