import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class House implements Serializable {

    private String NumberOfCad, address;
    private Person landLord;
    private List<Flat> apartments;

    House() {
        NumberOfCad = "";
        address = "";
        landLord = new Person();
        apartments = new ArrayList<>();
    }

    public House(String NumberOfCad, String address, Person landLord, List<Flat> apartments) {
        this.NumberOfCad = NumberOfCad;
        this.address = address;
        this.landLord = landLord;
        this.apartments = apartments;
    }

    public Person getLandLord() {
        return landLord;
    }

    public void setLandLord(Person landLord) {
        this.landLord = landLord;
    }

    public List<Flat> getApartments() {
        return apartments;
    }

    public void setApartments(List<Flat> apartments) {
        this.apartments = apartments;
    }

    public String getNumberOfCad() {
        return NumberOfCad;
    }

    public void setNumberOfCad(String NumberOfCad) {
        this.NumberOfCad = NumberOfCad;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return NumberOfCad.equals(house.NumberOfCad) && address.equals(house.address) && landLord.equals(house.landLord) && apartments.equals(house.apartments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NumberOfCad, address, landLord, apartments);
    }

    @Override
    public String toString() {
        return "House {" +
                "Cad Number = '" + NumberOfCad + '\'' +
                ", address = '" + address + '\'' +
                ", landLord = " + landLord +
                ", apartments = " + apartments +
                '}';
    }
}