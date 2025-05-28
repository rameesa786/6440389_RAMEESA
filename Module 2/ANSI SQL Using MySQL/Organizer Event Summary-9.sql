SELECT u.full_name, COUNT(e.event_id) AS event_count, e.status 
FROM Users u 
LEFT JOIN Events e ON u.user_id = e.organizer_id 
GROUP BY u.user_id;
