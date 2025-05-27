const loadingDiv = document.getElementById('loading');
const eventsContainer = document.getElementById('eventsContainer');

// Mock API URL (using JSONPlaceholder for demonstration)
const mockAPI = 'https://jsonplaceholder.typicode.com/users/1/todos'; // Replace with actual mock event data if available

// Show loading spinner
function showLoading(show) {
  loadingDiv.style.display = show ? 'block' : 'none';
}

// Render events (mock events here)
function renderEvents(events) {
  eventsContainer.innerHTML = '';
  events.forEach(event => {
    const card = document.createElement('div');
    card.className = 'event-card';
    card.innerHTML = `
      <h3>${event.title}</h3>
      <p>Status: ${event.completed ? 'Completed' : 'Upcoming'}</p>
    `;
    eventsContainer.appendChild(card);
  });
}

// Fetch events using Promises (.then/.catch)
function fetchEventsWithPromises() {
  showLoading(true);
  fetch(mockAPI)
    .then(response => response.json())
    .then(data => {
      showLoading(false);
      // For demo, use first 5 items as events
      const events = data.slice(0, 5).map(item => ({
        title: item.title,
        completed: item.completed
      }));
      renderEvents(events);
    })
    .catch(error => {
      showLoading(false);
      console.error('Error fetching events:', error);
      eventsContainer.textContent = 'Failed to load events.';
    });
}

// Fetch events using async/await
async function fetchEventsAsync() {
  showLoading(true);
  try {
    const response = await fetch(mockAPI);
    const data = await response.json();
    showLoading(false);
    const events = data.slice(0, 5).map(item => ({
      title: item.title,
      completed: item.completed
    }));
    renderEvents(events);
  } catch (error) {
    showLoading(false);
    console.error('Error fetching events:', error);
    eventsContainer.textContent = 'Failed to load events.';
  }
}

// Run both methods for demo (comment one to test)
// fetchEventsWithPromises();
fetchEventsAsync();
