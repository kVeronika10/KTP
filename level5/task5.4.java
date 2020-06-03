
class Scratch {
    public static void main(String[] args) {

        System.out.println("Rezult: "+sumDigProd(1,2,3,4,5,6));
    }

    public static int sumDigProd(int... number){
        int rezult = 0;
        for (int i : number)
        {
            rezult += i;
        }
        int temp = rezult;
        while (temp > 9)
        {
            temp = 1;
            do
            {
                temp *= rezult % 10;
                rezult = rezult / 10;
            }
            while (rezult != 0);
            rezult = temp;
        }
        return rezult;
    }
}