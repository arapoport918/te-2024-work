<template>
  <div class="book-container">
    <BookCard 
      v-for="book in displayBooks"
      :key="book.isbn"
      :book="book"/>
  </div>
</template>

<script>
import BookCard from './BookCard.vue';

export default {
    components: { 
      BookCard 
    },

    computed: {
      displayBooks() {
        const books = this.$store.state.books;
        return books;
      }
    }
}
</script>

<style>
.book-container {
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
}
</style>