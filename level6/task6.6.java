import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

class Scratch {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Insert the number: ");
        int number=in.nextInt();
        System.out.print("Rezult: "+ulam(number));
    }
    public static int ulam(int number)
    {
        Vector<Integer> vector = new Vector<Integer>();
        vector.add(1);
        vector.add(2);
        for (int i = 3; i < 2000; i++)
        {
            int count = 0;
            for (int j = 0; j < vector.size()-1; j++)
            {
                for (int k = j + 1; k < vector.size(); k++)
                {
                    if (vector.get(j) + vector.get(k) == i)
                        count++;
                    if (count > 1)
                        break;
                }
                if (count > 1)
                    break;
            }
            if (count == 1)
                vector.add(i);
        }
        return vector.get(number-1);
    }

}