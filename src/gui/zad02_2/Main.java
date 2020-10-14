package gui.zad02_2;

public class Main
{
    public static void main(String[] args)
    {
        Spiewak s1 = new Spiewak("Eminem"){
            /*<- kod */
        };

        Spiewak s2 = new Spiewak("Eagles"){
            /*<- kod */
        };

        Spiewak s3 = new Spiewak("Dżem"){
            /*<- kod */
        };

        Spiewak sp[] = {s1, s2, s3};

        for (Spiewak s : sp)
            System.out.println(s);

        System.out.println("\n" + Spiewak.najglosniej(sp));
    }
}
