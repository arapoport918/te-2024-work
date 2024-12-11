<template>
  <div class="home">
    <div id="heading-line">
      <h1 id="header">
        Products
        <loading-spinner id="spinner" v-bind:spin="isLoading" />
      </h1>

      <div class="filter">
        <input class="filterBar" v-model="filter" @input="filter()" />
        <font-awesome-icon icon="fa-magnifying-glass" />
      </div>

      <div class="view-icons">
        <!-- Card View Icon -->
        <font-awesome-icon v-bind:class="{ 'view-icon': true, active: cardView }" v-on:click="cardView = true"
          icon="fa-solid fa-grip" title="View tiles" />

        <!-- Table View Icon -->
        <font-awesome-icon v-bind:class="{ 'view-icon': true, active: !cardView }" v-on:click="cardView = false"
          icon="fa-solid fa-table" title="View table" />
      </div>

    </div>

    <div>
      <ProductList v-bind:products="products" v-if="cardView" />
      <ProductTable v-bind:products="products" v-else />
    </div>
  </div>
</template>

<script>
import LoadingSpinner from "../components/LoadingSpinner.vue";
import ProductList from "../components/ProductList.vue";
import ProductTable from "../components/ProductTable.vue";
import ProductService from "../services/ProductService";


export default {
  components: {
    LoadingSpinner,
    ProductList,
    ProductTable
  },

  data() {
    return {
      isLoading: true,
      cardView: true,
      products: [],
      search: ''
    };
  },

  computed: {
    isLoggedIn() {
      return this.$store.state.token.length > 0;
    },

  },

  methods: {
    listProducts() {
      ProductService.list().then((response) => {
        this.products = response.data;
        this.isLoading = false;
      });
    },

  },

  created() {
    this.listProducts();
  },
};
</script>

<style scoped>
#spinner {
  color: green;
}

#header {
  font-size: 36px;
}

.view-icon {
  font-size: 1.2rem;
  margin-right: 7px;
  padding: 3px;
  color: #444;
  border-radius: 3px;
}

.view-icon.active {
  background-color: lightgreen;
}

.view-icon:not(.active) {
  font-size: 1.2rem;
  margin-right: 7px;
  cursor: pointer;
}

.view-icon:not(.active):hover {
  color: blue;
  background-color: rgba(255, 255, 255, 0.7);
}
</style>