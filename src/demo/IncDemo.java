package demo;

public class IncDemo {
    public static void main(String[] args) {
        var a = 1;
        var i = 1;
        System.out.println("before");
        System.out.println("a = " + a);
        System.out.println("i = " + i);
        i++;
        var x = a + i++ + ++i - i--;
        System.out.println("after");
        System.out.println("x = " + x);
        System.out.println("a = " + a);
        System.out.println("i = " + i);
    }
}
