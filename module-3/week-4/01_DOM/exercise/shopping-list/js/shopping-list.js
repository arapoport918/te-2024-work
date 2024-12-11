const shoppingList = document.getElementById('shopping-list');
// add pageTitle
let pageTitle = 'My Shopping List';
// add groceries
let groceries = [
  {id: 1, item: 'chicken', completed: false },
  {id: 2, item: 'garlic', completed: false },
  {id: 3, item: 'onion', completed: false },
  {id: 4, item: 'carrots', completed: false },
  {id: 5, item: 'celery', completed: false },
  {id: 6, item: 'tomatoes', completed: false },
  {id: 7, item: 'lemon', completed: false },
  {id: 8, item: 'potatoes', completed: false },
  {id: 9, item: 'pasta', completed: false },
  {id: 10, item: 'chocolate', completed: false }
];

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  const heading = document.getElementById('title');
  heading.innerText = pageTitle;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  const ul = document.querySelector('#groceries');
  groceries.forEach((food) => {
    const li = document.createElement('li');
    li.innerText = food.item;
    ul.appendChild(li);
  });
}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
  const listItems = document.querySelectorAll('li');
  listItems.forEach((item) => {
    item.classList.add('completed');
  })
}

setPageTitle();
displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
