package seminar1.hw.task3;

public class Answer {
    public int[] divArrays(int[] a, int[] b){
        // Введите свое решение ниже
        if(a.length != b.length) return new int[]{0};
        for (int i = 0; i < b.length; i++) {
            if (b[i] == 0) throw new RuntimeException("Divide by zero is not permitted");
        }
        int[] c = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] / b[i];
        }
        return c;
    }
}
