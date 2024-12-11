<template>
  <div class="loading" v-if="isLoading">
    <p>Loading...</p>
  </div>
  <div v-else>
    <nav>
      <router-link v-bind:to="{ name: 'HomeView' }">Back to Topic List</router-link>
    </nav>
    <topic-details v-bind:topic="topic" />
  </div>
</template>

<script>
import TopicDetails from '../components/TopicDetails.vue';
import TopicService from '../services/TopicService';

export default {
  components: {
    TopicDetails
  },
  data() {
    return {
      topic: {},
      isLoading: false
    }
  },
  methods: {
    getTopic(id) {

      // TODO - Get data from API and set `topics` property
      TopicService.get(id).then( (response) => {
        this.topic = response.data;
      });
    },
  },
  created() {
    this.getTopic(this.$route.params.topicId);
  }
};
</script>

<style scoped>
</style>