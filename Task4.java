package homeworks;

public class Task4 {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        int c;
        c = a;
        a = b;
        b = c;
        System.out.println(a);
        System.out.println(b);

        int d = 5;
        int e = 10;
        d = d + e;
        e = e - d;
        e = -e;
        d = d - e;
        System.out.println(d);
        System.out.println(e);
    }
}
