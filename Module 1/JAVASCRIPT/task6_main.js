// Initial array of events
const events = [
  { name: "Jazz Night", category: "Music" },
  { name: "Art Workshop", category: "Art" },
  { name: "Rock Concert", category: "Music" },
  { name: "Cooking Class", category: "Workshop" }
];

// Add a new event using .push()
events.push({ name: "Classical Music Evening", category: "Music" });

// Filter only music events using .filter()
const musicEvents = events.filter(event => event.category === "Music");

// Map to format display cards
const eventCards = musicEvents.map(event => `🎵 Workshop on ${event.name}`);

// Display event cards on the webpage
const container = document.getElementById('eventsContainer');
eventCards.forEach(card => {
  const div = document.createElement('div');
  div.textContent = card;
  container.appendChild(div);
});

