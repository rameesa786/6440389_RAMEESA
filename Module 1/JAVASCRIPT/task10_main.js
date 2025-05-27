const events = [
  { id: 1, name: "Yoga Retreat", category: "Wellness", seats: 8 },
  { id: 2, name: "Jazz Night", category: "Music", seats: 3 },
  { id: 3, name: "Cooking Workshop", category: "Workshop", seats: 5 },
  { id: 4, name: "Rock Concert", category: "Music", seats: 0 },
];

// Function with default parameters, destructuring, and spread operator
const filterEventsByCategory = (
  eventList = [],
  category = "all"
) => {
  const clonedEvents = [...eventList];

  if (category === "all") return clonedEvents;

  // Use destructuring in filter callback
  return clonedEvents.filter(({ category: cat }) => cat === category);
};

// Render events to DOM
const renderEvents = (eventList = []) => {
  const container = document.getElementById("eventsContainer");
  container.innerHTML = "";

  eventList.forEach(({ id, name, category, seats }) => {
    const card = document.createElement("div");
    card.className = "event-card";
    card.innerHTML = `
      <h3>${name}</h3>
      <p>Category: ${category}</p>
      <p>Seats Available: ${seats}</p>
    `;
    container.appendChild(card);
  });
};

// Example usage:
const selectedCategory = "Music"; // change this value to test other categories
const filteredEvents = filterEventsByCategory(events, selectedCategory);

renderEvents(filteredEvents);
