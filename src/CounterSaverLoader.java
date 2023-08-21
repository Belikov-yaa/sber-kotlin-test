import java.io.*;

public class CounterSaverLoader {
    private final String fileName;

    public CounterSaverLoader(String filename) {
        this.fileName = filename;
    }

    public Counter loadCounter() {
        Counter counter;
        try (
                FileInputStream fileInputStream = new FileInputStream(fileName);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {
            counter = (Counter) objectInputStream.readObject();
            System.out.print("Счетчик загружен. ");
            counter.printValue();
        } catch (IOException | ClassNotFoundException e) {
            counter = new Counter(0);
            System.out.print("Счетчик создан. ");
            counter.printValue();
        }
        return counter;
    }

    public void saveCounter(Counter counter) {
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(fileName);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ) {
            objectOutputStream.writeObject(counter);
            System.out.print("Счетчик сохранен. ");
            counter.printValue();
        } catch (IOException e) {
            System.out.println("Не смогли записать счетчик в файл. Счетчик не сохранен.");
            throw new RuntimeException(e);
        }
    }
}
