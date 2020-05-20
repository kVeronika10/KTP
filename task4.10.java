import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Scratch {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Insert your string: ");
        String string=in.nextLine();
        System.out.print("Insert end of book: ");
        char end=in.next().charAt(0);
        System.out.print("Amount of unique books: "+countUniqueBooks(string,end));
    }

    public static int countUniqueBooks(String str,char end)
    {
        boolean flag=false;
        Set temp = new HashSet<>();
        for (char i:str.toCharArray())
        {
            if ((i!=end)&&(flag))
                temp.add(i);
            if (i==end) {
                if (!flag)
                    flag = true;
                else
                    flag=false;
            }
        }
        return temp.size();
    }
}