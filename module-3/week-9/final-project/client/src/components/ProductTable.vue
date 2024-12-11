<template>
    <div class="table">
        <table class="prod-list">
            <tr>
                <th class="table-header">SKU</th>
                <th class="table-header">Product</th>
                <th class="table-header">Price</th>
            </tr>
            <tr v-for="product in products" v-bind:key="product.productId">
                <td class="item">{{ product.productSku }}</td>
                <router-link :to="{ name: 'product-details', params: { productId: product.productId } }">
                    <td class="item">{{ product.name }}</td>
                </router-link>
                <td class="item">{{ formatPrice(product.price) }}</td>
                <div id="icon" class="col1">
                    <font-awesome-icon icon="fa-solid fa-cart-plus" class="action-button" />
                </div>
            </tr>
        </table>
    </div>
</template>

<script>
export default {
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
        }
    }
}
</script>

<style scoped>
.prod-list {
    padding: 40px;
}

.table-header {
    font-size: 24px;
    text-align: left;
    width: 30%;
}

.item {
    padding: 5px;
}
</style>