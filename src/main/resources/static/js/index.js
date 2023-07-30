
// Create an empty array to store the product data
let products = [];

// Get the form and submit button elements
const form = document.querySelector('form');
const submitBtn = document.querySelector('button[type="submit"]');

// Add event listener to the submit button
submitBtn.addEventListener('click', function(event) {
  event.preventDefault(); // Prevent the form from submitting normally

  // Get the input values
  var productImage = document.querySelector('#product-file-input').value;
  productImage = 'img/'+productImage.split('\\')[2];
  const productName = document.querySelector('#product-name-input').value;
  const productRating = document.querySelector('#product-rating-input').value;
  const productReviews = document.querySelector('#product-reviews-input').value;
  const productMaterial = document.querySelector('#product-material-input').value;
  const productWeight = document.querySelector('#product-weight-input').value;
  const productFinish = document.querySelector('#product-finish-input').value;
  const productDescription = document.querySelector('#product-description-input').value;
  const productGender = document.querySelector('#product-gender-input').value;
  const productStyle = document.querySelector('#product-style-input').value;
  const productInfo = document.querySelector('#product-info-input').value;
  const productPrice = document.querySelector('#product-price-input').value;
  const productDiscount = document.querySelector('#product-discount-input').value;

  // Create an object to store the input values
  const productData = {
    image: productImage,
    name: productName,
    rating: productRating,
    reviews: productReviews,
    material: productMaterial,
    weight: productWeight,
    finish: productFinish,
    description: productDescription,
    gender: productGender,
    style: productStyle,
    info: productInfo,
    price: productPrice,
    discount: productDiscount,
  };

  // Push the productData object into the products array
  products.push(productData);

  // Save the array to localStorage
  localStorage.setItem('products', JSON.stringify(products));

  // Clear the form inputs
  form.reset();
});




