package homeworks;

public class Task3 {
    public static void main(String[] args) {
        int x = 5;
        x += 1;
        System.out.println(x);

        int y = ++x;
        System.out.println(y);
        System.out.println(x);

        int z = x++;
        System.out.println(z);
        System.out.println(x);
    }
}
