package behavioralPattern;

interface ArrayFormats {
    public void show(int[] array);
}

class StandardFormat implements ArrayFormats {
    @Override
    public void show(int[] array) {
        System.out.print("{ ");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length - 1] + " }");
    }
}

class PositionalFormat implements ArrayFormats {
    @Override
    public void show(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Array[" + i + "] = " + array[i]);
        }
    }
}
class MyArray {
    private int[] array;
    private int size;
    private ArrayFormats arrayFormats;

    public MyArray(int size) {
        this.array = new int[size];
    }

    public void add(int value, int position) {
        this.array[position] = value;
    }

    public void setStrategy(ArrayFormats arrayFormats) {
        this.arrayFormats = arrayFormats;
        this.arrayFormats.show(this.array);
    }
}

public class Strategy {
    public static void main(String[] args) {
        new Strategy().execute();
    }

    public void execute() {
        MyArray m = new MyArray(10);
        m.add(6, 1);
        m.add(8, 0);
        m.add(1, 4);
        m.add(7, 9);
        System.out.println("Formato corrente");
        m.setStrategy(new StandardFormat());
        System.out.println("Formato Posicional");
        m.setStrategy(new PositionalFormat());
    }
}
