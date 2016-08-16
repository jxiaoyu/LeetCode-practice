# Write your MySQL query statement below
SELECT
    Score,
    (
        SELECT
            COUNT(DISTINCT score)
        FROM
            Scores
        WHERE
            score > a.score
    ) + 1 as Rank
FROM
    Scores a
ORDER BY
    score DESC;