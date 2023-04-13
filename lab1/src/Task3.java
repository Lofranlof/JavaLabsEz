public class Task3
{
    public static void main(String[] args)
    {
        long begin = new java.util.Date().getTime();
        //int i = 0;
        long i = 0L;
        while (i < 100000000)
        {
            i++;
        }
        long end = new java.util.Date().getTime();
        // System.out.println(begin);
        // System.out.println(end);
        System.out.println(end - begin);
    }
}
    
