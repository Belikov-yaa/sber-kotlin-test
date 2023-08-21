import java.io.Serializable;

public class Counter implements Serializable {

    private static final long serialVersionUID = 1L;

    private int counterValue;

    public Counter(int counterValue) {
        this.counterValue = counterValue;
    }

    public int getCounterValue() {
        return counterValue;
    }

    public void increase() {
        if (counterValue < Integer.MAX_VALUE) {
            counterValue++;
            System.out.print("Значение счетчика увеличено на 1. ");
            this.printValue();
        } else
            System.out.println("Достигнуто максимальное значение счетчика, увеличение невозможно");
    }

    public void reset() {
        counterValue = 0;
        System.out.println("Значение счетчика сброшено на 0.");
    }

    public void printValue() {
        System.out.printf("Текущее значение {%d}%n", counterValue);
    }
}
