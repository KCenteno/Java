package zookeeper;

public class Bat extends Mammal{
	
	public Bat() {
		this.setEnergyLevel(300);
	}
	
	public void fly() {
		this.setEnergyLevel(getEnergyLevel() - 50);
		System.out.println("The Bat flew really high. " + "Bat now has: " + this.getEnergyLevel());
	}
	
	public void eatHumans() {
		this.setEnergyLevel(getEnergyLevel() + 25);
		System.out.println("Look the Bat just ate a human. " + "Bat now has: " + this.getEnergyLevel());
	}

 	public void attackTown() {
 		this.setEnergyLevel(getEnergyLevel() - 100);
		System.out.println("Run for your lives the Bat is attacking the town. " + "Bat now has: " + this.getEnergyLevel());
}


}
