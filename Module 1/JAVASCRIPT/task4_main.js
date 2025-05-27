// Sample events with category property
const events = [
    { name: "Yoga Workshop", category: "Health", seats: 5 },
    { name: "Music Concert", category: "Entertainment", seats: 10 },
    { name: "Tech Meetup", category: "Technology", seats: 8 },
    { name: "Art Exhibition", category: "Art", seats: 3 }
];

// Closure to track total registrations per category
function createRegistrationTracker() {
    const registrations = {};

    return {
        register(category) {
            registrations[category] = (registrations[category] || 0) + 1;
        },
        getRegistrations(category) {
            return registrations[category] || 0;
        }
    };
}

const registrationTracker = createRegistrationTracker();

// Function to add an event (for demo, just push to events array)
function addEvent(newEvent) {
    events.push(newEvent);
    displayEvents(events);
}

// Function to register user for an event
function registerUser(eventName) {
    const event = events.find(e => e.name === eventName);
    if (!event) {
        alert("Event not found");
        return;
    }
    if (event.seats <= 0) {
        alert("No seats available");
        return;
    }
    event.seats--;
    registrationTracker.register(event.category);
    alert(`Registered for ${event.name}. Total registrations for ${event.category}: ${registrationTracker.getRegistrations(event.category)}`);
    displayEvents(events);
}

// Higher-order function to filter events by category using callback
function filterEventsByCategory(eventsArray, category, callback) {
    const filtered = eventsArray.filter(event => event.category === category);
    callback(filtered);
}

// Function to display events
function displayEvents(eventsArray) {
    const container = document.getElementById('eventList');
    container.innerHTML = '';
    eventsArray.forEach(event => {
        const div = document.createElement('div');
        div.textContent = `${event.name} | Category: ${event.category} | Seats: ${event.seats}`;
        
        // Add register button for each event
        const btn = document.createElement('button');
        btn.textContent = "Register";
        btn.onclick = () => registerUser(event.name);
        
        div.appendChild(btn);
        container.appendChild(div);
    });
}

// Initial display of all events
displayEvents(events);

// Example usage of filterEventsByCategory with a callback
filterEventsByCategory(events, "Technology", filteredEvents => {
    console.log("Filtered Technology events:", filteredEvents);
});

// Example: add a new event after 5 seconds
setTimeout(() => {
    addEvent({ name: "Community Gardening", category: "Environment", seats: 15 });
}, 5000);
