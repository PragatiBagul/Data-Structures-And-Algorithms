import java.io.*;
import java.util.prefs.PreferenceChangeListener;
public class StringPermutations
{
    public static void permutations(String string, String sub) 
    {
        if(string.length() == 0)
        {
            System.out.println(sub);
            return;
        }
        for(int i=0;i<string.length();i++)
        {
            permutations(string.substring(0, i) + string.substring(i+1),sub+Character.toString(string.charAt(i)));
        }
    }
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s =  br.readLine();
        permutations(s, "");
    }
}