import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Insert the word: ");
        String string1=in.nextLine();
        System.out.println(translateWord(string1));
        System.out.print("Insert the string: ");
        String string2=in.nextLine();
        System.out.println(translateSentence(string2));
    }

    public static String translateWord (String string)
    {
        if  (String.valueOf(string.charAt(0)).matches("[aeyuioAEYUIO]"))
            return string + "yay";
        else
        {
            while(!String.valueOf(string.charAt(0)).matches("[aeyuioAEYUIO]"))
            {
                String sym = string.substring(0, 1);
                string = string.substring(1) + sym.toLowerCase();
            }
            return string + "ay";
        }
    }
    public static String translateSentence (String string)
    {
        boolean flag = false;
        String rezult = "";
        String temp = "";

        if  (String.valueOf(string.charAt(string.length()-1)).matches("[.!?]"))
        {
            temp = String.valueOf(string.charAt(string.length()-1));
            string = string.substring(0, string.length()-2);
        }
        String[] helper = string.split(" ");
        for (String word : helper)
        {
            word = translateWord(word);
            if (!word.toLowerCase().equals(word))
            {
                word = word.toLowerCase();
                word = word.substring(0,1).toUpperCase() + word.substring(1);
            }
            if (flag)
                word+=temp;
            rezult += word + " ";
        }
        return rezult;
    }
}