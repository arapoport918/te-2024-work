<template>
    <div class="prod-details" v-for="product in products" v-bind:key="product.productId">
        <div id="sku-price" class="row1">
            <p>{{ product.productSku }}</p>
            <p>{{ formatPrice(product.price) }}</p>
        </div>

        <div id="title" class="col1">
            <router-link :to="{ name: 'product-details', params: { productId: product.productId } }">{{ product.name
            }}</router-link>
        </div>


        <div id="image" class="col1">
            <img src='img/product_350x250/png' />
        </div>

        <div id="icon">
            <button v-on:click="addToCart(this.product)"> <font-awesome-icon icon="fa-solid fa-cart-plus"
                    class="action-button" /> </button>
        </div>
    </div>
</template>

<script>
import CartService from '../services/CartService'

export default {
    data() {
        return {
            search: '',
        }
    },
    props: {
        products: {
            type: Array,
            required: true
        }
    },

    methods: {
        formatPrice(price) {
            return Intl.NumberFormat(`en-US`, {
                currency: `USD`,
                style: "currency",
            }).format(price);
        },

        addToCart(item) {
            CartService.addToCart(item).then((response) => {
                if (response.status === 201) {
                    this.$router.push({ name: 'cart' });
                }
            });
        },
    },



}
</script>

<style scoped>
.prod-details {
    display: flex;
    flex-direction: column;
    max-width: 20%;
    border: 1px black solid;
    flex-wrap: wrap;
}

.row1 {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
}

#image {
    display: flex;
    justify-content: center;
}

#icon {
    display: flex;
    justify-content: flex-end;
}
</style>