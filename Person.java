public class Person implements Comparable<Person>{
    private int Age;
    private String Name;

    public Person (int Age, String Name) {
        this.Age = Age;
        this.Name = Name;
    }
    public int getAge(){
        return Age;
    }

    public String getName(){
        return Name;
    }


    @Override
    public String toString() {
        return "Person{" +
                "Age=" + Age +
                ", Name='" + Name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return Integer.compare(this.Age, o.Age);
    }
}
