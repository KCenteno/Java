package zookeeper;

public class Gorilla extends Mammal{
	
	public void throwSomething() {
		this.setEnergyLevel(getEnergyLevel() - 5);
		System.out.println("Gorilla threw a big banana. " + "Gorilla now has: " + this.getEnergyLevel());
	}
	
	public void eatBananas() {
		this.setEnergyLevel(getEnergyLevel() + 10);
		System.out.println("Gorilla is well fed. " + "Gorilla now has: " + this.getEnergyLevel());
		
	}

	public void climb() {
		this.setEnergyLevel(getEnergyLevel() - 10);
		System.out.println("Gorilla has climbed a big tree. " + "Gorilla now has " + this.getEnergyLevel());
	}

}
