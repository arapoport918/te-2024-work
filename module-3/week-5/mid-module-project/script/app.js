/*
    app.js

*/



document.addEventListener('DOMContentLoaded', () => {

    //ensure all products are visible when page initially loads
    displayProducts();

    const name = document.querySelectorAll(".product-name");
    const addToCart = document.querySelectorAll(".cart");
    const searchBar = document.getElementById("searchBar");
    const searchIcon = document.getElementById("searchButton");
    const messageBox = document.getElementById("message-box");
    const searchTerm = searchBar.value;

    //display description when product name is clicked
    name.forEach((prod) => {
        prod.addEventListener('click', () => {
            messageBox.innerText = prod.getAttribute("description"); 
        });
    });

    //display product name has been added to the cart when icon is clicked
    addToCart.forEach((item) => {
        item.addEventListener('click', () => {
            messageBox.innerText = item.getAttribute("data-custom") + " has been added to the cart!"; //not passing item name - adjust
        });
    });

    //searches for an item; keyup function works, search function itself needs adjustments
    searchBar.addEventListener('keyup', () => {
        const searchTerm = searchBar.value;
        productService.searchProducts(searchTerm);
    });
});


function displayProducts() {
    productService.allProducts.forEach( (item) => {
        //setup Article
        const section = document.getElementById("product-cards");
        const article = document.createElement("article");
        article.classList.add("product-card");
        section.appendChild(article);

        //setup SKU
        const sku = document.createElement("div");
        sku.innerText = item.productSku;
        sku.classList.add("sku");
        article.appendChild(sku);

        //setup price
        const price = document.createElement("div");
        price.innerText = Intl.NumberFormat(`en-US`, {
            currency: `USD`,
            style: "currency",
        }).format(item.price);
        price.classList.add("price");
        article.appendChild(price);

        //setup name, includes data-id with product ID
        const name = document.createElement("div");
        name.innerText = item.name;
        name.classList.add("product-name");
        name.classList.add("action");
        name.setAttribute("data-id", item.productId);
        name.setAttribute("description", item.description);
        article.appendChild(name);

        //setup image
        const image = document.createElement("div");
        image.classList.add("product-image");
        article.appendChild(image);

        const imageLink = document.createElement("img");
        imageLink.src = item.imageName;
        image.appendChild(imageLink);

        //setup cart icon
        const cart = document.createElement("div");
        cart.classList.add("cart");
        cart.setAttribute("data-custom", item.name);
        article.appendChild(cart);

        const icon = document.createElement("i");
        icon.classList.add("fa-solid");
        icon.classList.add("fa-cart-plus");
        icon.classList.add("icon");
        icon.classList.add("action");
        icon.title = "Add item to cart";
        cart.appendChild(icon);

    });

}