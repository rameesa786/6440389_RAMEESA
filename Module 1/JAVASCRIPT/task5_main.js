// Event constructor function
function Event(name, date, seats) {
  this.name = name;
  this.date = date;
  this.seats = seats;
}

// Add method to prototype to check availability
Event.prototype.checkAvailability = function() {
  return this.seats > 0;
};

// Create a few event instances
const event1 = new Event("Coding Bootcamp", "2025-07-10", 5);
const event2 = new Event("Dance Workshop", "2025-06-20", 0);

// Function to display event details and availability
function displayEventDetails(event) {
  const container = document.getElementById("eventInfo");
  
  // Create a div for event
  const div = document.createElement("div");
  
  // Get keys and values using Object.entries()
  const entries = Object.entries(event);
  let details = "";
  entries.forEach(([key, value]) => {
    details += `<strong>${key}</strong>: ${value} <br/>`;
  });
  
  // Append availability info
  const availability = event.checkAvailability() ? "Seats available" : "No seats available";

  div.innerHTML = `${details}<strong>Availability:</strong> ${availability}<hr/>`;

  container.appendChild(div);
}

// Display event details
displayEventDetails(event1);
displayEventDetails(event2);
