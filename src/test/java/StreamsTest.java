import static org.junit.Assert.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StreamsTest {

    Streams iostreams = new Streams();

    @org.junit.Test
    public void firstTest() {

        try (OutputStream out = new FileOutputStream("Binary.txt");
             InputStream in = new FileInputStream("Binary.txt")) {
            int[] arr = {1, 2, 3, 4};
            iostreams.writeByteStream(out, arr);
            assertArrayEquals(arr, iostreams.readByteStream(in));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @org.junit.Test
    public void secondTest() {

        try (Writer writer = new FileWriter("Chars.txt");
             Reader reader = new FileReader("Chars.txt")) {
            int[] arr = {1, 2, 3, 4, 5};
            iostreams.writeCharsStream(writer, arr);
            assertArrayEquals(arr, iostreams.readCharsStream(reader));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @org.junit.Test
    public void thirdTest() throws IOException {

        File f1 = new File("RandomAccess.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(f1));
        writer.write("check arr: 5 4 3 2 1");
        writer.close();
        int position = 11;
        String res = "5 4 3 2 1";

        assertEquals(res, iostreams.readRandomAccessFile(f1, position));
    }

    @org.junit.Test
    public void fourthTest() throws IOException {

        File dir = new File("C:\\Users\\ntesl\\IdeaProjects\\Sem_4_Task7");
        List<File> fileRes;
        fileRes = iostreams.filesCatalog("txt", dir);

        List<String> res = new ArrayList<>();
        for (File temp : fileRes) {
            res.add(temp.getName());
        }

        List<String> actRes = new ArrayList<>();
        actRes.add("Binary.txt");
        actRes.add("Chars.txt");
        actRes.add("data.txt");
        actRes.add("RandomAccess.txt");

        assertEquals(actRes, res);
    }

    @org.junit.Test
    public void sixthTest() throws Exception {

        List<Flat> flats = new ArrayList<>();
        List<Person> personFlat2 = new ArrayList<>();
        List<Person> personFlat3 = new ArrayList<>();

        personFlat2.add(new Person("Иванов", "Сергей", "Юрьевич", 15, 2, 2000));
        personFlat2.add(new Person("Иванов", "Юрий", "Денисович", 2, 8, 1975));

        personFlat3.add(new Person("Сергеев", "Евгений", "Павлович", 25, 3, 1980));
        personFlat3.add(new Person("Сергеева", "Анна", "Евгеньевна", 19, 1, 2005));
        personFlat3.add(new Person("Сергеева", "Анастасия", "дмитриевна", 1, 4, 1978));

        flats.add(new Flat(1, 60, personFlat2));
        flats.add(new Flat(2, 100, personFlat3));

        House house = new House("31", "ул. Мира 55", new Person("Богатеев", "Иван", "Олегович", 17, 8, 1980), flats);

        HouseSerializeAndDeserialize.houseSerialize(house, new File("data.txt"));
        assertEquals(house, HouseSerializeAndDeserialize.houseDeserialize(new File("data.txt")));
    }

    @org.junit.Test
    public void eightTaskTest() throws Exception {

        List<Flat> flats = new ArrayList<>();
        List<Person> personFlat2 = new ArrayList<>();
        List<Person> personFlat3 = new ArrayList<>();

        personFlat2.add(new Person("Иванов", "Сергей", "Юрьевич", 15, 2, 2000));
        personFlat2.add(new Person("Иванов", "Юрий", "Денисович", 2, 8, 1975));

        personFlat3.add(new Person("Сергеев", "Евгений", "Павлович", 25, 3, 1980));
        personFlat3.add(new Person("Сергеева", "Анна", "Евгеньевна", 19, 1, 2005));
        personFlat3.add(new Person("Сергеева", "Анастасия", "дмитриевна", 1, 4, 1978));

        flats.add(new Flat(1, 60, personFlat2));
        flats.add(new Flat(2, 100, personFlat3));

        House house = new House("31", "ул. Мира 55", new Person("Богатеев", "Иван", "Олегович", 17, 8, 1980), flats);

        assertEquals(house, HouseJackson.ObjectReturnFromJson(HouseJackson.ObjectJson(house)));
    }
}