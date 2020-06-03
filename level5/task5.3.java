import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Insert the 1st word: ");
        String word1=in.nextLine();
        System.out.print("Insert the 2nd word: ");
        String word2=in.nextLine();
        System.out.println(canComplete(word1,word2));
    }

    public static boolean canComplete(String word1, String word2)
    {
        char[] chars = word1.toCharArray();
        int temp=0;

        for (int i = 0; i<chars.length;i++)
        {
            if (word2.indexOf(String.valueOf(chars[i]),temp) != -1)
                temp = word2.indexOf(String.valueOf(chars[i]),temp) + 1;
            else
                return false;
        }
        return true;
    }

}