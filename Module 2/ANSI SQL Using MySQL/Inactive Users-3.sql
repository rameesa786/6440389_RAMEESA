SELECT * 
FROM Users 
WHERE user_id NOT IN (SELECT DISTINCT user_id FROM Registrations WHERE registration_date >= DATE_SUB(CURDATE(), INTERVAL 90 DAY));
