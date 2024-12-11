<template>
    <ReadingList />
    <router-link v-bind:to="{name: 'add'}">Add Book to Reading List</router-link>
  </template>
  
<script>
import ReadingList from '../components/ReadingList.vue';

  export default {
    components: { 
        ReadingList
    }
}
</script>

<style>

</style>