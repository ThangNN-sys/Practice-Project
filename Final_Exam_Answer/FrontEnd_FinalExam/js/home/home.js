// Hàm viewHomepage
function viewHomepage() {
    $(".main").load("./home/homePage.html");
    // $(".main"): Sử dụng thư viện jQuery để chọn phần tử HTML có class là main
    // .load("./home/homePage.html"):
    //      Tải nội dung từ file homePage.html (đường dẫn tương đối) vào phần tử có class main.
    //      Phương thức load() thực hiện yêu cầu AJAX để lấy nội dung từ file HTML và hiển thị trực tiếp trong phần tử đã chọn.
}

// Ứng dụng:
// Hàm này thường được sử dụng để hiển thị giao diện chính của trang chủ (homepage) bằng cách tải nội dung từ file homePage.html.
// Kỹ thuật này giúp tăng tính động của ứng dụng web và giảm thời gian tải lại toàn bộ trang.