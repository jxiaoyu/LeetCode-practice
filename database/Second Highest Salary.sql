# 这题明明是 Nth Highest Salary 的特例，但不知道为什么 Nth 那道就不需要 if 判断

# Write your MySQL query statement below
SELECT

IF (
    COUNT(Salary) >= 0,
    Salary,
    NULL
)
FROM
    (
        SELECT DISTINCT
            Salary
        FROM
            Employee
        ORDER BY
            Salary DESC
        LIMIT 1,
        1
    ) AS Unique_Salary;
    
# 另一种写法
SELECT
    max(Salary) AS SecondHighestSalary
FROM
    Employee
WHERE
    Salary < (
        SELECT
            max(Salary)
        FROM
            Employee
    )