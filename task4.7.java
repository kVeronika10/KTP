import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Insert your string: ");
        String str=in.nextLine();
        System.out.print(" Rezult: "+toStarShorthand(str));
    }

    public static StringBuilder toStarShorthand(String str)
    {
        int count=1;
        StringBuilder rezult = new StringBuilder();
        for (int i=0;i<str.length()-1;i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                count += 1;
                if (i!=str.length()-2)
                    continue;
            }
            if (count>1) {
                rezult.append(str.charAt(i) + "*" + count);
            }
            else
                rezult.append(str.charAt(i));
            if ((i==str.length()-2) && (count==1))
                rezult.append(str.charAt(str.length()-1));
            count=1;
        }
        return rezult;
    }
}