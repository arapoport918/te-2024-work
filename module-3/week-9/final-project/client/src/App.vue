<template>
  <!-- Header -->
  <div id="cart-app">
    <header id="banner">
      <img id="logo" src="img/logo_400x70.png">
    </header>
  </div>

  <!-- Navigation Bar -->
  <nav class="navbar">
    <div class="navbar-container">
      <div class="navbar-item">
        <router-link v-bind:to="{ name: 'home' }">
          <a href="#">Home</a>
        </router-link>
      </div>
      <div class="navbar-item">
        <router-link v-bind:to="{ name: 'cart' }">
          <a href="#">Cart</a>
        </router-link>
      </div>
      <div class="navbar-item align-right">
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token">
          Logout
        </router-link>
        <router-link v-bind:to="{ name: 'login' }" v-else>Login</router-link>
      </div>
    </div>
  </nav>

  <main>
    <router-view />
  </main>
  <footer>2024 All Rights Reserved &copy;</footer>
</template>

<style scoped>
.navbar-container {
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.navbar-item {
  height: 85%;
  text-align: center;
  padding: 5px;
}

.align-right {
  margin-left: auto;
}

#banner {
  text-align: center;
  border-width: 2px;
  border-style: solid;
  border-color: black;
}

#logo {
  padding: 10px;
}

footer {
  height: 25px;
  margin-left: 5px;
}

main {
  overflow: auto;
  border: 2px solid black;
  min-height: 100vh;
  margin-bottom: -25px;
}

nav {
  border-left: 2px solid black;
  border-radius: 2px solid black;
}
</style>

<script>
import { RouterLink } from 'vue-router';

export default {
  components: {
    RouterLink
  }
}
</script>