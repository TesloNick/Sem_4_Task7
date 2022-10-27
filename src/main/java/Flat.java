import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Flat implements Serializable {

    private int NumberOfApart, square;
    private List<Person> Owners;

    Flat() {
        NumberOfApart = 0;
        square = 0;
        Owners = new ArrayList<>();
    }

    public Flat(int NumberOfApart, int square, List<Person> owners) {
        this.NumberOfApart = NumberOfApart;
        this.square = square;
        this.Owners = owners;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public List<Person> getOwners() {
        return Owners;
    }

    public void setOwners(List<Person> owners) {
        Owners = owners;
    }

    public int getNumberOfApart() {
        return NumberOfApart;
    }

    public void setNumberOfApart(int NumberOfApart) {
        this.NumberOfApart = NumberOfApart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flat flat = (Flat) o;
        return NumberOfApart == flat.NumberOfApart && square == flat.square && Owners.equals(flat.Owners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NumberOfApart, square, Owners);
    }

    @Override
    public String toString() {
        return "Flat {" +
                "NumberOfApart = " + NumberOfApart +
                ", square = " + square +
                ", Owners = " + Owners +
                '}';
    }
}