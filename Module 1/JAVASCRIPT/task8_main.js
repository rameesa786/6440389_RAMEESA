const events = [
  { id: 1, name: "Jazz Night", category: "Music", seats: 5 },
  { id: 2, name: "Painting Workshop", category: "Art", seats: 3 },
  { id: 3, name: "Rock Concert", category: "Music", seats: 0 },
  { id: 4, name: "Cooking Workshop", category: "Workshop", seats: 7 }
];

const container = document.getElementById('eventsContainer');
const categoryFilter = document.getElementById('categoryFilter');
const searchInput = document.getElementById('searchInput');

function renderEvents(filteredEvents) {
  container.innerHTML = '';
  filteredEvents.forEach(event => {
    const card = document.createElement('div');
    card.className = 'event-card';

    card.innerHTML = `
      <h3>${event.name}</h3>
      <p>Category: ${event.category}</p>
      <p>Seats: ${event.seats}</p>
    `;

    const registerBtn = document.createElement('button');
    registerBtn.textContent = 'Register';
    registerBtn.disabled = event.seats === 0;
    registerBtn.onclick = () => {
      if (event.seats > 0) {
        event.seats--;
        alert(`Registered for ${event.name}`);
        filterAndRender();
      }
    };

    card.appendChild(registerBtn);
    container.appendChild(card);
  });
}

function filterAndRender() {
  const category = categoryFilter.value;
  const searchTerm = searchInput.value.toLowerCase();

  let filtered = events;

  if (category !== 'all') {
    filtered = filtered.filter(event => event.category === category);
  }

  if (searchTerm) {
    filtered = filtered.filter(event => event.name.toLowerCase().includes(searchTerm));
  }

  renderEvents(filtered);
}

// Event listeners
categoryFilter.onchange = filterAndRender;
searchInput.onkeydown = (e) => {
  // Use a slight delay to capture input (e.g., on keyup better, but as per requirement keydown)
  setTimeout(filterAndRender, 100);
};

// Initial render
filterAndRender();
