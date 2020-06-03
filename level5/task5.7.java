import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Insert the number: ");
        int n = in.nextInt();
        System.out.print("Number: "+numToEng(n));
    }

    private static String numToEng(int number)
    {
        if(!(number >= 0 && number <= 999))
            return "Error";
        String stringRezult = "";
        String[] one = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        String[] ten = {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","twenty"};
        String[] two = {"","","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
        String[] three = {"","one hundred","two hundred","three hundred","four hundred","five hundred",
                "six hundreds","seven hundred","eight hundred","nine hundred"};
        if (number < 10)
            return one[number];
        else if(number>= 10 && number <= 20)
            return ten[number-10];
        else if(number>20 && number<100)
        {
            String b = Integer.toString(number);
            int fi = Character.getNumericValue(b.charAt(0));
            int tw = Character.getNumericValue(b.charAt(1));
            stringRezult += two[fi] + " " + one[tw];
        }
        else if(number % 100 == 0)
        {
            String b = Integer.toString(number);
            int fi = Character.getNumericValue(b.charAt(0));
            stringRezult += three[fi];
        }
        else
        {
            String b = Integer.toString(number);
            int fi = Character.getNumericValue(b.charAt(0));
            int tw = Character.getNumericValue(b.charAt(1));
            int th = Character.getNumericValue(b.charAt(2));
            stringRezult += three[fi] + " " + two[tw] + " " + one[th];
        }
        return stringRezult;
    }
}