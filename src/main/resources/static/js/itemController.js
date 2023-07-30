
// Retrieve the product data from localStorage
const storedProducts = localStorage.getItem('products');
if (storedProducts) {
    const productDataArray = JSON.parse(storedProducts);

    // Loop through each product and create a new product-card element
    for (const productData of productDataArray) {
        const productCard = document.createElement('div');
        productCard.classList.add('col-md-12', 'col-xl-10', 'mb-3');
        productCard.innerHTML = `
<div id="product-card" class="card shadow-0 border rounded-3">
<div class="card-body">
  <div class="row">
    <div class="col-md-12 col-lg-3 col-xl-3 mb-4 mb-lg-0">
      <div class="bg-image hover-zoom ripple rounded ripple-surface">
        <img id="product-img" style="width:131px ; height:197px" src="${productData.image}" class="w-100" />
        <a href="#!">
          <div class="hover-overlay">
            <div class="mask" style="background-color: rgba(253, 253, 253, 0.15);"></div>
          </div>
        </a>
      </div>
    </div>
    <div class="col-md-6 col-lg-6 col-xl-6">
      <h5 id="product-name">${productData.name}</h5>
      <div class="d-flex flex-row">
        <div id="product-rating" class="text-danger mb-1 me-2">
          ${getRatingStars(productData.rating)}
        </div>
        <span id="product-reviews">${productData.reviews}</span>
      </div>
      <div class="mt-1 mb-0 text-muted small">
        <span id="product-material">${productData.material}</span>
        <span class="text-primary"> • </span>
        <span id="product-weight">${productData.weight}</span>
        <span class="text-primary"> • </span>
        <span id="product-finish">${productData.finish}</span>
        <br />
      </div>
      <div class="mb-2 text-muted small">
        <span id="product-description">${productData.description}</span>
        <span class="text-primary"> • </span>
        <span id="product-gender">${productData.gender}</span>
        <span class="text-primary"> • </span>
        <span id="product-style">${productData.style}</span>
        <br />
      </div>
      <p id="product-info" class="text-truncate mb-4 mb-md-0">${productData.info}</p>
    </div>
    <div class="col-md-6 col-lg-3 col-xl-3 border-sm-start-none border-start">
      <div class="d-flex flex-row align-items-center mb-1">
        <h4 id="product-price" class="mb-1 me-1">$${productData.price}</h4>
        <span class="text-danger" id="product-discount"><s>$${productData.discount}</s></span>
      </div>
      <h6 class="text-success" id="product-shipping">Free Shipping</h6>
      <div class="d-flex flex-column mt-4">
        <button class="btn btn-primary btn-sm" type="button">Details</button>
        <button class="btn btn-outline-primary btn-sm mt-2" type="button">Add to wishlist</button>
  </div>
</div>
</div>
</div>
</div>
`;

        // Append the product-card element to the products container
        const productsContainer = document.querySelector('#products-container');
        productsContainer.appendChild(productCard);
    }
}

/**

Returns a string of rating stars based on a rating out of 5
@param {number} rating - The rating out of 5
@returns {string} A string of rating stars
*/
function getRatingStars(rating) {
    const fullStars = Math.floor(rating);
    // const hasHalfStar = rating % 1 !== 0;
    // const emptyStars = 5 - fullStars;
    let ratingStars = '';
    for (let i = 0; i < fullStars; i++) {
        ratingStars += '<i class="fa fa-star"></i>';
    }
    return ratingStars;
}