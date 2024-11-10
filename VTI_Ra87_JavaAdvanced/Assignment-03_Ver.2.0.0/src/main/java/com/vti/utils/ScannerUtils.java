package com.vti.utils;

import java.util.Scanner;

public class ScannerUtils {

    /**
     * Phương thức kiểm tra giá trị được nhập có phải là kiểu short không
     * @return short result
     */
    public static short getShortInput() {
        Scanner scanner = new Scanner(System.in);
        short result;
        while (true) {
            if (scanner.hasNextShort()) {
                result = scanner.nextShort();
                break;
            } else {
                System.out.println("PLEASE ENTER A VALID SHORT NUMBER OF TYPE");
                scanner.next(); // Xóa bỏ giá trị không hợp lệ khỏi bộ đệm
            }
        }

        return result;
    }

    /**
     * Phương thức kiểm tra giá trị được nhập có phải là kiểu short >0 không
     * @return short result > 0
     */
    public static short getPositiveShortInput() {
        Scanner scanner = new Scanner(System.in);
        short result;

        while (true) {
            if (scanner.hasNextShort()) {
                result = scanner.nextShort();
                if (result > 0) {
                    break;  // Thoát khỏi vòng lặp nếu là số dương
                } else {
                    System.out.println("PLEASE ENTER SHORT TYPE > 0");
                }
            } else {
                System.out.println("PLEASE ENTER A VALID SHORT TYPE > 0");
                scanner.nextShort(); // Xóa bỏ giá trị không hợp lệ khỏi bộ đệm
            }
        }
        return result;
    }

    /**
     * Phương thức kiểm tra giá trị được nhập có phải là kiểu số nguyên không
     * @return int result
     */
    public static int getIntegerInput() {
        Scanner scanner = new Scanner(System.in);
        int result;

        while (true) {
            if (scanner.hasNextInt()) {
                result = scanner.nextInt();
                break;  // Thoát khỏi vòng lặp nếu là số nguyên
            } else {
                System.out.println("PLEASE ENTER A VALID INTEGER");
                scanner.next(); // Xóa bỏ giá trị không hợp lệ khỏi bộ đệm
            }
        }
        return result;
    }

    /**
     * Phương thức kiểm tra giá trị được nhập có phải là kiểu số nguyên dương không
     * @return int result > 0
     */
    public static int getPositiveIntInput() {
        Scanner scanner = new Scanner(System.in);
        int result;

        while (true) {
            if (scanner.hasNextInt()) {
                result = scanner.nextInt();
                if (result > 0) {
                    break;  // Thoát khỏi vòng lặp nếu là số nguyên dương
                } else {
                    System.out.println("PLEASE ENTER A POSITIVE INTEGER");
                }
            } else {
                System.out.println("PLEASE ENTER A VALID POSITIVE INTEGER");
                scanner.next(); // Xóa bỏ giá trị không hợp lệ khỏi bộ đệm
            }
        }
        return result;
    }

    /**
     * Phương thức kiểm tra giá trị được nhập có phải là kiểu số thực (float) không
     * @return float result
     */
    public static float getFloatInput() {
        Scanner scanner = new Scanner(System.in);
        float result;

        while (true) {
            if (scanner.hasNextFloat()) {
                result = scanner.nextFloat();
                break;  // Thoát khỏi vòng lặp nếu giá trị là float hợp lệ
            } else {
                System.out.println("PLEASE ENTER A VALID FLOAT NUMBER");
                scanner.next(); // Xóa bỏ giá trị không hợp lệ khỏi bộ đệm
            }
        }
        return result;
    }

    /**
     * Phương thức kiểm tra giá trị được nhập có phải là kiểu số thực (double) không
     * @return double result
     */
    public static double getDoubleInput() {
        Scanner scanner = new Scanner(System.in);
        double result;

        while (true) {
            if (scanner.hasNextDouble()) {
                result = scanner.nextDouble();
                break;  // Thoát khỏi vòng lặp nếu giá trị là double hợp lệ
            } else {
                System.out.println("PLEASE ENTER A VALID DOUBLE");
                scanner.next(); // Xóa bỏ giá trị không hợp lệ khỏi bộ đệm
            }
        }
        return result;
    }

    /**
     * Phương thức kiểm tra giá trị được nhập có phải là kiểu chuỗi không
     * @return non-empty String result
     */
    public static String getStringInput() {
        Scanner scanner = new Scanner(System.in);
        String result;

        while (true) {
            result = scanner.nextLine().trim(); // Lấy chuỗi và loại bỏ khoảng trắng ở đầu và cuối
            if (!result.isEmpty()) {
                break;  // Thoát khỏi vòng lặp nếu chuỗi không rỗng
            } else {
                System.out.println("PLEASE ENTER A NON-EMPTY STRING");
            }
        }
        return result;
    }

    /**
     * Phương thức kiểm tra giá trị được nhập có phải là kiểu chuỗi theo định dạng *@* không
     * @return String email with format *@*
     */
    public static String getEmailInput() {
        Scanner scanner = new Scanner(System.in);
        String email;

        while (true) {
            email = scanner.nextLine().trim(); // Đọc chuỗi và loại bỏ khoảng trắng ở đầu và cuối

            // Kiểm tra xem chuỗi có chứa ký tự '@' không
            if (email.contains("@")) {
                break;  // Thoát khỏi vòng lặp nếu chuỗi có chứa '@'
            } else {
                System.out.println("PLEASE ENTER EMAIL ADDRESS IN CORRECT FORMAT *@*");
            }
        }
        return email;
    }



    /**
     * Phương thức kiểm tra giá trị được nhập có phải là kiểu chuỗi không chứa ký tự trống (khoảng trắng) không
     * @return String password with no spaces
     */
    public static String getPasswordInput() {
        Scanner scanner = new Scanner(System.in);
        String password;

        while (true) {
            password = scanner.nextLine().trim(); // Đọc chuỗi và loại bỏ khoảng trắng ở đầu và cuối

            // Kiểm tra xem mật khẩu có ký tự trống không
            if (!password.isEmpty() && !password.contains(" ")) {
                break;  // Thoát khỏi vòng lặp nếu mật khẩu không rỗng và không chứa ký tự trống
            } else {
                System.out.println("PLEASE ENTER A PASSWORD WITH NO SPACES");
            }
        }
        return password;
    }



    /**
     * Phương thức kiểm tra giá trị được nhập có phải là kiểu boolean (true/false) không
     * @return boolean result
     */
    public static boolean getBooleanInput() {
        Scanner scanner = new Scanner(System.in);
        boolean result;

        while (true) {
            System.out.print(" (ENTER 'TRUE' OR 'FALSE'): ");
            String input = scanner.nextLine().trim().toLowerCase(); // Đọc chuỗi và chuẩn hóa về chữ thường

            if (input.equals("TRUE")) {
                result = true;
                break;
            } else if (input.equals("FALSE")) {
                result = false;
                break;
            } else {
                System.out.println("PLEASE ENTER 'TRUE' OR 'FALSE'");
            }
        }

        return result;
    }
}
