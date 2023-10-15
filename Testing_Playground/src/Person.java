public class Person {
    private String name;
    private int age;

    // Constructor
    public Person()
    {
        name = "noName";
        age = 18;
    }
    public Person(String name)
    {
        this.name = name;
        age = 18;
    }

    public Person(int age)
    {
        this.age = age;
        this.name = "noName";
    }
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    
    public void setName(String name){ this.name = name; }
    public String getName(){ return this.name; }
    public void setAge(int age){this.age = age; }
    public int getAge() {return this.age;}
    public void sayName(){ System.out.println("Hi my name is " + name + " an I am " + age + " Years old"); }
    public void haveBirthday(){ age++;}
    public String toString(){ return this.name + " " + age; }
}