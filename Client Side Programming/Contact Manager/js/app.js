
// CONSTANTS & STORAGE
var STORAGE_KEY  = 'contacts';
var EDIT_KEY     = 'editIndex';

function getContacts() {
  return JSON.parse(localStorage.getItem(STORAGE_KEY)) || [];
}

function saveToStorage(contacts) {
  localStorage.setItem(STORAGE_KEY, JSON.stringify(contacts));
}

// NAVBAR — injected once, reused everywhere
function renderNavbar(isHome) {
  var rightBtn = isHome
    ? '<a href="form.html" class="btn btn-primary" style="margin-top:8px; margin-right:10px;">+ Add Contact</a>'
    : '<a href="index.html" class="btn btn-default" style="margin-top:8px; margin-right:10px;"><span class="glyphicon glyphicon-home"></span> Home</a>';

  document.getElementById('navbar-placeholder').innerHTML =
    '<nav class="navbar navbar-default">' +
      '<div class="container-fluid">' +
        '<div class="navbar-header">' +
          '<a href="index.html" class="navbar-brand">Contact Manager</a>' +
        '</div>' +
        '<div class="navbar-right">' + rightBtn + '</div>' +
      '</div>' +
    '</nav>';
}

// HELPERS
function getInitials(name) {
  return name.split(' ').map(function(w) { return w[0]; }).join('').toUpperCase().slice(0, 2);
}

function getBadgeClass(category) {
  var map = { Work: 'badge-work', Friend: 'badge-friend', Family: 'badge-family' };
  return map[category] || 'badge-other';
}

function getSelectedGender() {
  var inputs = document.getElementsByName('gender');
  for (var i = 0; i < inputs.length; i++) {
    if (inputs[i].checked) return inputs[i].value;
  }
  return '';
}

function setSelectedGender(gender) {
  var inputs = document.getElementsByName('gender');
  for (var i = 0; i < inputs.length; i++) {
    inputs[i].checked = (inputs[i].value === gender);
  }
}

function getField(id) {
  return document.getElementById(id).value;
}

function setField(id, value) {
  document.getElementById(id).value = value || '';
}

function showError(id, msg) {
  document.getElementById(id).innerText = msg;
}

function clearErrors() {
  ['nameError','emailError','phoneError','categoryError'].forEach(function(id) {
    document.getElementById(id).innerText = '';
  });
}

// VALIDATION
function validateForm(name, email, phone, category) {
  clearErrors();
  var valid = true;

  if (name.trim().length < 2) {
    showError('nameError', 'Full name must be at least 2 characters.');
    valid = false;
  }

  if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email.trim())) {
    showError('emailError', 'Enter a valid email address.');
    valid = false;
  }

  if (!/^[0-9]{10}$/.test(phone.trim())) {
    showError('phoneError', 'Enter a valid 10-digit phone number.');
    valid = false;
  }

  if (category === '') {
    showError('categoryError', 'Please select a category.');
    valid = false;
  }

  return valid;
}

// COLLECT FORM DATA
function collectFormData() {
  return {
    name: getField('fullName'),
    email: getField('email'),
    phone:getField('phone'),
    category:getField('category'),
    dob: getField('dob'),
    website: getField('website'),
    notes: getField('notes'),
    gender: getSelectedGender(),
    favourite: document.getElementById('isFavourite').checked
  };
}

// SUBMIT CONTACT — handles both Add & Edit
function submitContact(event) {
  event.preventDefault();

  var data  = collectFormData();
  var index = getField('contactIndex');

  if (!validateForm(data.name, data.email, data.phone, data.category)) return;

  var contacts = getContacts();

  if (index !== '') {
    // EDIT mode — update existing
    contacts[index] = data;
    alert('Contact updated successfully!');
  } else {
    // ADD mode — push new
    contacts.push(data);
    alert('Contact saved successfully!');
  }

  saveToStorage(contacts);
  window.location.href = 'index.html';
}

