package seminar3.task2;

public class Main {
    public static void main(String[] args) {
        try (Counter counter = new Counter(0)) {
            counter.close();
            counter.add();
            System.out.println(counter.getCount());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
