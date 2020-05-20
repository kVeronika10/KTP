import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Insert your string of bracket: ");
        String bkt=in.nextLine();
        System.out.print("Cluster of bracket:"+split(bkt));
    }

    public static StringBuilder split(String bkt)
    {
        StringBuilder rezult=new StringBuilder();
        String cluster="";
        int countR=0;
        for (char i:bkt.toCharArray())
        {
            if (i=='(')
            {
                countR+=1;
                cluster+="(";
            }
            else {
                countR-=1;
                cluster += ")";
            }
            if (countR==0)
            {
                rezult.append(cluster+",");
                cluster="";
            }
        }
        return rezult;
    }
}