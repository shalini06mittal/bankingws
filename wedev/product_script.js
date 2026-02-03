(function (global) {
    var products = [];
    function initialize() {
      products = [
        {
          name: "Laptop MAC OSX",
          brand: "Apple",
          description: "latest version laptop with improved CPU and new features",
          cost: "95000",
          ratings: { 5: 10, 4: 8, 3: 2, 2: 0, 1: 0 },
        },
        {
          name: "Laptop Windows 10",
          brand: "Microsoft",
          description: "Updated features with more security added",
          cost: "45000",
          ratings: { 5: 12, 4: 5, 3: 3, 2: 1, 1: 0 },
        },
        {
          name: "Speakers",
          brand: "BOSS",
          description: "High quality speakers with bluetooth connectivity",
          cost: "35000",
          ratings: { 5: 15, 4: 8, 3: 4, 2: 0, 1: 0 },
        },
        {
          name: "HeadPhones",
          brand: "Samsung",
          description: "best quality headphones with noise cancellation",
          cost: "22000",
          ratings: { 5: 8, 4: 2, 3: 1, 2: 0, 1: 0 },
        },
        {
          name: "Wireless Mouse",
          brand: "Sony",
          description: "hands free mouse to keep you away from the screen",
          cost: "15000",
          ratings: { 5: 20, 4: 4, 3: 2, 2: 3, 1: 2 },
        },
      ];
    }
   
    function display() {
      var prod = document.getElementById('product')
     var str = `<div class='container'>
      <h1>Product Details</h1>
          <table class='table table-bordered align-middle text-center'>
                    <tr>
                        <th rowspan='2'>Name</th>
                        <th rowspan='2'>Brand</th>
                        <th rowspan='2'>Description</th>
                        <th rowspan='2'>Cost</th>
                        <th colspan='5' class='text-center'>Ratings</th>
                    </tr>
                    <tr>
                      <th>1</th>
                      <th>2</th>
                      <th>3</th>
                      <th>4</th>
                      <th>5</th>
                    </tr>
                    `;
  
    products.map((product) => {
      str+="<tr>";
      Object.keys(product).forEach(function (key) {
        if (key === "name" || key === "brand") {
          var data = product[key].toUpperCase();
          str+=`<td>${data}</td>`;
        } else if (key === "ratings") {
          // console.log(Object.keys(product[key]))
          var data = product[key];
          console.log(data)
          console.log(Object.keys(data));
          var sum = calculateSum(data)
          console.log(sum)
          Object.keys(data).forEach(function (value) {
            str+=`<td>${Math.round(data[value]/sum * 100)}%</td>`;
          });
        } else {
          str+=`<td>${product[key]}</td>`;
        }
      });
  
      str+="</tr>";
    });
    str+="</table></div>";
    prod.innerHTML=str
    }

    function calculateSum(data)
    {
      var sum = 0;
      Object.keys(data).forEach(function (value) {
          sum += parseInt(data[value])
      })
      return sum;
    }

    initialize();
    display();

    // show a message with a type of the input
    function showMessage(input, message, type) {
      // get the small element and set the message
      const msg = input.parentNode.querySelector("span");
      msg.innerText = message;
     
      return type;
    }

    function showError(input, message) {
      return showMessage(input, message, false);
    }

    function showSuccess(input) {
      return showMessage(input, "", true);
    }

    function hasValue(input, message) {
      if (input.value.trim() === "") {
        return showError(input, message);
      }
      return showSuccess(input);
    }

    function validateCost(input, requiredMsg, invalidMsg) {
      // check if the value is not empty
      if (!hasValue(input, requiredMsg)) {
          return false;
      }
      // validate email format
      const emailRegex =
          /^\d+$/;

      const email = input.value.trim();
      console.log(email)
      console.log(emailRegex.test(email))
      if (!emailRegex.test(email)) {
          return showError(input, invalidMsg);
      }
      return true;
    }
    const NAME_REQUIRED = "Please enter product name";
    const COST_REQUIRED = "Please enter cost";
    const COST_INVALID = "Please enter cost only as numbers";
    const BRAND_REQUIRED = "Please enter brand";

    function addProduct() {
      var nameele = document.getElementById("name");
      var brandele = document.getElementById("brand");
      var descele = document.getElementById("desc");
      var costele = document.getElementById("cost");
      var r5ele = document.getElementById("r5");
      var r4ele = document.getElementById("r4");
      var r3ele = document.getElementById("r3");
      var r2ele = document.getElementById("r2");
      var r1ele = document.getElementById("r1");
      
      var name = nameele.value;
      var brand = brandele.value;
      var description = descele.value;
      var cost = costele.value;
      var r5 = r5ele.value;
      var r4 = r4ele.value;
      var r3 = r3ele.value;
      var r2 = r2ele.value;
      var r1 = r1ele.value;
      
       let nameValid = hasValue(nameele, NAME_REQUIRED);
       let brandValid = hasValue(brandele, BRAND_REQUIRED);
       let costValid = validateCost(costele, COST_REQUIRED, COST_INVALID);
      // // if valid, submit the form.
       if (nameValid && brandValid && costValid) {
          alert("Demo only. No form was posted.");
          var product = { name, brand, description, cost, ratings:{5:parseInt(r5),4:parseInt(r4),3:parseInt(r3),2:parseInt(r2),1:parseInt(r1)} };
          console.log(product);
          products.push(product);
          console.log(products);
         display()
      }

    }
    global.addProduct = addProduct;
  })(window);
