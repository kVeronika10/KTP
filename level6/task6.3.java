import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Insert the string: ");
        String string=in.nextLine();
        System.out.print("Rezult: "+validColor(string));
        
    }

    public static boolean validColor(String string)
    {
        String[] temp = string.substring(string.indexOf('(')+1, string.indexOf(')')).split(",");
        if (string.contains("rgba") && temp.length != 4 || (string.contains(",,")))
            return false;
        for (int i = 0; i < temp.length ; i++)
        {
            double number = Double.parseDouble(temp[i]);
            if (i==3)
            {
                if (!(number >= 0 && number <= 1.0))
                    return false;
            }
            else if (!(number >= 0 && number <= 255))
                return false;
        }
        return true;
    }
}