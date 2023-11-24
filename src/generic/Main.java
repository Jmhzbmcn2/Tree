package generic;

public class Main {
    public static void main(String[] args) {
        Box box = new Box<Integer>(15);
        System.out.println(box.getValue());

        Box box1 = new Box<String>("Book");
        System.out.println(box1.getValue());

        Box box2 = new Box<Double>(2.2);
        System.out.println(box2.getValue());
    }
}
