const form = document.getElementById('registrationForm');
const nameInput = form.elements['name'];
const emailInput = form.elements['email'];
const eventSelect = form.elements['eventSelect'];

const nameError = document.getElementById('nameError');
const emailError = document.getElementById('emailError');
const eventError = document.getElementById('eventError');
const formMessage = document.getElementById('formMessage');

function validateEmail(email) {
  // Basic email regex
  const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  return re.test(email);
}

function clearErrors() {
  nameError.textContent = '';
  emailError.textContent = '';
  eventError.textContent = '';
  formMessage.textContent = '';
}

form.addEventListener('submit', (event) => {
  event.preventDefault();
  clearErrors();

  let valid = true;

  if (nameInput.value.trim() === '') {
    nameError.textContent = 'Name is required.';
    valid = false;
  }

  if (emailInput.value.trim() === '') {
    emailError.textContent = 'Email is required.';
    valid = false;
  } else if (!validateEmail(emailInput.value.trim())) {
    emailError.textContent = 'Enter a valid email address.';
    valid = false;
  }

  if (eventSelect.value === '') {
    eventError.textContent = 'Please select an event.';
    valid = false;
  }

  if (valid) {
    formMessage.textContent = `Thank you, ${nameInput.value.trim()}! You are registered for "${eventSelect.value}".`;
    form.reset();
  }
});
