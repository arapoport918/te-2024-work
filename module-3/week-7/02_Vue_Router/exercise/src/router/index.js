import { createRouter as _createRouter, createWebHistory } from 'vue-router';

//Imports for components go here
import HomeView from '../views/HomeView.vue';
import MyBooksView from '../views/MyBooksView.vue';
import NewBookView from '../views/NewBookView.vue';
import BookDetailsView from '../views/BookDetailsView.vue';


//Create route path and view component mappings; requires path, name, and component (the Homeview/AboutView etc.)
const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },

  {
    path: '/myBooks',
    name: 'reading',
    component: MyBooksView
  },

  {
    path: '/addBook',
    name: 'add',
    component: NewBookView
  },

  {
    path: '/book/:isbn',
    name: 'details',
    component: BookDetailsView
  }
];

export function createRouter () {
  return _createRouter({
    history: createWebHistory(),
    routes: routes
  })
}
