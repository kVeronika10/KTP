import java.util.HashMap;
import java.util.Map;

class Scratch {
    public static void main(String[] args) {
        String[] b = {"b"};
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2",b));
    }

    public static String stripUrlParams(String url, String ...arg)
    {
        String rezult = "";
        Map<String, String> map = new HashMap<>();
        String[] temp = url.split("\\?");
        rezult += temp[0];
        if (temp.length!=1)
        {
            temp = temp[1].split("&");
            for (int i = 0; i<temp.length; i++)
            {
                String[] couple = temp[i].split("=");
                if (map.containsKey(couple[0]))
                {
                    map.replace(couple[0], couple[1]);
                }
                else map.put(couple[0], couple[1]);
            }
            rezult += "?";
        }
        for (String i : arg)
        {
            if (map.containsKey(i)) map.remove(i);
        }
        for (String j : map.keySet())
        {
            rezult += j + "=" + map.get(j) + "&";
        }
        return rezult.substring(0,rezult.length()-1);
    }
}