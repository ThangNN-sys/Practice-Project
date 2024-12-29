document.addEventListener("DOMContentLoaded", () => {
    setupLoginEvents();
});

function setupLoginEvents() {
    // Set up event listeners for Enter key
    const usernameInput = document.querySelector("#username");
    const passwordInput = document.querySelector("#password");

    usernameInput.addEventListener("keyup", handleEnterKey);
    passwordInput.addEventListener("keyup", handleEnterKey);

    // Set default Remember Me state
    const rememberMe = localStorage.getItem("REMEMBER_ME") === "true";
    document.querySelector("#rememberMe").checked = rememberMe;

    // Set up login button
    document.querySelector("#login-btn").addEventListener("click", login);
}

function handleEnterKey(event) {
    if (event.key === "Enter") {
        login();
    }
}

function login() {
    const username = document.querySelector("#username").value.trim();
    const password = document.querySelector("#password").value.trim();

    const isUsernameValid = validateInput(username, "#username-error", "Username is required");
    const isPasswordValid = validateInput(password, "#password-error", "Password is required");

    if (!isUsernameValid || !isPasswordValid) return;

    if (username.length < 6 || username.length > 50 || password.length < 6 || password.length > 50) {
        displayError("#general-error", "Invalid username or password length");
        return;
    }

    authenticateUser(username, password);
}

function validateInput(input, errorSelector, errorMessage) {
    if (!input) {
        displayError(errorSelector, errorMessage);
        return false;
    }
    clearError(errorSelector);
    return true;
}

function authenticateUser(username, password) {
    fetch("http://localhost:8080/api/v1/auth/login", {
        method: "POST",
        headers: {
            "Authorization": `Basic ${btoa(username + ":" + password)}`,
            "Content-Type": "application/json"
        }
    })
        .then(response => {
            if (!response.ok) {
                if (response.status === 401) {
                    displayError("#general-error", "Invalid credentials");
                }
                throw new Error("HTTP status " + response.status);
            }
            return response.json();
        })
        .then(data => {
            saveUserData(data, username, password);
            window.location.replace("/html/program.html");
        })
        .catch(error => {
            console.error("Authentication failed: ", error);
        });
}

function saveUserData(data, username, password) {
    const rememberMe = document.querySelector("#rememberMe").checked;
    localStorage.setItem("REMEMBER_ME", rememberMe);

    localStorage.setItem("ID", data.id);
    localStorage.setItem("FULL_NAME", data.fullName);
    localStorage.setItem("FIRST_NAME", data.firstName);
    localStorage.setItem("LAST_NAME", data.lastName);
    localStorage.setItem("ROLE", data.role);
    localStorage.setItem("USERNAME", username);
    localStorage.setItem("PASSWORD", password);
}

function displayError(selector, message) {
    const errorElement = document.querySelector(selector);
    errorElement.textContent = message;
    errorElement.style.display = "block";
}

function clearError(selector) {
    const errorElement = document.querySelector(selector);
    errorElement.style.display = "none";
}
