SELECT u.city, AVG(f.rating) AS average_rating 
FROM Feedback f 
JOIN Events e ON f.event_id = e.event_id 
JOIN Registrations r ON e.event_id = r.event_id 
JOIN Users u ON r.user_id = u.user_id 
GROUP BY u.city;
