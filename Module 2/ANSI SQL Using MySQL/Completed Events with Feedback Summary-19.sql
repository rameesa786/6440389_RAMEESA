SELECT e.title, COUNT(r.registration_id) AS total_registrations, AVG(f.rating) AS average_rating 
FROM Events e 
JOIN Registrations r ON e.event_id = r.event_id 
JOIN Feedback f ON e.event_id = f.event_id 
WHERE e.status = 'completed' 
GROUP BY e.event_id;