import java.util.Scanner;

public class MainApp {
    private final String FILE_NAME = "counter.sav";

    private CounterSaverLoader counterSaverLoader;
    private Counter counter;

    public static void main(String[] args) {
        MainApp mainApp = new MainApp();

        mainApp.init();
        mainApp.run();
        mainApp.close();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        boolean isInterrupted = false;
        while (!isInterrupted && scanner.hasNextLine()) {
            switch (scanner.nextLine()) {
                case ("/inc"):
                    counter.increase();
                    break;
                case ("/reset"):
                    counter.reset();
                    break;
                case ("/stop"):
                    isInterrupted = true;
                    break;
                default:
                    System.out.println("Неизвестная команда.");
            }
        }
    }

    private void init() {
        counterSaverLoader = new CounterSaverLoader(FILE_NAME);
        counter = counterSaverLoader.loadCounter();
    }

    private void close() {
        counterSaverLoader.saveCounter(counter);
        System.out.println("Завершаю работу");
    }
}