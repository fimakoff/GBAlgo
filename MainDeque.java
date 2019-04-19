public class MainDeque {

    private static final int MAX_ITEMS = 15;

    public static void main(String[] args) {
        MyArrayDeque<Integer> arrDeque = new MyArrayDeque<>();

        for (int i = 0; i <= MAX_ITEMS; i++) {
            arrDeque.insertLeft(i);
            //System.out.print("\n Итерация " + i + ": " + arrDeque);

        }

        System.out.println("\n" + arrDeque);
    }

}
