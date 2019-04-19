package lesson_5;

public class HanoiTower {

    static int countOfDisks = 4;
    static int countRec = 0;
    static int countFor = 0;
    private static long timeConsumedMillisCTR = 0;
    private static long timeConsumedMillisCTF = 0;

    public static void main(String[] args) {
        System.out.println("Необходимо перенести " + countOfDisks + " дисков(-а)");
        System.out.println("Рекурсивный метод:");
        changeTowersRec(1,2,3, countOfDisks);
        System.out.println("\nИтерационный метод: ");
        changeTowerFor(countOfDisks);
        System.out.println("В рекурсивном методе потребовалось выполнить " + countRec + " перемещений. На что потребовалось целых " + timeConsumedMillisCTR + " миллисекунд");
        System.out.println("В итерационном методе потребовалось выполнить " + countFor + " перемещений. На что потребовалось целых " + timeConsumedMillisCTF + " миллисекунд");
    }

    // Итеративный метод решения головоломки
    private static void changeTowerFor(int countOfDisks) {
        if (countOfDisks%2==0) System.out.println("Число дисков четное.\nДиски переносим на 2 стержень.");
        else System.out.println("Число дисков нечетное.\nДиски переносим на 3 стержень.");

        long startCTF = System.currentTimeMillis();
        for (int i = 1; i <= (MainPow.powRec(2,countOfDisks)-1); i++) {
            countFor++;
            // Выполним присваивание номеров стержней с использованием побитового сравнения
            int firstStick = ((i&(i-1))%3)+1;
            int nextStick = (((i|(i-1))+1)%3)+1;
            String str = "Диск перенносим с " + firstStick + "-го стержня на " + nextStick+ "-й стержень";
            System.out.println((i) + " " + str);
        }
        long finishCTF = System.currentTimeMillis();
        timeConsumedMillisCTF = finishCTF - startCTF;
    }

    // рекурсивный метод решения головоломки
    private static void changeTowersRec(int startStick, int intermStick, int finishStick, int countOfDisks) {
        countRec++;
        long startCTR = System.currentTimeMillis();

        if (countOfDisks==1) {
            System.out.println("Диск №" + countOfDisks + " перносим с " + startStick + "-го стержня на " + finishStick + "-й стержень");
        }
        else{
            changeTowersRec(startStick, finishStick, intermStick,countOfDisks-1);
            System.out.println("Диск №" + countOfDisks + " перносим с " + startStick + "-го стержня на " + finishStick + "-й стержень");
            changeTowersRec(intermStick, startStick, finishStick, countOfDisks-1);
        }
        long finishCTR = System.currentTimeMillis();
        timeConsumedMillisCTR = finishCTR - startCTR;
    }
}
