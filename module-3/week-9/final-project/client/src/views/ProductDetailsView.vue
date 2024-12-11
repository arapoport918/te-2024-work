<template>
    <ProductDetails :product="product" />
</template>

<script>
import ProductDetails from '../components/ProductDetails.vue';
import ProductService from '../services/ProductService';

export default {
    components: {
        ProductDetails,
    },

    data() {
        return {
            isLoading: true,
            cardView: true,
            product: {},
        };
    },
    methods: {
        getProductById(id) {
            ProductService.get(id).then((response) => {
                this.product = response.data;
                this.isLoading = false;
            });
        }
    },
    created() {
        this.getProductById(this.$route.params.productId);
    },
}
</script>

<style scoped></style>