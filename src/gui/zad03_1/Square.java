package gui.zad03_1;

public class Square implements Comparable
{
    static int counter;
    int length;
    int number;

    public Square(int length) {
        this.length = length;
        this.number = counter++;
    }

    public int getArea()
    {
        return length * length;
    }




    @Override
    public String toString() {
        return "(" + number + "): " + getArea();
    }

    @Override
    public int compareTo(Object o) {
        if(o.getArea() == this.getArea())
            return 0;
        else if(o.getArea() > this.getArea())
            return 1;
        else
            return -1;
    }
}
