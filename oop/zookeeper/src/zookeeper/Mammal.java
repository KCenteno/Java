package zookeeper;

public class Mammal {

	public int energyLevel=100;
	
	
	public int displayEnergy() {
		System.out.println("This is the energy level:" + energyLevel );
		return this.displayEnergy();
	}


	public int getEnergyLevel() {
		return energyLevel;
	}


	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	
}
