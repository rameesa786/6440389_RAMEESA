SELECT city, COUNT(DISTINCT user_id) AS user_count 
FROM Users 
GROUP BY city 
ORDER BY user_count DESC 
LIMIT 5;
