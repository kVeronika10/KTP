import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Insert the number: ");
        int n = in.nextInt();
        System.out.println("Rezult: \n"+hexLattice(n));
    }

    public static String hexLattice(int number)
    {
        String first = "";
        String second = "";
        int count = 1;
        int i=0;
        int j=0;
        for (i = 1; count < number; i++)
            count += i*6;
        if (number!=count)
            return "Invalid";
        for (j = 0; j < i*2-1; j++)
            second += "o ";

        first = second;

        for (j = 1; j < i; j++)
        {
            first = " " + first.substring(0, first.length()-2);
            second = first  + "\n" +  second + "\n" + first;
        }
        return second;
    }
}