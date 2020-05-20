import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {
        System.out.print("Your number: ");
        Scanner in=new Scanner(System.in);
        int number=in.nextInt();
        System.out.print("Rezult= "+bugger(number));
    }

    public static int bugger(int number)
    {
        int newNumber;
        if (number/10==0)
            newNumber = 0;
        else
            newNumber=number;

        while (newNumber/10!=0) {
            newNumber = 1;
            while (number % 10 != 0) {
                newNumber *= (number % 10);
                number /= 10;
            }
            if (number/10==0)
                number=newNumber;
        }
        return newNumber;
    }
}