package ppj.zad01;

public class Main
{
    public static void main(String[] args)
    {
        int tab[][] = new int[10][10];
        int x = 0;
        for(int i = 0; i < tab.length/2+1; i++)
        {
            for(int j = x; j < tab.length - x; j++)
            {
                for(int k = x; k < tab[j].length - x; k++ )
                {
                    tab[j][k] = x;
                }

            }
            x++;
        }

        for(int i = 0; i < tab.length; i++)
        {
            for(int j = 0; j < tab[i].length; j++)
            {
                System.out.print(tab[i][j]);
            }
            System.out.println();
        }

        boolean tab1[][] = new boolean[10][10];
        for(int i = 0; i < tab1.length; i++)
        {
            for(int j = 0; j < tab1[i].length; j++)
            {
                if(i+j % 2 == 0)
                    tab1[i][j] = true;
                else
                    tab1[i][j] = false;
            }
        }
    }
}

