import java.util.Arrays;
import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Insert the string with spaces after each digit: ");
        String string=in.nextLine();
        System.out.print("Rezult: "+formula(string));
        
    }
    public static boolean formula(String string)
    {
        int count = 0;
        for(int i = 0; i < string.length(); i++)
        {
            if(string.charAt(i) == ' ')
                count++;
        }
        String[] newString = new String[count+1];
        Arrays.fill(newString,"");
        count = 0;

        for(int i = 0; i < string.length(); i++)
        {
            if(string.charAt(i) == ' ')
                count++;
            else
                newString[count] += string.charAt(i);
        }
        if (count > 4 || !(newString[3].equals("=")))
            return false;
        try
        {
            int mas1 = Integer.parseInt(newString[0]);
            int mas2 = Integer.parseInt(newString[2]);
            int mas3 = Integer.parseInt(newString[4]);
            if (newString[1].equals("+"))
                return (mas1 + mas2) == mas3;
            else if (newString[1].equals("-"))
                return (mas1 - mas2) == mas3;
            else if (newString[1].equals("*"))
                return (mas1 * mas2) == mas3;
            else if (newString[1].equals("/"))
                return (mas1 / mas2) == mas3;
            else return false;
        }
        catch (Throwable e)
        {
            return false;
        }
    }
}