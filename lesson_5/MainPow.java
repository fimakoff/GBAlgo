package lesson_5;

public class MainPow {
    static int temp = 1;
    public static void main(String[] args) {
        System.out.println(powRec(6,5));
        System.out.println(powFor(6,5));
    }

    public static int powRec(int num, int step){
        if (step==1) return num;
        num*= powRec(num,step-1);
        return num;
    }

    public static int powFor(int num, int step){
        for (int i = 0; i < step; i++) temp *= num;
        return temp;
    }
}

