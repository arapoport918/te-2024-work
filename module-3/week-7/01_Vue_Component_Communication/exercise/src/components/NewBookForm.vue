<template>
    <div class="new-card">
        <form class="new-book-form" v-on:submit.prevent="saveBook">
            <input class="title-input" type="text" name="book-title" placeholder="Title" v-model="newBook.title">
            <input class="author-input" type="text" name="book-author" placeholder="Author" v-model="newBook.author">
            <input class="isbn-input" type="text" name="book-isbn" placeholder="ISBN" v-model="newBook.isbn">
            <input type="submit" value="Save" />
        </form>
    </div>
</template>

<script>
export default {
    data() {
        return {
            newBook: {
                title: "",
                author: "",
                read: false,
                isbn: ""
            }
        }
    },

    methods: {
        saveBook() {
            this.$store.commit('ADD_NEW_BOOK', this.newBook);
            this.newBook = {};
        },
    }
}
</script>

<style>

</style>