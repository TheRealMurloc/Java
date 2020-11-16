package gui.zad03_1;

public class Square
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

}
