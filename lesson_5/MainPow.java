package lesson_5;

public class MainPow {
    public static void main(String[] args) {
        int number = 6;
        int step = 9;
        System.out.println(powRec(number, step));
        System.out.println(powFor(number,step));
        System.out.println(fastPowFor(number,step));
        System.out.println(fastPowRec(number, step));

    }

    private static long fastPowRec(long num, int step) {
        if (step == 0) return 1;
        if (step % 2 == 0) {
            long insight = fastPowRec(num, step / 2);
            return insight * insight;
        } else {
            return fastPowRec(num, (step - 1)) * num;
        }
    }

    private static long fastPowFor(int num, int step) {
        long insight = 1;
        while(step!=0){
            if (step%2 == 1) insight *=num;
            num*=num;
            step = step >>1;
        }
        return insight;
    }

    public static long powRec(long num, int step) {
        if (step == 1) return num;
        num *= powRec(num, step - 1);
        return num;
    }

    public static int powFor(int num, int step) {
        int temp = 1;
        for (int i = 0; i < step; i++) temp *= num;
        return temp;
    }
}

