package _04_animals_inheritance;

public class Animal {
	
	protected String name;
	protected String furColor;
	protected boolean isGirl;
	
	public Animal(String name, String furColor, boolean isGirl){
		this.name = name;
		this.furColor = furColor;
		this.isGirl = isGirl;
	}
	
	public void printName() {
		System.out.println("My name is " + name);
	}
	
	public void play() {
		System.out.println("playing");
	}
	
	public void eat() {
		System.out.println("eating");
	}
	
	public void sleep() {
		System.out.println("sleeping");
	}

}
