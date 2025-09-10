fetch('/api/events')
  .then(response => response.json())
  .then(events => {
    const container = document.getElementById('eventList');
    if (events.length === 0) {
      container.innerHTML = `<p class="text-center text-muted">No events found.</p>`;
      return;
    }

    events.forEach(event => {
      const card = `
        <div class="col-md-4">
          <div class="card h-100 shadow-sm">
            <div class="card-body d-flex flex-column">
              <h5 class="card-title">${event.title}</h5>
              <p class="card-text">${event.description}</p>
              <p><strong>Date:</strong> ${new Date(event.dateTime).toLocaleString()}</p>
              <p><strong>Location:</strong> ${event.location}</p>
              <a href="#" class="btn btn-primary mt-auto">Register</a>
            </div>
          </div>
        </div>`;
      container.innerHTML += card;
    });
  })
  .catch(err => {
    console.error('Error fetching events:', err);
  });
