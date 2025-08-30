function registration(event) {
    event.preventDefault(); // Prevent the form from refreshing the page

    var empname = document.getElementById("empname").value;
    var empsalalry = document.getElementById("empsalalry").value;
    var emailid = document.getElementById("emailid").value;
    var empdeptno = document.getElementById("empdeptno").value;

    var employeeDetails = {
        empname: empname,
        empsalalry: empsalalry,
        emailid: emailid,
        empdeptno: empdeptno
    };

    console.log("Sending to backend:", employeeDetails);

    fetch("http://localhost:8080/insertemployeedetails", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(employeeDetails)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("Registration failed");
        }
        return response.json(); // Spring Boot returns the saved employee object
    })
    .then(data => {
        alert("Employee registered successfully: " + data.empname);
    })
    .catch(error => {
        console.error("Error:", error);
        alert("Failed to register employee.");
    });
}
