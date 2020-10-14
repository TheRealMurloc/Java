package gui.zad02_2;

public abstract class Spiewak
{
    static int incrementNumber = 1;

    String nazwisko;
    int numerStartowy;

    public Spiewak(String nazwisko) {
        this.nazwisko = nazwisko;
        this.numerStartowy = incrementNumber++;
    }

    abstract String spiewaj();

    @Override
    public String toString() {
        return "(" + numerStartowy + ") " + nazwisko + ": " + spiewaj();
    }

    static Spiewak najglosniej(Spiewak[] tab)
    {
        Spiewak najglosniejszy = null;
        int ile = 0;
        for(Spiewak s : tab)
        {
            int tmp = 0;
            for(int i = 0; i < s.spiewaj().length(); i++)
            {
                if(Character.isUpperCase(s.spiewaj().charAt(i)))
                    tmp++;
            }
            if(tmp > ile) {
                najglosniejszy = s;
                ile = tmp;
            }
        }
        return najglosniejszy;
    }
}
