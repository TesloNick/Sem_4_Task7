import java.util.Objects;
import java.io.Serializable;

public class Person implements Serializable {

    private String surname, name, middleName;
    private int day, month, year;

    public Person() {
        surname = "";
        name = "";
        middleName = "";
        day = 0;
        month = 0;
        year = 0;
    }

    public Person(String surname, String name, String middleName, int day, int month, int year) throws Exception {
        if (surname == null || "".equals(surname) || name == null || "".equals(name) || middleName == null || "".equals(middleName)) {
            throw new Exception("Не внесены данные по Ф/И/О!");
        } else if ((day <= 0 || day > 31) || (month <= 0 || month > 12) || (year < 0)) {
            throw new Exception("Некорректная дата!");
        }
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) throws Exception {
        if (day <= 0 || day > 31) {
            throw new Exception("Некорректный день!");
        }
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) throws Exception {
        if (month <= 0 || month > 12) {
            throw new Exception("Некорректный месяц!");
        }
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) throws Exception {
        if (year < 0) {
            throw new Exception("Некорректный год!");
        }
        this.year = year;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) throws Exception {
        if (surname == null || "".equals(surname)) {
            throw new Exception("Пустая фамилия!");
        }
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name == null || "".equals(name)) {
            throw new Exception("Пустое имя!");
        }
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) throws Exception {
        if (middleName == null || "".equals(middleName)) {
            throw new Exception("Пустое отчество!");
        }
        this.middleName = middleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return day == person.day && month == person.month && year == person.year && Objects.equals(surname, person.surname) && Objects.equals(name, person.name) && Objects.equals(middleName, person.middleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, middleName, day, month, year);
    }

    @Override
    public String toString() {
        return "Person{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}