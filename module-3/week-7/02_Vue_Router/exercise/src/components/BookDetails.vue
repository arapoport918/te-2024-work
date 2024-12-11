<template>
    <div class="book-details">
        <h2>{{ book.title }}</h2>
        <h2>{{ book.author }}</h2>
        <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
        <p>Number of pages: {{ book.numPages }}</p>
        
    </div>
  </template>
  
  <script>
  
  export default {
    components: {
    },

    computed: {
        book() {
            const bookIsbn = this.$route.params.isbn;
            const book = this.$store.state.book.find( b => b.isbn === bookIsbn);
            return this.book;
        }
    }
  }
  </script>
  
  <style>
  .book-details {
    display: flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
  }
  </style>