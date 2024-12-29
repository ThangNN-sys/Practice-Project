$(document).ready(() => {
    if (!isLoggedIn()) {
        redirectToLogin();
        return;
    }

    // Load components
    $(".header").load("./common/header.html", () => {
        $("#header-fullname").text(localStorage.getItem("FULL_NAME"));
    });
    $(".sidebar").load("./common/sidebar.html", () => {
        $("#sidebar-lastname").text(`Hello ${localStorage.getItem("LAST_NAME")}!`);
    });
    $(".footer").load("./common/footer.html");

    // Initialize main table content
    setupSearchEvent();
    setupFilter();
    buildAccountTable();
});

let accounts = [];
let currentPage = 1;
let size = 5;
let sortField = "id";
let isAsc = false;

function isLoggedIn() {
    return !!localStorage.getItem("ID");
}

function redirectToLogin() {
    window.location.replace("/html/login/loginform.html");
}

function buildAccountTable() {
    $('#account-table tbody').empty();
    fetchAccounts();
}

function fetchAccounts() {
    let url = `http://localhost:8080/api/v1/accounts?page=${currentPage}&size=${size}&sort=${sortField},${isAsc ? "asc" : "desc"}`;

    const search = $("#search-account-input").val().trim();
    if (search) url += `&search=${search}`;

    const role = $("#filter-role-select").val();
    if (role) url += `&role=${role}`;

    const department = $("#filter-department-select").find(":selected").text();
    if (department && department !== "All Departments") url += `&departmentName=${department}`;

    $.ajax({
        url,
        type: 'GET',
        headers: {
            "Authorization": `Basic ${btoa(localStorage.getItem("USERNAME") + ":" + localStorage.getItem("PASSWORD"))}`,
        },
        success: (data) => {
            accounts = data.content;
            renderAccounts();
            updatePagination(data.numberOfElements, data.totalPages);
        },
        error: (error) => console.error("Error fetching accounts: ", error),
    });
}

function renderAccounts() {
    accounts.forEach((account, index) => {
        $('#account-table tbody').append(`
            <tr>
                <td><input type="checkbox" id="checkbox-${index}" /></td>
                <td>${account.username}</td>
                <td>${account.fullName}</td>
                <td>${account.role}</td>
                <td>${account.departmentName}</td>
                <td>
                    <a href="#" title="Edit" onclick="editAccount(${account.id})"><i class="fa-solid fa-pencil"></i></a>
                    <a href="#" title="Delete" onclick="deleteAccount(${account.id})"><i class="fa-solid fa-trash"></i></a>
                </td>
            </tr>
        `);
    });
}

function updatePagination(currentSize, totalPages) {
    $("#account-previousPage-btn").prop("disabled", currentPage <= 1);
    $("#account-nextPage-btn").prop("disabled", currentPage >= totalPages);
    $("#account-page-info").text(`${currentSize} records, page ${currentPage} of ${totalPages}`);
}

function setupSearchEvent() {
    $("#search-account-input").on("keyup", (e) => {
        if (e.key === "Enter") buildAccountTable();
    });
}

function setupFilter() {
    $("#filter-role-select").select2({ placeholder: "Select a role" });
    $("#filter-department-select").select2({
        placeholder: "Select a department",
        ajax: {
            url: "http://localhost:8080/api/v1/accounts/departments",
            dataType: 'json',
            processResults: (data) => ({
                results: data.content.map((dep) => ({ id: dep.id, text: dep.name })),
            }),
        },
    });
}

function deleteAccount(accountId) {
    if (!confirm("Are you sure you want to delete this account?")) return;

    $.ajax({
        url: `http://localhost:8080/api/v1/accounts/${accountId}`,
        type: 'DELETE',
        success: () => {
            alert("Account deleted successfully.");
            buildAccountTable();
        },
        error: (error) => console.error("Error deleting account: ", error),
    });
}

function editAccount(accountId) {
    // Logic for editing account can be implemented here
    alert(`Edit account with ID: ${accountId}`);
}

function prevPage() {
    if (currentPage > 1) {
        currentPage--;
        buildAccountTable();
    }
}

function nextPage() {
    currentPage++;
    buildAccountTable();
}
