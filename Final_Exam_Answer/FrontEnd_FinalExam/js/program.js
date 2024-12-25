// Phần $(function () { ... }): Đây là một cách viết rút gọn của $(document).ready().
// Nó đảm bảo rằng mã bên trong chỉ chạy sau khi toàn bộ DOM đã được tải xong
$(function () {

    // Kiểm tra đăng nhập
    // isLogin(): Kiểm tra xem người dùng có đăng nhập hay chưa bằng cách kiểm tra sự tồn tại của giá trị "ID" trong storage
    // Hành động:
    //      Nếu chưa đăng nhập, chuyển hướng (redirect) đến trang đăng nhập loginform.html.
    //      return để dừng thực thi các dòng mã sau
    if (!isLogin()) {
        // redirect to login page
        window.location.replace("http://127.0.0.1:5500/html/login/loginform.html");
        return;
    }

    // Tải nội dung động vào các phần của trang
    // Ý nghĩa:
    // Dùng phương thức load() của jQuery để nạp nội dung HTML từ các tệp riêng lẻ (header.html, sidebar.html, v.v.) vào các phần tương ứng trên trang (.header, .sidebar, .main, .footer).
    // Sau khi tải thành công, các hàm callback sẽ được gọi để cập nhật nội dung động:
    //      .header: Hiển thị tên đầy đủ của người dùng (FULL_NAME).
    //      .sidebar: Hiển thị thông báo cá nhân với họ của người dùng (LAST_NAME).
    //      .main: Tương tự như sidebar, hiển thị thông báo chào mừng.
    //      .footer: Chỉ tải nội dung HTML, không thực hiện hành động nào sau đó
    $(".header").load("./common/header.html", function () {
        document.getElementById("header-fullname").innerHTML = storage.getItem("FULL_NAME");
    });
    $(".sidebar").load("./common/sidebar.html", function () {
        document.getElementById("sidebar-lastname").innerHTML = 'Hello ' + storage.getItem("LAST_NAME") + "!";
    });
    $(".main").load("./home/homePage.html", function () {
        document.getElementById("line-2").innerHTML = 'Hello ' + storage.getItem("LAST_NAME") + "!";
    });
    $(".footer").load("./common/footer.html");
});

// Hàm kiểm tra đăng nhập
// Ý nghĩa:
//      Kiểm tra nếu người dùng đã đăng nhập (có ID trong storage).
//      Trả về true nếu có, ngược lại trả về false.
function isLogin() {
    if (storage.getItem("ID")) {
        return true;
    }
    return false;
}

// Hàm đăng xuất
// Ý nghĩa:
//      Xóa toàn bộ thông tin đăng nhập của người dùng khỏi storage.
//      Chuyển hướng người dùng trở lại trang đăng nhập.
function logout() {
    storage.removeItem("ID");
    storage.removeItem("FULL_NAME");
    storage.removeItem("FIRST_NAME");
    storage.removeItem("LAST_NAME");
    storage.removeItem("ROLE");
    storage.removeItem("USERNAME");
    storage.removeItem("PASSWORD");

    // redirect to login page
    window.location.replace("http://127.0.0.1:5500/html/login/loginform.html");

}

// Hiển thị thông báo SnackBar
// Ý nghĩa:
// Hiển thị thông báo dạng "SnackBar" (thanh thông báo ngắn ở dưới cùng màn hình).
// Các bước:
//      Lấy phần tử #snackbar từ DOM.
//      Cập nhật nội dung của SnackBar bằng chuỗi thông báo snackbarMessage.
//      Thêm lớp CSS "show" để hiển thị SnackBar.
//      Sau 3 giây (3000 ms), xóa lớp "show" để ẩn SnackBar.
function showSuccessSnackBar(snackbarMessage) {
    // Get the snackbar DIV
    var x = document.getElementById("snackbar");
    x.innerHTML = snackbarMessage;

    // Add the "show" class to DIV
    x.className = "show";

    // After 3 seconds, remove the show class from DIV
    setTimeout(function () { x.className = x.className.replace("show", ""); }, 3000);
}