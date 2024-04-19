package midtermkhoakhoa.polynomial;

public class TestPolynomial {
    public static void main(String[] args) {
        /*
         TODO

         - Chạy demo các hàm test.
         - Lưu kết quả chạy chương trình vào file text có tên <Ten_MaSinhVien_MyPolynomial>.txt
           (ví dụ, NguyenVanA_123456_MyPolynomial.txt)
         - Nộp kết quả chạy chương trình (file text trên) cùng với các file source code.
         */
        testArrayPolynomial();
    }

    public static void testArrayPolynomial() {
        /*
         TODO

         - Viết chương trình test các chức năng của ArrayPolynomial (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         */
        //Poly1 = [5, 0, 10, 6]
        Polynomial poly1 = new ArrayPolynomial();
        poly1.insertAtStart(5);
        poly1.insertAtEnd(0);
        poly1.insertAtEnd(6);
        poly1.insertAtPosition(2, 10);
        System.out.println("Polynomial 1");
        System.out.println(poly1);
        System.out.println("---------------------------");

        //Poly2 = [1, 2, 4]
        Polynomial poly2 = new ArrayPolynomial();
        poly2.insertAtStart(2);
        poly2.insertAtStart(1);
        poly2.insertAtEnd(4);
        System.out.println("Polynomial 2");
        System.out.println(poly2);
        System.out.println("---------------------------");

        Polynomial add = ((ArrayPolynomial) poly1).plus((ArrayPolynomial) poly2);
        System.out.println("Adding poly1 and poly2");
        System.out.println(add);
        System.out.println("---------------------------");

        Polynomial minus = ((ArrayPolynomial) poly1).minus((ArrayPolynomial) poly2);
        System.out.println("subtracting poly1 and poly2");
        System.out.println(minus);
        System.out.println("---------------------------");

        Polynomial multiply = ((ArrayPolynomial) poly1).multiply((ArrayPolynomial) poly2);
        System.out.println("Multiplying poly1 and poly2");
        System.out.println(multiply);
        System.out.println("---------------------------");

        System.out.println("Evaluating poly1 with x = 1 is equal to " + poly1.evaluate(1));
        System.out.println("Derivative of poly1 is " + poly1.derivative());
    }

    public static void testListPolynomial() {
        /*
         TODO

         - Viết chương trình test các chức năng của ListPolynomial (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         */
        //Poly1 = [5, 0, 10, 6]
        Polynomial poly1 = new ListPolynomial();
        poly1.insertAtStart(5);
        poly1.insertAtEnd(0);
        poly1.insertAtEnd(6);
        poly1.insertAtPosition(2, 10);
        System.out.println("Polynomial 1");
        System.out.println(poly1);
        System.out.println("---------------------------");

        //Poly2 = [1, 2, 4]
        Polynomial poly2 = new ListPolynomial();
        poly2.insertAtStart(2);
        poly2.insertAtStart(1);
        poly2.insertAtEnd(4);
        System.out.println("Polynomial 2");
        System.out.println(poly2);
        System.out.println("---------------------------");

        Polynomial add = ((ListPolynomial) poly1).plus((ListPolynomial) poly2);
        System.out.println("Adding poly1 and poly2");
        System.out.println(add);
        System.out.println("---------------------------");

        Polynomial minus = ((ListPolynomial) poly1).minus((ListPolynomial) poly2);
        System.out.println("subtracting poly1 and poly2");
        System.out.println(minus);
        System.out.println("---------------------------");

        Polynomial multiply = ((ListPolynomial) poly1).multiply((ListPolynomial) poly2);
        System.out.println("Multiplying poly1 and poly2");
        System.out.println(multiply);
        System.out.println("---------------------------");

        System.out.println("Evaluating poly1 with x = 1 is equal to " + poly1.evaluate(1));
        System.out.println("Derivative of poly1 is " + poly1.derivative());
    }

    public static void testRootSolver() {
        /*
         TODO

         - Tạo đa thức có nghiệm trong khoảng [a, b] nào đó.
         - Viết chương trình tìm nghiệm của đa thức theo các phương pháp đã cho (Bisection, Newton-Raphson, Secant) sử dụng
           PolynomialRootFinding. Các phương pháp tìm nghiệm của thể thay đổi ở thời gian chạy chương trình.
         - In ra phương pháp sử dụng, đa thức, và nghiệm của đa thức.
         */

    }
}
