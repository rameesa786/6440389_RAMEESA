const events = [
  { id: 1, name: "Community Yoga", date: "2025-06-15", seats: 5 },
  { id: 2, name: "Food Festival", date: "2025-07-01", seats: 10 },
  { id: 3, name: "Book Fair", date: "2025-06-20", seats: 0 }
];

const container = document.getElementById('eventsContainer');

function renderEvents() {
  container.innerHTML = ''; // Clear existing events
  
  events.forEach(event => {
    const card = document.createElement('div');
    card.className = 'event-card';

    card.innerHTML = `
      <h3>${event.name}</h3>
      <p>Date: ${event.date}</p>
      <p>Seats available: ${event.seats}</p>
    `;

    const registerBtn = document.createElement('button');
    registerBtn.textContent = 'Register';
    registerBtn.disabled = event.seats === 0;
    registerBtn.onclick = () => {
      if (event.seats > 0) {
        event.seats--;
        alert(`Registered for ${event.name}`);
        renderEvents(); // update UI
      }
    };

    const cancelBtn = document.createElement('button');
    cancelBtn.textContent = 'Cancel Registration';
    cancelBtn.disabled = event.seats === 10; // max seats (for example)
    cancelBtn.style.marginLeft = '10px';
    cancelBtn.onclick = () => {
      if (event.seats < 10) {
        event.seats++;
        alert(`Cancelled registration for ${event.name}`);
        renderEvents(); // update UI
      }
    };

    card.appendChild(registerBtn);
    card.appendChild(cancelBtn);

    container.appendChild(card);
  });
}

// Initial render
renderEvents();
