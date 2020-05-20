import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Insert first number: ");
        long n1=in.nextLong();
        System.out.print("Insert second number: ");
        long n2=in.nextLong();
        System.out.print("True or false? "+trouble(n1,n2));
        
    }
    public static boolean trouble (long n1,long n2)
    {
        String str1=Long.toString(n1);
        String str2=Long.toString(n2);
        char number = '-';
        int count=1;
        boolean flag=false;
        for (int i=0;i< str1.length()-1;i++)
        {
            if (str1.charAt(i)==str1.charAt(i+1)) {
                count += 1;
                if (count==3) {
                    number = str1.charAt(i);
                    break;
                }
                else {
                    if (count > 3) {
                        count = 1;
                        number = '-';
                    }
                }
            }
        }
        count=1;
        for (int i = 0; i < str2.length() - 1; i++) {
            if ((str2.charAt(i) == str2.charAt(i + 1)) && (str2.charAt(i) == number)) {
                count+=1;
                flag = true;
            }
            if (count!=2)
                flag=false;
            }
        return flag;
    }
}