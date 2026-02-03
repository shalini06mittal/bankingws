// valid js code
fetch('http://localhost:8080/api/users')
.then(res => res.json())
.then(data => console.log(data));

let user = {
email: "shalini@example.com",
fullName: "Shalini Mittal",
role: "USER",
status: "ACTIVE",
username:"shalu"
}

fetch('http://localhost:8080/api/users', {
    method:"POST",
    headers: {
        'Content-Type': 'application/json', // Indicate the body format
      },
    body:JSON.stringify(user)
})
.then(res => res.json())
.then(data => console.log(data));


