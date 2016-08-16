# Write your MySQL query statement below
SELECT w1.Id FROM Weather w1, Weather w2
WHERE subdate(w1.Date, 1) = w2.Date AND w1.Temperature > w2.Temperature