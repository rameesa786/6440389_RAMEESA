// Use const for event name and date
const eventName = "Community Cleanup Drive";
const eventDate = "2025-06-15";

// Use let for available seats
let availableSeats = 10;

// Function to display event info using template literals
function displayEventInfo() {
    const info = `Event: ${eventName} | Date: ${eventDate} | Seats Available: ${availableSeats}`;
    document.getElementById('eventInfo').textContent = info;
}

// Function to handle registration - decrement seats using --
function register() {
    if (availableSeats > 0) {
        availableSeats--; // decrement seats on registration
        alert("Registration successful!");
        displayEventInfo();
    } else {
        alert("Sorry, no seats available!");
    }
}

// Initial display
displayEventInfo();

// Add event listener for register button
document.getElementById('registerBtn').addEventListener('click', register);
