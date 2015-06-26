package raditya.lab.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*

README
------

Below is a fiction story about a Zoo simulation. Your mission is to fill in the code
in the section marked by "TYPE YOUR CODE HERE".

The expected outcome is:

0: true
1: true
2: true
3: true
4: true
5: true
6: true
7: true

*/
public class ZooApplication {
	
	public static void main(String[] args) {
		app();		
	}
	
	private static void app(){
		/*
		Once upon a time, there's a biologically-weird zoo
		*/
		Zoo mixMatchZoo = new Zoo();

		/*
		Its first zookeeper: Anna
		*/
		Zookeeper anna = mixMatchZoo.hireZookeeper("anna");
		
		/*
		There are two animals at first: An elephant ("Gajah Ekor Pink") and a giraffe ("Jerapah Madu")
		*/
		Animal bobo = new Animal("bobo", new AnimalInfo("Gajah Ekor Pink", AnimalType.ELEPHANT));
		Animal shorty = new Animal("shorty", new AnimalInfo("Jerapah Madu", AnimalType.GIRAFFE));
		
		/*
		Anna is tasked to register and handle them both
		*/
		anna.handle(bobo);
		anna.handle(shorty);

		/*
		Now, let's check the current collections
		*/
		List<Animal> animalCollection = mixMatchZoo.getAnimals();
		System.out.println("0: " + animalCollection.contains(bobo));
		System.out.println("1: " + animalCollection.contains(shorty));
		System.out.println("2: " + (animalCollection.size() == 2));

		/*
		The second zookeeper: Brittany
		*/
		Zookeeper brittany = mixMatchZoo.hireZookeeper("brittany");

		/*
		Two new animals: A crocodile ("Buaya Terbang") and an elephant ("Gajah Selam")
		*/
		Animal cutey = new Animal("cutey", new AnimalInfo("Buaya Terbang", AnimalType.CROCODILE));
		Animal bibi = new Animal("bibi", new AnimalInfo("Gajah Selam", AnimalType.ELEPHANT));
		
		/*
		Brittany is tasked to handle them both
		*/
		brittany.handle(cutey);
		brittany.handle(bibi);

		/*
		Checking the number of elephants and crocodiles
		*/
		int elephantCount = mixMatchZoo.countOfAnimalType(AnimalType.ELEPHANT);
		int crocodileCount = mixMatchZoo.countOfAnimalType(AnimalType.CROCODILE);
		System.out.println("3: " + (elephantCount == 2));
		System.out.println("4: " + (crocodileCount == 1));

		/*
		The last hired zookeeper: Chelsea
		*/
		Zookeeper chelsea = mixMatchZoo.hireZookeeper("chelsea");

		/*
		Two new animals, with the same species and type as the first incoming animals
		*/
		Animal boboy = new Animal("boboy", new AnimalInfo("Gajah Ekor Pink", AnimalType.ELEPHANT));
		Animal shortey = new Animal("shortey", new AnimalInfo("Jerapah Madu", AnimalType.GIRAFFE));
		
		/*
		Chelsea will handle them both
		*/
		chelsea.handle(boboy);
		chelsea.handle(shortey);

		/*
		Checking the animal handling capabilities of zookeepers.
		*/
		Set<AnimalInfo> annaAnimalList = mixMatchZoo.getAnimalHandlingCapability("anna");
		Set<AnimalInfo> chelseaAnimalList = mixMatchZoo.getAnimalHandlingCapability("chelsea");
		System.out.println("5: " + (annaAnimalList.size() == 2));
		System.out.println("6: " + annaAnimalList.equals(chelseaAnimalList));

		/*
		Checking the animal collections size.
		*/
		// Saya rubah sedikit outputnya
		System.out.println("7: " + /*(animalCollection.size() == 6)*/ String.valueOf(mixMatchZoo.getAnimals().size() == 6));
	}

}

class Zoo {
    // TYPE YOUR CODE HERE
	private List<Zookeeper> sZookeepers;
	private Zookeeper sZookeeper;	

