public class Bubblesort {


    static void bubbleSort(int liste[])
    {
        int n = liste.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (liste[j] > liste[j+1])
                {
                    int temp = liste[j];
                    liste[j] = liste[j+1];
                    liste[j+1] = temp;
                }
    }

    static int fakultaet( final int n )
    { return n == 0 ? 1 : n * fakultaet( n - 1 ); }

    static void printer(int[] liste)
    {
        int n = liste.length;
        for (int i = 0; i < n; ++i)
            System.out.println(liste[i]);
    }

    static int fib(int n)
    {
        int a = 0, b = 1, c;
        if (n == 0)
            return a;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

        public static void main(String[] args) {
        int[] liste = {0, 9, 4, 6, 2, 8, 5, 1, 7, 3};
        bubbleSort(liste);
        System.out.println("Liste:");
        printer(liste);
        System.out.println("Fakultät:");
        for (int value : liste)
        java.lang.System.out.println(fakultaet(value));
        System.out.println("Fibonacci:");
        for (int value : liste)
        java.lang.System.out.println(fib(value));
        String str[] = { "b", "k", "r", "v", "n", "z", "a", "o", "p"};
        String temp;
        System.out.println("String Liste:");
        for (int j = 0; j < str.length; j++) {
            for (int i = j + 1; i < str.length; i++) {
                if (str[i].compareTo(str[j]) < 0) {
                    temp = str[j];
                    str[j] = str[i];
                    str[i] = temp;
                }
            }
            System.out.println(str[j]);
        }
    }
}