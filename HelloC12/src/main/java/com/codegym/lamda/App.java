package com.codegym.lamda;

public class App {
    /**
     * Xử lý giá trị của tham số a và b.
     * Lúc này chúng ta chưa biết hàm accept(a,b) trả về giá trị gì,
     * vì nó chỉ là một hàm trừu tượng chưa có thân hàm.
     * Chúng ta sẽ cung cấp thân hàm cho phương thức MyFunction.accept()
     * trong hàm main().
     */
    public int action(int a, int b, MyFunction func) {
        return func.accept(a, b);
    }

    public static void main(String[] args) {
        App app = new App();
        // Nguyên thủy
        MyFunction myFunction = new AddFunc();
        int c0  = app.action(2,3, myFunction);

        // Cách nguyên thủy có cải tiến, anonymous function
        app.action(3, 4, new MyFunction() {
            @Override
            public int accept(int a, int b) {
                return (a+b)*3;
            }
        });

        // Cải tiến dùng lamda
        int c12 = app.action(10, 2, (a, b) -> a+b);
//        System.out.println("Tổng 2 số: " + c1);
//        System.out.println("Tổng 2 số: (Cải tiến dùng lamda) " + c1);

        // :: toán tử tham chiếu, dùng phương thức static
        // tạo đối tượng nặc danh addFunc và cung cấp thân hàm cho hàm accept()
        // bây giờ hàm accept() sẽ có thân hàm giống như hàm MyUtils.add().
        // nghĩa là hệ thống copy hàm MyUtils.add() như một bản cài đặt
        // cho hàm accept()
//        MyFunction addFunc = MyUtils::add;
        int c123 = app.action(10, 2, MyUtils::add);
//        System.out.println("Tổng 2 số: (:: toán tử tham chiếu, dùng phương thức static) " + c1);

        // :: toán tử tham chiếu, dùng phương thức từ đối tượng
        Calc calc = new Calc();
        int c1234 = app.action(10, 2, calc::add);
//        System.out.println("Tổng 2 số: (:: toán tử tham chiếu, dùng phương thức từ đối tượng) " + c1);



        MyFunction minusFunc = MyUtils::minus;
        int c2 = app.action(10, 2, minusFunc);
        System.out.println("Hiệu 2 số: " + c2);

        MyFunction maxFunc = Math::max;
        int c3 = app.action(10, 2, maxFunc);
        System.out.println("MAX: " + c3);

        MyFunction minFunc = Math::min;
        int c4 = app.action(10, 2, minFunc);
        System.out.println("MIN: " + c4);
    }
}
