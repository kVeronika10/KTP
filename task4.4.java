
import java.math.RoundingMode;
import java.util.Scanner;
class Scratch {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Insert start of work: ");
        String start=in.nextLine();
        System.out.print("Insert end of work: ");
        String end=in.nextLine();
        System.out.print("Insert cash for a hour: ");
        String cash=in.nextLine();
        System.out.print("Insert factor: ");
        String factor=in.nextLine();
        double[] array=new double[] {Double.parseDouble(start), Double.parseDouble(end), Double.parseDouble(cash), Double.parseDouble(factor)};
        System.out.print("Money $"+overTime(array));
    }


    public static String overTime(double[] array) {
        double money = 0;
        if (array[1] <= 17)
            money = (array[1] - array[0]) * array[2];
        else if (array[1] > 17) {
            money = (17 - array[0]) * array[2] + (array[1] - 17) * array[2] * array[3];
        }
        return String.format("%.2f", money);
    }
}
