package lesson_5;

public class MainPow {
    public static void main(String[] args) {
        System.out.println(powRec(6,4));
        System.out.println(fastPow(6,5));
        System.out.println(powFor(6,5));
    }

    private static long fastPow(int num, int step) {
        long insight = num;
        if (step%2==0) {
            for (int i = 0; i <= step / 2; i++) {
                insight *= num;
            }
        }
        else{

            for (int i = 0; i <= (step-1)/2; i++) {
                insight*=num;
            }
            insight*=num;

        }
        return insight;
    }

    public static long powRec(long num, int step){
        if (step==1) return num;
        num*= powRec(num,step-1);
        return num;
    }

    public static int powFor(int num, int step){
        int temp = 1;
        for (int i = 0; i < step; i++) temp *= num;
        return temp;
    }


}

