<template>
    <MyCart v-bind:cart="cart" :stats="stats" />
</template>

<script>
import MyCart from '../components/MyCart.vue'
import CartService from '../services/CartService';

export default {
    components: {
        MyCart
    },

    data() {
        return {
            cart: [],
            stats: {}
        }

    },

    methods: {
        getCart() {
            CartService.list(this.token).then((response) => {
                this.cart = response.data.items;
            });
        },

        getCartStats() {
            CartService.list(this.token).then((response) => {
                this.stats = response.data;
                console.log(response.data);
            });
        }
    },

    computed: {
        token() {
            return this.$store.state.token;
        }
    },

    created() {
        this.getCart();
        this.getCartStats();
    },

}

</script>

<style scoped></style>