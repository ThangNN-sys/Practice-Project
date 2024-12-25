// Khởi tạo khi tài liệu sẵn sàng
$(function () {
    $("#id01").css('display', 'block'); 
    // Hiển thị phần tử HTML có ID id01
    setupEnterLoginEvent();
    // Gọi hàm để thiết lập sự kiện nhấn phím Enter.
    setDefaultRememberme();
    // Gọi hàm để đặt trạng thái mặc định cho checkbox "Remember Me"
});

// Thiết lập sự kiện Enter để đăng nhập
// keyup: Lắng nghe sự kiện nhấn phím trên trường username và password. Nếu nhấn Enter (keyCode = 13), hàm login() được gọi
function setupEnterLoginEvent() {
    $("#username").on("keyup", function (event) {
        // enter key code = 13
        if (event.keyCode === 13) {
            login();
        }
    });

    $("#password").on("keyup", function (event) {
        // enter key code = 13
        if (event.keyCode === 13) {
            login();
        }
    });
}

// Thiết lập trạng thái mặc định của "Remember Me"
function setDefaultRememberme() {
    var isRememberMe = storage.getRememberMe();
    // storage.getRememberMe(): Lấy trạng thái "Remember Me" từ bộ nhớ (localStorage hoặc sessionStorage)
    document.getElementById("rememberMe").checked = isRememberMe;
    // checked: Thiết lập trạng thái đã chọn hoặc bỏ chọn cho checkbox rememberMe
}

// Xử lý đăng nhập
function login() {
    // Get username & password - Thu thập dữ liệu: Lấy giá trị từ các trường username và password
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    // validate - Kiểm tra hợp lệ
    // Gọi các hàm isValidUsername() và isValidPassword() để kiểm tra.
    var validUsername = isValidUsername(username);
    var validPassword = isValidPassword(password);

    // format
    if (!validUsername || !validPassword) {
        return;
    }

    // validate username 6 -> 30 characters - Kiểm tra độ dài của username và password
    if (username.length < 6 || username.length > 50 || password.length < 6 || password.length > 50) {
        // show error message
        showLoginFailMessage();
        return;
    }

    // Gọi API: Nếu hợp lệ, gọi hàm callLoginAPI() để thực hiện đăng nhập
    callLoginAPI(username, password);
}

// Gửi yêu cầu đăng nhập tới API
function callLoginAPI(username, password) {

    $.ajax({
        url: 'http://localhost:8080/api/v1/auth/login', // url: Gửi yêu cầu đến API login tại localhost:8080
        type: 'GET',
        contentType: "application/json",
        dataType: 'json', // datatype return
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(username + ":" + password));
            // beforeSend: Gắn thông tin xác thực vào header dưới dạng Basic Auth
        },
        // success: Lưu thông tin người dùng vào bộ nhớ và chuyển hướng đến trang chương trình
        success: function (data, textStatus, xhr) {
            // save remember me
            var isRememberMe = document.getElementById("rememberMe").checked;
            storage.saveRememberMe(isRememberMe);

            // save data to storage
            // https://www.w3schools.com/html/html5_webstorage.asp
            storage.setItem("ID", data.id);
            storage.setItem("FULL_NAME", data.fullName);
            storage.setItem("FIRST_NAME", data.firstName);
            storage.setItem("LAST_NAME", data.lastName);
            storage.setItem("ROLE", data.role);
            storage.setItem("USERNAME", username);
            storage.setItem("PASSWORD", password);

            // redirect to home page
            window.location.replace("http://127.0.0.1:5500/html/program.html");
        },
        
        // error: Hiển thị lỗi nếu đăng nhập thất bại (401)
        error(jqXHR, textStatus, errorThrown) {
            if (jqXHR.status == 401) {
                showLoginFailMessage();
            } else {
                console.log(jqXHR);
                console.log(textStatus);
                console.log(errorThrown);
            }
        }
    });
}

var error_message_username = "Please input!";
var error_message_password = "Please input!";

// Kiểm tra hợp lệ cho username và password
// isValidUsername và isValidPassword:
// Hiển thị lỗi nếu trường trống.
// Ẩn lỗi nếu hợp lệ
function isValidUsername(username) {

    if (!username) {
        // show error message
        showFieldErrorMessage("incorrect-mess", "username", error_message_username);
        return false;
    }

    hideFieldErrorMessage("incorrect-mess", "username");
    return true;
}

function isValidPassword(password) {

    if (!password) {
        // show error message
        showFieldErrorMessage("incorrect-mess", "password", error_message_password);
        return false;
    }

    hideFieldErrorMessage("incorrect-mess", "password");
    return true;
}

// Hiển thị thông báo lỗi đăng nhập: Hiển thị thông báo "Login fail!" cho cả trường username và password
function showLoginFailMessage() {
    showFieldErrorMessage("incorrect-mess", "username", "Login fail!");
    showFieldErrorMessage("incorrect-mess", "password", "Login fail!");
}

// Hiển thị và ẩn thông báo lỗi cho trường

// showFieldErrorMessage: Hiển thị thông báo lỗi bên dưới trường nhập liệu và đổi màu viền sang đỏ
function showFieldErrorMessage(messageId, inputId, message) {
    document.getElementById(messageId).innerHTML = message;
    document.getElementById(messageId).style.display = "block";
    document.getElementById(inputId).style.border = "1px solid red";
}

// hideFieldErrorMessage: Ẩn thông báo lỗi và khôi phục màu viền mặc định
function hideFieldErrorMessage(messageId, inputId) {
    document.getElementById(messageId).style.display = "none";
    document.getElementById(inputId).style.border = "1px solid #ccc";
}

// Hiển thị thông báo SnackBar

// SnackBar: Hiển thị thông báo ngắn gọn trong 3 giây bằng cách thêm lớp CSS show vào phần tử snackbar
function showSuccessSnackBar(snackbarMessage) {
    // Get the snackbar DIV
    var x = document.getElementById("snackbar");
    x.innerHTML = snackbarMessage;

    // Add the "show" class to DIV
    x.className = "show";

    // After 3 seconds, remove the show class from DIV
    setTimeout(function () { x.className = x.className.replace("show", ""); }, 3000);
}