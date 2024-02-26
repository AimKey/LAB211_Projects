
public class test {
    public static void deQuy (int n) {
        System.out.println("N = " + n);
        if (n <= 8 && n > 0) {
            System.out.println("N < 8, N = " + n);
            deQuy(n - 1);
        }
        if (n <= 3 && n > 0) {
            System.out.println("N < 3, N = " + n);
            deQuy(n - 1);
        }
    }
    public static void main(String[] args) {
        deQuy(8);
    }
   
}
