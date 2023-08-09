package seminar3.task2;

import java.io.IOException;

public class Counter implements AutoCloseable {
    private Integer count;

    public Counter(int count) {
        this.count = count;
    }

    @Override
    public void close() throws Exception {
        this.count = null;
    }

    private void checkCLose() throws IOException {
        if (this.count == null) {
            throw new IOException("Счетчик пустой");
        }
    }

    public void add() throws IOException {
        checkCLose();
        this.count++;
    }

    public Integer getCount() throws IOException {
        checkCLose();
        return count;
    }
}