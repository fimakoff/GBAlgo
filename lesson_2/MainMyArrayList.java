package lesson_2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class MainMyArrayList {
    private static final int MAX_ITEMS = 5000;  //712376316
    private static final int MIN_VALUES = 0;
    private static final int MAX_VALUES = Integer.MAX_VALUE;
    private static final int MAX_NUMS_EXPER = 10;
    private static double averTimeSS = 0;
    private static double averTimeIS = 0;
    private static double averTimeBS = 0;
    private static long[] timeConsumedMillisSS = new long[MAX_NUMS_EXPER];
    private static long[] timeConsumedMillisIS = new long[MAX_NUMS_EXPER];
    private static long[] timeConsumedMillisBS = new long[MAX_NUMS_EXPER];

    public static void main(String[] args) {
        int diff = MAX_VALUES - MIN_VALUES;
        Random rand = new Random();
        System.out.println("Диапазон значений: a_min = " + MIN_VALUES + ", b_max = " + MAX_VALUES);
        System.out.println("Эксперимент будет выполнен " + MAX_NUMS_EXPER + " раз с каждым алогитрмом сортировки");
        // Создаем список и добавляем в него элементы
        MyArrayList<Integer> nums = new MyArrayList<>();
        System.out.println("Размер списка до добавления элементов: " + nums.size());
        for (int i = 0; i < MAX_ITEMS; i++) {
            int rn = rand.nextInt(diff);
            nums.add(rn);
        }

        System.out.println("Размер списка после добавления элементов: " + nums.size() + " элементов\n");

        MyArrayList<Integer> copy1 = new MyArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            copy1.add(nums.get(i));
        }
        MyArrayList<Integer> copy2 = new MyArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            copy2.add(nums.get(i));
        }
        MyArrayList<Integer> copy3 = new MyArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            copy3.add(nums.get(i));
        }
        // Сортировка вставками
        mainInsertionSort(copy1);
        // Сортировка выбором
        mainSelectionSort(copy2);
        // Пузырьковая сортировка
        mainBubbleSort(copy3);
        // Вывод результатов тестирования в консоль
        printer(timeConsumedMillisIS, timeConsumedMillisSS, timeConsumedMillisBS);

    }

    private static void printer(long[] timeIS, long[] timeSS, long[] timeBS) {
        System.out.format("%7s%10s%12s%12s\n", "№ exper", "Insert", "Selected", "Bubble");
        for (int i = 0; i < MAX_NUMS_EXPER; i++) {
            System.out.format("%5d%11d%11d%11d\n", (i + 1), timeIS[i], timeSS[i], timeBS[i]);
        }
        System.out.format("%7s%11.1f%11.1f%11.1f", "Average", averTimeIS, averTimeSS, averTimeBS);
    }

    private static void mainInsertionSort(MyArrayList<Integer> initList) {
        // Массив значений времени начала каждого эсперимента
        long[] startIS = new long[MAX_NUMS_EXPER];
        // Массив значений времени окончания каждого эсперимента
        long[] finishIS = new long[MAX_NUMS_EXPER];

        for (int i = 0; i < MAX_NUMS_EXPER; i++) {
            // Присваивание массива nums, созданного в методе main()
            MyArrayList<Integer> exp = initList;
            // Момент времени начала очередного эксперимента
            startIS[i] = System.currentTimeMillis();
            exp.selectionSort(new MyIntegerComparator());
            // Момент времени окончания очередного эксперимента
            finishIS[i] = System.currentTimeMillis();
            // Длительность очередного эксперимента
            timeConsumedMillisIS[i] = finishIS[i] - startIS[i];
            // Общее время выполнения очередного эксперимента
            averTimeIS += timeConsumedMillisIS[i];
        }
        // Среднее время выполнения сортировки
        averTimeIS = averTimeIS / MAX_NUMS_EXPER;
    }

    private static void mainSelectionSort(MyArrayList<Integer> initList) {
        long[] startSS = new long[MAX_NUMS_EXPER];
        long[] finishSS = new long[MAX_NUMS_EXPER];
        for (int i = 0; i < MAX_NUMS_EXPER; i++) {
            MyArrayList<Integer> exp = initList;
            startSS[i] = System.currentTimeMillis();
            exp.selectionSort(new MyIntegerComparator());
            finishSS[i] = System.currentTimeMillis();
            timeConsumedMillisSS[i] = finishSS[i] - startSS[i];
            averTimeSS += timeConsumedMillisSS[i];
        }
        averTimeSS = averTimeSS / MAX_NUMS_EXPER;
    }

    private static void mainBubbleSort(MyArrayList<Integer> initList) {
        long[] startBS = new long[MAX_NUMS_EXPER];
        long[] finishBS = new long[MAX_NUMS_EXPER];

        for (int i = 0; i < MAX_NUMS_EXPER; i++) {
            MyArrayList<Integer> exp = initList;
            startBS[i] = System.currentTimeMillis();
            exp.selectionSort(new MyIntegerComparator());
            finishBS[i] = System.currentTimeMillis();
            timeConsumedMillisBS[i] = finishBS[i] - startBS[i];
            averTimeBS += timeConsumedMillisBS[i];
        }
        averTimeBS = averTimeBS / MAX_NUMS_EXPER;
    }
}