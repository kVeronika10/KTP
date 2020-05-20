import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Insert first string: ");
        String string=in.nextLine();
        System.out.print("Insert second string: ");
        String string2=in.nextLine();
        System.out.print("Rhyme or not? "+ doesRhyme(string,string2));
        
    }

    public static boolean doesRhyme(String str1,String str2)
    {
        String regular="eyuioa";
        String help1="";
        String help2="";
        String[] new1=str1.split(" ");
        String[] new2=str2.split(" ");
        String last1=new1[new1.length-1];
        String last2=new2[new2.length-1];
        for (int i=0;i<last1.length();i++)
        {
           char vowel=last1.charAt(i);
           if (regular.indexOf(Character.toLowerCase(vowel))!=-1)
               help1+=vowel;
        }
        for (int i=0;i<last2.length();i++)
        {
            char vowel=last2.charAt(i);
            if (regular.indexOf(Character.toLowerCase(vowel))!=-1)
                help2+=vowel;
        }
        return help1.equals(help2);

    }
}