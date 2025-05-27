// Sample list of events
const events = [
    { name: "Yoga Workshop", date: "2025-06-10", seats: 5 },
    { name: "Music Concert", date: "2025-05-01", seats: 0 }, // past or full event
    { name: "Tech Meetup", date: "2025-07-20", seats: 10 },
    { name: "Art Exhibition", date: "2025-04-15", seats: 2 }  // past event
];

// Helper to check if event is upcoming
function isUpcoming(event) {
    const today = new Date();
    const eventDate = new Date(event.date);
    return eventDate >= today;
}

// Display only valid events (upcoming and seats > 0)
function displayEvents() {
    const container = document.getElementById('eventList');
    container.innerHTML = ''; // clear existing

    events.forEach(event => {
        if (isUpcoming(event) && event.seats > 0) {
            const div = document.createElement('div');
            div.textContent = `${event.name} - Date: ${event.date} - Seats Available: ${event.seats}`;
            container.appendChild(div);
        }
    });
}

// Registration function with error handling
function register(eventName) {
    try {
        const event = events.find(e => e.name === eventName);
        if (!event) {
            throw new Error("Event not found");
        }
        if (!isUpcoming(event)) {
            throw new Error("Cannot register for past event");
        }
        if (event.seats <= 0) {
            throw new Error("No seats available");
        }

        event.seats--;  // reduce seat count
        alert(`Successfully registered for ${eventName}`);
        displayEvents();

    } catch (error) {
        alert(`Registration failed: ${error.message}`);
    }
}

// Initial display of valid events
displayEvents();

// Example: Register user for "Tech Meetup" after 3 seconds
setTimeout(() => register("Tech Meetup"), 3000);
