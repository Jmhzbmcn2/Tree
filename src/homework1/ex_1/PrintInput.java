package homework1.ex_1;

import java.util.Scanner;

public class PrintInput {

    public void print(Scanner sc) {
        System.out.print("Hãy nhập một số nguyên: ");
        int intNumber = sc.nextInt();
        System.out.println("Số nguyên vừa nhập là: " + intNumber);
        System.out.print("Hãy nhập một số thực: ");
        double douNumber = sc.nextDouble();
        System.out.println("Số thực vừa nhập là: " + douNumber);
        System.out.print("Hãy nhập một giá trị true hoặc false: ");
        boolean booleanValue = sc.nextBoolean();
        System.out.println("Giá trị boolean vừa nhập là: " + booleanValue);
        System.out.print("Hãy nhập một kí tự: ");
        char charValue = sc.next().charAt(0);
        System.out.println("Kí tự vừa nhập là: " + charValue);
        sc.nextLine();
        System.out.print("Hãy nhập một chuỗi kí tự: ");
        String stringValue = sc.nextLine();
        System.out.println("Chuỗi kí tự vừa nhập là: " + stringValue);
    }
}
