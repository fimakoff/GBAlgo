package lesson_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class TestMain {
    private static final int MAX_TM = 20;
    private static final int MAX_RAND = 100;
    private static final int MIN_RAND = -100;
    private static final int DIFF_VALUE = MAX_RAND - MIN_RAND;
    private static final int DIFF_KEY = MAX_TM;
    public static final int MAX_HEIGHT_VAL = 6;
    private static Random randVal = new Random();

    public static void main(String[] args) {

        MyTreeMap<Integer, Integer> []tm = new MyTreeMap[MAX_TM];
        for (int i = 0; i < MAX_TM; i++) {
            Integer[] mas_key =shuffleKeys(MAX_TM);
            tm[i] = new MyTreeMap<>();
            while (true) {
                int key = mas_key[i];
                //int key = randVal.nextInt(200)-100;
                int value = MIN_RAND + randVal.nextInt(DIFF_VALUE);
                tm[i].put(key, value);
                if (tm[i].get(key) >= MAX_HEIGHT_VAL) break;
            }
            System.out.println(" Дерево " + (i + 1) + (tm[i].isBalanced() ? " сбалансировано" : " не сбалансировано"));
        }
    }

    private static Integer[] shuffleKeys(int maxTm) {
        Integer[] arrayKeys = new Integer[maxTm];
        for (int i = 0; i < DIFF_KEY; i++) {
            arrayKeys[i] = i;
        }
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arrayKeys));
        Collections.shuffle(list);
        arrayKeys = list.toArray(new Integer[list.size()]);
        System.out.printf("\n" + Arrays.toString(arrayKeys));
        return arrayKeys;
    }

}
