import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Insert the weight: ");
        String weight=in.nextLine();
        System.out.print("Insert the height: ");
        String height=in.nextLine();
        System.out.println(BMI(weight,height));
    }


    public static String BMI(String weight, String height)
    {
        String rezult="";
        String[] strW=weight.split(" ");
        double w=Double.parseDouble(strW[0]);
        String[] strH=height.split(" ");
        double h=Double.parseDouble(strH[0]);
        if (strW[1].equals("pounds"))
            w*=0.453592;
        if (strH[1].equals("inches"))
            h*=0.0254;
        double index= w/Math.pow(h,2);
        if (index<18.5)
            rezult=String.format("%.1f", index)+" Underweight";
        if ((index>18.5)&&(index<24.9))
            rezult=String.format("%.1f", index)+" Normalweight";
        if (index>25)
            rezult=String.format("%.1f", index)+" Overweight";
        return rezult;
    }


}