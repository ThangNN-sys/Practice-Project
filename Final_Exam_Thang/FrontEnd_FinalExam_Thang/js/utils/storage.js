var storage = {
    // Hàm xác định loại lưu trữ (localStorage hoặc sessionStorage)
    getStorage() {
        return this.getRememberMe() ? localStorage : sessionStorage;
    },

    // Lưu trạng thái "Remember Me"
    saveRememberMe(isRememberMe) {
        if (isRememberMe) {
            localStorage.setItem("IS_REMEMBER_ME", true);
        } else {
            localStorage.removeItem("IS_REMEMBER_ME");
        }
    },

    // Lấy trạng thái "Remember Me"
    getRememberMe() {
        const rememberMeStr = localStorage.getItem("IS_REMEMBER_ME");
        return rememberMeStr === null ? true : JSON.parse(rememberMeStr.toLowerCase());
    },

    // Lưu dữ liệu vào storage
    setItem(key, value) {
        this.getStorage().setItem(key, value);
    },

    // Lấy dữ liệu từ storage
    getItem(key) {
        return this.getStorage().getItem(key);
    },

    // Xóa dữ liệu từ storage
    removeItem(key) {
        this.getStorage().removeItem(key);
    },

    // Xóa tất cả dữ liệu
    clear() {
        this.getStorage().clear();
    },

    // Hiển thị thông báo (tái sử dụng từ program.js)
    showNotification(message) {
        const snackbar = document.getElementById("snackbar");
        if (snackbar) {
            snackbar.textContent = message;
            snackbar.classList.add("show");

            setTimeout(() => {
                snackbar.classList.remove("show");
            }, 3000);
        } else {
            console.warn("Snackbar element not found!");
        }
    }
};
