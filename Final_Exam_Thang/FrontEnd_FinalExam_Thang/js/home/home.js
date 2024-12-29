// Load homepage dynamically
function viewHomepage() {
    $(".main").load("./home/homePage.html", () => {
        updateHomepageGreeting();
    });
}

// Update greeting text dynamically
function updateHomepageGreeting() {
    const userLastName = localStorage.getItem("LAST_NAME") || "User";
    $("#line-2").text(`Hello ${userLastName}!!!`);
}

// On document ready
$(document).ready(() => {
    viewHomepage();
});
