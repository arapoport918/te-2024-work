<template>
    <header class="header">
        <div class="row1">
            <h1 id="big-title">{{ product.name }}</h1>

            <div id="icon">
                <button class="btn-atc">Add to Cart
                    <font-awesome-icon icon="fa-solid fa-cart-plus" class="action-button" />
                </button>
            </div>
        </div>
    </header>

    <body class="body">
        <div id="big-description">{{ product.description }}</div>
        <div class="sku-price">
            <div>{{ product.productSku }}</div>
            <div id="price">{{ product.price }}</div>
        </div>

        <div>{{ product.name }}</div>
        <div>{{ product.image }}</div>
    </body>
</template>

<script>
import ProductService from '../services/ProductService';

export default {
    props: {
        product: {
            type: Object,
            required: true
        }
    },

}
</script>

<style scoped>
.header {
    display: flex;
    flex-direction: column;
}

.row1 {
    display: flex;
    justify-content: space-between;
}

#big-title {
    font-size: 24px;
}

#big-description {
    font-size: 20px;
}

.body {
    display: flex;
    flex-direction: column;
    max-width: 30%;
}

.sku-price {
    display: flex;
    justify-content: flex-start;
}

#price {
    padding-left: 10px;
}
</style>