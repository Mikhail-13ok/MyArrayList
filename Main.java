import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person(25, "Ban");
        Person person2 = new Person(22, "Bob");
        Person person3 = new Person(29, "Alen");
        Person person4 = new Person(39, "Mikl");
        Person person5 = new Person(25, "Mik");
        MyArrayList<Person> my = new MyArrayList <>(3);
        my.add(person1);
        my.add(person2);
        my.add(person3);
        System.out.println(my.getSize());
        my.add(1,person4);
        my.display();
        System.out.println("________");
        my.get(0);
        System.out.println("________");
        my.add(person5);
        my.display();
       /* my.remove(2);
        my.display();
        System.out.println("________");
        my.remove(0);
        my.display();
        System.out.println("________");
        my.clear();
        my.display();
        my.display();*/
        my.quickSort(Comparator.comparing(Person::getAge));
        my.display();
        my.quickSort(Comparator.comparing(Person::getName));
        my.display();
    }

}