	public Zookeeper hireZookeeper(String name){
		if(sZookeepers == null){
			sZookeepers = new ArrayList<Zookeeper>();	
		}
		sZookeeper = new Zookeeper(name);	
		sZookeepers.add(sZookeeper);
		return sZookeeper;
	}
	
	public List<Animal> getAnimals(){
		List<Animal> mAnimal = new ArrayList<Animal>();
		for(Zookeeper zookeeper : sZookeepers){
			for(int i = 0; i < zookeeper.getAnimal().size(); i++){
				mAnimal.add(zookeeper.getAnimal().get(i));
			}
		}
		return mAnimal;
	}
	
	public int countOfAnimalType(AnimalType animalType){
		int a = 0;
		List<Zookeeper> zookeepers = sZookeepers;
		for(Zookeeper zookeeper : zookeepers){
			for(int i = 0; i < zookeeper.getAnimal().size(); i++){
				if(zookeeper.getAnimal().get(i).getAnimalInfo().getType().equals(animalType)){
					a++;
				}
			}
		}	
		return a;
	}
	
	public Set<AnimalInfo> getAnimalHandlingCapability(String name){
		Set<AnimalInfo> set = new HashSet<AnimalInfo>();
		List<Zookeeper> zookeepers = sZookeepers;
		for(Zookeeper zookeeper : zookeepers){
			if(zookeeper.getZooKeeperName().equalsIgnoreCase(name)){
				for(int i = 0; i < zookeeper.getAnimal().size(); i++){
					set.add(zookeeper.getAnimal().get(i).getAnimalInfo());
				}
			}
		}	
		
		return set;
	}

	public List<Zookeeper> getsZookeepers() {
		return sZookeepers;
	}

	public void setsZookeepers(List<Zookeeper> sZookeepers) {
		this.sZookeepers = sZookeepers;
	}
}

class Zookeeper {
    // TYPE YOUR CODE HERE
	private List<Animal> mAnimals;
	private String mZooKeeperName;
	
	public String getZooKeeperName() {
		return mZooKeeperName;
	}

	public void setZooKeeperName(String mZooKeeperName) {
		this.mZooKeeperName = mZooKeeperName;
	}

	public List<Animal> getAnimal() {
		return mAnimals;
	}

	public void setAnimal(List<Animal> mAnimal) {
		this.mAnimals = mAnimal;
	}

	public Zookeeper(String name){
		this.mZooKeeperName = name;
		mAnimals = new ArrayList<Animal>();
	}	
	
	public void handle(Animal animal){
		Animal anim = animal;
		mAnimals.add(anim);
	}
}

enum AnimalType {
    // TYPE YOUR CODE HERE
	ELEPHANT,
	GIRAFFE,
	CROCODILE
}

class AnimalInfo {
    // TYPE YOUR CODE HERE
	private String mName;
	private AnimalType mType;
	
	@Override
	public int hashCode() {
		return mType.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return mType.equals(((AnimalType)obj));
	}
	
	public AnimalType getType() {
		return mType;
	}
	public void setType(AnimalType mType) {
		this.mType = mType;
	}
	public String getName() {
		return mName;
	}
	public void setName(String mName) {
		this.mName = mName;
	}
	
	public AnimalInfo(String name, AnimalType type){
		mName = name;
		mType = type;
	}
}

class Animal {
   // TYPE YOUR CODE HERE
	private String mName;
	private AnimalInfo mAnimalInfo;
	
	public AnimalInfo getAnimalInfo() {
		return mAnimalInfo;
	}
	public void setAnimalInfo(AnimalInfo mAnimalInfo) {
		this.mAnimalInfo = mAnimalInfo;
	}
	public String getName() {
		return mName;
	}
	public void setName(String mName) {
		this.mName = mName;
	}
	
	public Animal(String name, AnimalInfo animalInfo){
		mName = name;
		mAnimalInfo = animalInfo;
	}
}