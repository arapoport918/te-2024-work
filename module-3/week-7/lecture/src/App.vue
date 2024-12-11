<template>
  <div class="main">
    <h2>Product Reviews for {{ name }}</h2>
    <p class="description">{{ description }}</p>

    <div class="well-display">
      <AverageSummary />
      <StarSummary v-for="i in 5" :key="i"/>
    </div>

    <AddReview />
  </div>
</template>

<script>

import AverageSummary from './components/AverageSummary.vue';
import StarSummary from './components/StarSummary.vue';
import AddReview from './components/AddReview.vue';


export default {
  data() {
    return {
      name: 'Head First Design Patterns',
      description: "something something"
    };
  },

  components: {
    AverageSummary,
    StarSummary,
    AddReview
  }
};
</script>

<style scoped>
.main {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  max-width: 800px;
  margin: 60px auto 0 auto;
}

.well-display {
  display: flex;
  justify-content: space-around;
  margin-bottom: 1rem;
}
</style>
