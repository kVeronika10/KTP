import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Insert the amount of words: ");
        int n = in.nextInt();
        String[] string=new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Insert the "+ i+"st word: \n");
            string[i]=in.nextLine();
        }
        System.out.print("Rezult"+ Arrays.toString(sameVowelGroup(string)));
    }

    public static String[] sameVowelGroup(String[] string){
        List<String> list = new ArrayList<String>();
        list.add(string[0]);
        String vowel="eyuioa";

        for(int i=1;i<string.length;i++)
        {
            boolean flag=true;
            for(char c: vowel.toCharArray())
            {
                if (string[0].contains(String.valueOf(c))!=string[i].contains(String.valueOf(c)))
                    flag=false;
            }
            if (flag)
                list.add(string[i]);
        }
        return list.toArray(new String[list.size()]);
    }
}