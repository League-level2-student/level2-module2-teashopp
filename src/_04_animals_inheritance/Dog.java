package _04_animals_inheritance;

public class Dog extends Animal {

	String favoriteToy;
	
	Dog(String name, String furColor, boolean isGirl, String favoriteToy){
		super(name, furColor, isGirl);
		this.favoriteToy = favoriteToy;
	}
	
	public void eat() {
		super.eat();
		System.out.println("kibble");
	}
	
	public void play() {
		System.out.println("fetch");
	}

}
