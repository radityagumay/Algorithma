package raditya.lab.algorithm;

public class Something {
	/*public static void main(String[] args){
		People people = new People(merk, size, os, price, country)
		
		
	}*/
}

class People {
	private String merk;
	
	/*public People(String merk, String size, String os, String price,
			String country) {
		super(merk, size, os, price, country);
	}
	
	public void setIndonesianPeople(String merk){
		this.merk = merk;
	}
	
	public String getMerkIndonesianPeople(){*/
	
	
}

abstract class Handphone {
	private String merk;
	private String size;
	private String os;
	private String price;
	private String country;
	
	public Handphone(String merk, String size, String os, String price, String country){
		this.merk = merk;
		this.size = size;
		this.os = os;
		this.price = price;
		this.country = country;
	}
	
	public String getMerk(){
		return merk;
	}
	
	public String getSize(){
		return size;
	}
	
	public String getOS(){
		return os;
	}
	
	public String getPrice(){
		return price;
	}
	
	public String getCountry(){
		return country;
	}
}
