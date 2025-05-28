SELECT * 
FROM Users 
WHERE registration_date >= DATE_SUB(CURDATE(), INTERVAL 30 DAY) 
AND user_id NOT IN (SELECT DISTINCT user_id FROM Registrations);
