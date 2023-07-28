package seminar1.hw.task2;

public class Answer {
    public int[] subArrays(int[] a, int[] b){
        // Введите свое решение ниже
        int[] c = new int[a.length];
        if (a.length != b.length) return new int[]{0};
        else {
            for (int i = 0; i < a.length; i++) {
                c[i] = a[i] - b[i];
            }
        }
        return c;
    }
}
