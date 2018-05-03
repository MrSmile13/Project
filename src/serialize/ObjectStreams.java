package serialize;

import java.io.*;
import java.util.ArrayList;

class Person implements Serializable{

    public String name;
    public int age;
    public double height;
    public boolean married;

    Person(String n, int a, double h, boolean m){

        name=n;
        age=a;
        height=h;
        married=m;
    }
}

public class ObjectStreams {
    public static void main(String[] args) {
        String catalog = "E:\\Test\\Stream";

        File dir = new File(catalog);

        System.out.printf("Проверяем, существует ли \"%s\" - %s.\n", catalog, dir.exists());

        String fileName = "ObjectStream.txt";

        File newFile = new File((dir.getAbsolutePath() + "\\" + fileName));

        System.out.printf("Имя файла: %s\n", newFile.getName());

        if(newFile.exists()) System.out.printf("Файл %s уже существует.\n\n", newFile.getName());
        else {
            System.out.printf("Файл %s еще не создан.\n", newFile.getName());
            System.out.println("Создание файла...");
            try{
                boolean fileCreated = newFile.createNewFile();
                if(fileCreated) System.out.printf("Файл %s создан.\n\n", newFile.getName());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        ArrayList<Person> pers = new ArrayList<>();

        pers.add(new Person("Олег", 30, 1.80, true));
        pers.add(new Person("Вася", 10, 1.10, false));
        pers.add(new Person("Николай", 60, 1.90, true));

        try(ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream((dir.getAbsoluteFile() + "\\" + fileName)))){

            System.out.println("Запись объекта.");
            oos.writeObject(pers);
            oos.flush();
            System.out.println("Запись завершена.");

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        ArrayList<Person> persons = new ArrayList<>();

        try(ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream((dir.getAbsoluteFile() + "\\" + fileName)))){


            System.out.println("Чтение объекта.");
            persons = (ArrayList<Person>)ois.readObject();
            System.out.println("Чтение завершено.");

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        for(Person p : persons)
            System.out.printf("Имя: %s, возраст: %d, рост: %.2f, женат: %s\n", p.name, p.age, p.height, p.married);

        Person j = persons.get(0);
        String str = persons.get(0).name;
        System.out.printf("Имя: %s, возраст: %d, рост: %.2f, женат: %s\n", j.name, j.age, j.height, j.married);
        System.out.println(str);

    }
}