// LOAD CONTACTS TABLE (index.html)
function loadContacts(filter) {
  var contacts = getContacts();
  var tbody = document.getElementById('contactsBody');
  var empty = document.getElementById('emptyState');
  if (!tbody) return;

  // Update stats
  var work = contacts.filter(function(c) { return c.category === 'Work'; });
  document.getElementById('totalCount').innerText = contacts.length;
  document.getElementById('workCount').innerText  = work.length;
  document.getElementById('otherCount').innerText = contacts.length - work.length;

  // Apply search filter
  if (filter) {
    var kw = filter.toLowerCase();
    contacts = contacts.filter(function(c) {
      return c.name.toLowerCase().includes(kw) ||
             c.email.toLowerCase().includes(kw) ||
             c.phone.includes(kw);
    });
  }

  if (contacts.length === 0) {
    tbody.innerHTML = '';
    empty.style.display = 'block';
    return;
  }

  empty.style.display = 'none';

  tbody.innerHTML = contacts.map(function(c, i) {
    var star = c.favourite
      ? ' <span class="glyphicon glyphicon-star" style="color:#f39c12;"></span>'
      : '';
    return '<tr>' +
      '<td><span class="avatar">' + getInitials(c.name) + '</span>' + c.name + star + '</td>' +
      '<td>' + c.email + '</td>' +
      '<td>' + c.phone + '</td>' +
      '<td><span class="' + getBadgeClass(c.category) + '">' + c.category + '</span></td>' +
      '<td>' +
        '<button class="btn-edit" onclick="goToEdit(' + i + ')">Edit</button>' +
        '<button class="btn-delete" onclick="deleteContact(' + i + ')"> Delete</button>' +
      '</td>' +
    '</tr>';
  }).join('');
}

// SEARCH
function searchContacts() {
  loadContacts(document.getElementById('searchInput').value);
}

// DELETE
function deleteContact(index) {
  if (!confirm('Are you sure you want to delete this contact?')) return;
  var contacts = getContacts();
  contacts.splice(index, 1);
  saveToStorage(contacts);
  loadContacts();
}

// GO TO EDIT
function goToEdit(index) {
  localStorage.setItem(EDIT_KEY, index);
  window.location.href = 'form.html';
}

// LOAD EDIT FORM (form.html in edit mode)
function loadEditForm(index) {
  var contacts = getContacts();
  if (!contacts[index]) {
    alert('Contact not found!');
    window.location.href = 'index.html';
    return;
  }
  var c = contacts[index];
  setField('contactIndex',index);
  setField('fullName',c.name);
  setField('email',c.email);
  setField('phone',c.phone);
  setField('dob',c.dob);
  setField('website',c.website);
  setField('notes',c.notes);
  setField('category',c.category);
  document.getElementById('isFavourite').checked = c.favourite;
  setSelectedGender(c.gender);

  // Update UI for edit mode
  document.getElementById('formTitle').innerText = 'Edit Contact';
  document.title = 'Edit Contact';
  document.getElementById('submitBtn').className = 'btn btn-success';
  document.getElementById('submitBtn').innerHTML = 'Update Contact';
  document.querySelector('.photo-hint').innerText = 'Leave empty to keep existing photo';
}

// PAGE INIT
window.onload = function() {
  var page = window.location.pathname;

  if (page.includes('index') || page.endsWith('/')) {
    renderNavbar(true);
    loadContacts();
  }

  if (page.includes('form')) {
    var editIndex = localStorage.getItem(EDIT_KEY);
    if (editIndex !== null) {
      // Edit mode
      renderNavbar(false);
      loadEditForm(editIndex);
      localStorage.removeItem(EDIT_KEY);
    } else {
      // Add mode
      renderNavbar(false);
      document.getElementById('formTitle').innerText = 'Add New Contact';
      document.title = 'Add Contact';
      document.getElementById('submitBtn').className = 'btn btn-primary';
      document.getElementById('submitBtn').innerHTML = 'Save Contact';
    }
  }
};
