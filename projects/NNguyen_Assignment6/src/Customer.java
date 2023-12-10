/*
 * Class: CMSC203
 * Instructor: Professor Monshi
 * Description:
 * Due: 12/06/2023
 * Platform/compiler: javac
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Nicholas Nguyen
 */

public class Customer {
	private String name;
	private int age;

	public Customer(String name, int age){
		this.name = name;
		this.age = age;
	}

	public Customer(Customer c){
		this.name = new String(c.name);
		this.age = c.age;
	}

	public String getName() { return name; }
	public int getAge() { return age; }
	public void setName(String name) { this.name = name; }
	public void setAge(int age) { this.age = age; }

	@Override
	public String toString(){
		return "Customer name: " + name + '\n'
			 + "Customer age: " + age;
	}
}
