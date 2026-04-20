public class Test {

    public static void main() {

        int a = 10;
        int b = 20;

        if (a < b) {
            System.out.println("a jest mniejsze od b");
        } else {
            System.out.println("a nie jest mniejsze od b");
        }

        for (int i = 0; i < 5; i = i + 1) {
            System.out.println("i = " + i);
        }

        try {
            int wynik = a / 0;
            System.out.println("wynik = " + wynik);
        } catch {
            System.out.println("błąd");
        }

        return;
    }
}