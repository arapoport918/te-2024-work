import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000",
  });
  
  export default {

      list(token) {
        return http.get('/cart', {headers: { 'Authorization': 'Bearer ' + token }});
      },
  
      addToCart(product) {
        return http.post('/cart/items', product);
      },

      delete(id) {
        return http.delete(`/cart/items/${id}`);
      },

      clear() {
        return http.delete('/cart');
      },
  
  }