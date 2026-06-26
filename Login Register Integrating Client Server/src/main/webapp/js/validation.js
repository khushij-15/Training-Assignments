function validateLogin() {

    let username = document.getElementById("username").value.trim();
    let password = document.getElementById("password").value.trim();

    document.getElementById("usernameError").innerHTML = "";
    document.getElementById("passwordError").innerHTML = "";

    let valid = true;

    if (username === "") {
        document.getElementById("usernameError").innerHTML = "Username is required";
        valid = false;
    }

    if (password === "") {
        document.getElementById("passwordError").innerHTML = "Password is required";
        valid = false;
    }

    return valid;
}

function validateRegister() {

    let username = document.getElementById("username").value.trim();
    let email = document.getElementById("email").value.trim();
    let password = document.getElementById("password").value;
    let confirmPassword = document.getElementById("confirmPassword").value;

    document.getElementById("usernameError").innerHTML = "";
    document.getElementById("emailError").innerHTML = "";
    document.getElementById("passwordError").innerHTML = "";
    document.getElementById("confirmPasswordError").innerHTML = "";

    let valid = true;

    if (username === "") {
        document.getElementById("usernameError").innerHTML = "Username is required";
        valid = false;
    }

    if (email === "") {
        document.getElementById("emailError").innerHTML = "Email is required";
        valid = false;
    } else {

        let emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

        if (!emailPattern.test(email)) {
            document.getElementById("emailError").innerHTML = "Enter a valid email";
            valid = false;
        }
    }

    if (password === "") {
        document.getElementById("passwordError").innerHTML = "Password is required";
        valid = false;
    }

    if (confirmPassword === "") {
        document.getElementById("confirmPasswordError").innerHTML = "Confirm Password is required";
        valid = false;
    }

    if (password !== "" && confirmPassword !== "" && password !== confirmPassword) {
        document.getElementById("confirmPasswordError").innerHTML = "Passwords do not match";
        valid = false;
    }

    return valid;
}