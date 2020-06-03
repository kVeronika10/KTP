import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Insert the number: ");
        long n = in.nextLong();
        System.out.print("Number or not? "+validateCard(n));
    }

    public static boolean validateCard (long number)
    {
        if (!String.valueOf(number).matches("[0-9]{14,19}"))
            return false;
        long helper = number % 10;
        number = number / 10;
        int sum = 0;
        String string = Long.toString(number);
        StringBuffer buffer = new StringBuffer(string);
        buffer.reverse();

        for (int i=0;i<string.length();i++)
        {
            if (i%2 == 0)
            {
                int temp = Character.getNumericValue(string.charAt(i)) * 2;
                sum += temp / 10;
                sum += temp % 10;
            }
            else
                sum += Character.getNumericValue(string.charAt(i));
        }

        if (10 - sum%10 == helper)
            return true;
        return false;
    }
}