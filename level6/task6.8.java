import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Insert the number: ");
        int number=in.nextInt();
        System.out.print("Rezult: "+convertToRoman(number));
    }
    public static String convertToRoman(int number) {
        String rezult = "";

        while (number >= 1000)
        {
            rezult += "M";
            number -= 1000;
        }
        while (number >= 900)
        {
            rezult += "CM";
            number -= 900;
        }
        while (number >= 500)
        {
            rezult += "D";
            number -= 500;
        }
        while (number >= 400)
        {
            rezult += "CD";
            number -= 400;
        }
        while (number >= 100)
        {
            rezult += "C";
            number -= 100;
        }
        while (number >= 90)
        {
            rezult += "XC";
            number -= 90;
        }
        while (number >= 50)
        {
            rezult += "L";
            number -= 50;
        }
        while (number >= 40)
        {
            rezult += "XL";
            number -= 40;
        }
        while (number >= 10)
        {
            rezult += "X";
            number -= 10;
        }
        while (number >= 9)
        {
            rezult += "IX";
            number -= 9;
        }
        while (number >= 5)
        {
            rezult += "V";
            number -= 5;
        }
        while (number >= 4)
        {
            rezult += "IV";
            number -= 4;
        }
        while (number >= 1)
        {
            rezult += "I";
            number -= 1;
        }
        return rezult;
    }
}