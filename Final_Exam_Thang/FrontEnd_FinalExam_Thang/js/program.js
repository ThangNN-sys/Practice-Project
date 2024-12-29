// Ensure DOM is ready before executing scripts
$(document).ready(() => {

    // Check if the user is logged in
    if (!isLoggedIn()) {
        redirectToLogin();
        return;
    }

    // Dynamically load parts of the page
    $(".header").load("./common/header.html", () => {
        $("#header-fullname").text(localStorage.getItem("FULL_NAME"));
    });
    $(".sidebar").load("./common/sidebar.html", () => {
        $("#sidebar-lastname").text(`Hello ${localStorage.getItem("LAST_NAME")}!`);
    });
    $(".main").load("./home/homePage.html", () => {
        $("#line-2").text(`Hello ${localStorage.getItem("LAST_NAME")}!`);
    });
    $(".footer").load("./common/footer.html");
});

// Check login status
function isLoggedIn() {
    return !!localStorage.getItem("ID");
}

// Redirect to the login page
function redirectToLogin() {
    window.location.replace("/html/login/loginform.html");
}

// Log out the user
function logout() {
    localStorage.clear();
    redirectToLogin();
}

// Show a success notification
function showNotification(message) {
    const snackbar = document.getElementById("snackbar");
    snackbar.textContent = message;
    snackbar.classList.add("show");

    setTimeout(() => {
        snackbar.classList.remove("show");
    }, 3000);
}
