SELECT e.title, AVG(f.rating) AS average_rating 
FROM Events e 
JOIN Feedback f ON e.event_id = f.event_id 
GROUP BY e.event_id 
HAVING COUNT(f.feedback_id) >= 10 
ORDER BY average_rating DESC;
