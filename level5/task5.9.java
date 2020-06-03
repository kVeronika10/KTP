import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Insert the string: ");
        String string = in.nextLine();
        System.out.print("Rezult: "+correctTitle(string));
    }

    public static String correctTitle(String string)
    {
        String[] arrayOfWords = string.split(" ");
        String stringRezult = "";
        for (int i = 0; i < arrayOfWords.length; i++)
        {
            if (i>0)
                stringRezult += " ";
            String[] noHyphens = arrayOfWords[i].split("-");
            for (int j = 0; j < noHyphens.length; j++)
            {
                if(j>0)
                    stringRezult += "-";
                if (noHyphens[j].equalsIgnoreCase("and")
                        || noHyphens[j].equalsIgnoreCase("the")
                        || noHyphens[j].equalsIgnoreCase("of")
                        || noHyphens[j].equalsIgnoreCase("in"))
                {
                    stringRezult += noHyphens[j].toLowerCase();
                }
                else
                {
                    stringRezult += noHyphens[j].substring(0,1).toUpperCase();
                    stringRezult += noHyphens[j].substring(1).toLowerCase();
                }
            }
        }
        return stringRezult;
    }
}