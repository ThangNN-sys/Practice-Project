// Khai báo đối tượng storage
// Ý nghĩa:
//      Đối tượng storage được khai báo để quản lý lưu trữ dữ liệu, cung cấp các phương thức lưu trữ, truy xuất, 
//      và xóa dữ liệu thông qua localStorage hoặc sessionStorage tùy thuộc vào thiết lập "Remember Me"
var storage = {

    // Hàm saveRememberMe(isRememberMe)
    // Ý nghĩa:
    // Lưu trạng thái "Remember Me" vào localStorage.
    // Tham số:
    //      isRememberMe: Giá trị (kiểu boolean) chỉ định người dùng có muốn "ghi nhớ đăng nhập" hay không.
    // Lưu ý:
    //      Sử dụng localStorage để lưu trạng thái này vì nó không bị mất khi đóng trình duyệt
    saveRememberMe(isRememberMe) {
        localStorage.setItem("IS_REMEMBER_ME", isRememberMe);
    },

    // Hàm getRememberMe()
    // Ý nghĩa:
    // Lấy trạng thái "Remember Me" từ localStorage.
    // Chi tiết:
    //      Nếu không tồn tại giá trị, mặc định trả về true.
    //      Sử dụng JSON.parse để chuyển đổi chuỗi về giá trị kiểu boolean.
    getRememberMe() {
        var rememberMeStr = localStorage.getItem("IS_REMEMBER_ME");
        if (rememberMeStr == null) {
            return true;
        }

        // https://stackoverflow.com/questions/263965/how-can-i-convert-a-string-to-boolean-in-javascript
        return JSON.parse(rememberMeStr.toLowerCase());
    },

    // Hàm setItem(key, value)
    // Ý nghĩa:
    // Lưu trữ dữ liệu với key và value vào localStorage hoặc sessionStorage.
    // Cơ chế:
    //      Nếu "Remember Me" bật, lưu vào localStorage (dữ liệu tồn tại lâu dài).
    //      Ngược lại, lưu vào sessionStorage (dữ liệu bị xóa khi đóng trình duyệt).
    setItem(key, value) {
        if (this.getRememberMe()) {
            localStorage.setItem(key, value);
        } else {
            sessionStorage.setItem(key, value);
        }
    },

    // Hàm getItem(key)
    // Ý nghĩa:
    //      Lấy giá trị từ localStorage hoặc sessionStorage dựa trên trạng thái "Remember Me".
    getItem(key) {
        if (this.getRememberMe()) {
            return localStorage.getItem(key);
        } else {
            return sessionStorage.getItem(key);
        }
    },

    // Hàm removeItem(key)
    // Ý nghĩa:
    //      Xóa một mục (key-value) khỏi localStorage hoặc sessionStorage tùy thuộc vào trạng thái "Remember Me".
    removeItem(key) {
        if (this.getRememberMe()) {
            return localStorage.removeItem(key);
        } else {
            return sessionStorage.removeItem(key);
        }
    }
};