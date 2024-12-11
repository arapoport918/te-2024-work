<template>
    <div class="row1">
        <h1 class="title">Shopping Cart</h1>
        <div id="icon">
            <button id="clr-cart" v-on:click="clearCart">
                <font-awesome-icon icon="fa-solid fa-trash-can" />
                Clear Cart</button>
        </div>
    </div>

    <div class="cart-table">
        <table>
            <thead>
                <th class="item-header">Qty</th>
                <th class="item-header">Product</th>
                <th class="item-header">Price</th>
                <th class="item-header">Amount</th>
            </thead>

            <tbody>
                <tr class="cart-item" v-for="product in cart" v-bind:key="product.cartItemId">
                    <td class="item">{{ product.quantity }}</td>
                    <router-link :to="{ name: 'product-details', params: { productId: product.product.productId } }">
                        <td class="item">{{ product.product.name }}</td>
                    </router-link>
                    <td class="item">{{ formatPrice(product.product.price) }}</td>
                    <td class="item">{{ calculatePrice(product.product.price, product.quantity) }} </td>
                    <font-awesome-icon icon="fa-solid fa-xmark" />
                </tr>

                <tr class="summary">
                    <td class="summary"></td>
                    <td class="summary"></td>
                    <td class="summary"></td>
                    <td class="summary"></td>
                </tr>

                <tr>
                    <td></td>
                    <td class="item-summary">Item Subtotal: </td>
                    <td></td>
                    <td class="item-summary">{{ formatPrice(stats.itemSubtotal) }}</td>
                </tr>

                <tr>
                    <td></td>
                    <td class="item-summary">Tax: </td>
                    <td></td>
                    <td class="item-summary">{{ formatPrice(stats.tax) }}</td>
                </tr>

                <tr>
                    <td></td>
                    <td class="item-summary">Total: </td>
                    <td></td>
                    <td class="item-summary">{{ formatPrice(stats.total) }}</td>
                </tr>
            </tbody>

        </table>
    </div>
</template>

<script>
import CartService from '../services/CartService';

export default {

    props: {
        cart: {
            type: Array,
            required: true
        },

        stats: {
            type: Object,
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

        calculatePrice(price, qty) {
            return this.formatPrice(price * qty);
        },

        deleteItemFromCart(id) {
            if (confirm("Are you sure you want to delete this item from the cart? This action cannot be undone.")) {
                CartService.delete(id).then((response) => {
                    if (response.status === 200) {
                        this.$router.push({ name: 'cart' });
                    }
                });
            }
        },

        clearCart() {
            if (confirm("Are you sure you want to clear the cart? This action cannot be undone.")) {
                CartService.clear().then((response) => {
                    if (response.status === 200) {
                        this.$router.push({ name: 'products' })
                    }
                });
            }
        },
    },

    computed: {
        token() {
            return this.$store.state.token;
        }
    },

}
</script>

<style scoped>
.row1 {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-left: 10px;
    margin-right: 10px;
}

.item-header {
    font-size: 20px;
    width: 10%;
    text-align: left;
    padding: 5px;
}

.item {
    padding: 5px;
}

.summary {
    border-bottom: 2px black solid;
}

.item-summary {
    padding: 5px;
    font-weight: bold;
}

.title {
    font-size: 24px;
}

.cart-table {
    margin-left: 2%;
}
</style>