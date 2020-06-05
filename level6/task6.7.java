import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Insert the string: ");
        String string=in.nextLine();
        System.out.print("Rezult: "+longestNonrepeatingSubstring(string));
    }
    public static boolean isTrue(String string)
    {
        for(int i = 0; i < string.length(); i++)
        {
            for(int j = 0; j < string.length(); j++)
            {
                if (i == j)
                    continue;
                if (string.charAt(i) == string.charAt(j))
                    return false;
            }
        }
        return true;
    }
    public static String longestNonrepeatingSubstring(String string)
    {
        String help;
        String rezult = "";
        for(int j = 0; j < string.length(); j++)
        {
            help = "";
            for (int i = j; i < string.length(); i++)
            {
                if (i == 0) help += string.charAt(i);
                else
                {
                    while (isTrue(help))
                    {
                        help += string.charAt(i);
                        if(i != string.length()-1) i++;
                        String temp = help;
                        temp += string.charAt(i);
                        if (!isTrue(temp)) break;
                    }
                    if(help.length() > rezult.length())
                        rezult = help;
                    break;
                }
            }
        }
        return rezult;
    }
}