import java.util.Scanner;
class Scratch {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Insert the string: ");
        int number=in.nextInt();
        System.out.println(palindromeDescendant(number));
    }
    public static boolean palindromeDescendant(int number)
    {
        String newNumber = Integer.toString(number);
        String temp = "";

        for (int i = 0; i < newNumber.length(); i++)
            temp += newNumber.charAt(i);
        for (int i = 0; newNumber.length() >= 2; i++)
        {
            if (newNumber.equals(temp))
                return true;
            newNumber = "";

            for (int y = temp.length() - 1; y > 0; y -= 2)
                newNumber += Character.getNumericValue(temp.charAt(y)) + Character.getNumericValue(temp.charAt(y - 1));
            temp = "";

            for(int x = 0; x < newNumber.length(); x++)
                temp += newNumber.charAt(x);
        }
        return false;
    }

}