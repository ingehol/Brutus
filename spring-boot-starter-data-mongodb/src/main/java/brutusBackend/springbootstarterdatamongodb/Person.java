package brutusBackend.springbootstarterdatamongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "brutus")
public class Person {

	@Id
	 String seq;
	 String firstName;
	 String lastName;
	 String age;
	 String street;
	 String city;
	 String state;
	 String latitude;
	 String longitude;
	 String ccnumber;
	 
	 public Person() {
		 
	 }

	 public Person(String seq, String firstName, String lastName, String age,
			String street, String city, String state, String latitude, String longitude, String ccnumber) {
		this.seq = seq;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.street = street;
		this.city = city;
		this.state = state;
		this.latitude = latitude;
		this.longitude = longitude;
		this.ccnumber = ccnumber;
	 }
	  
	public String getSeq() {
	  return seq;
	}

	public void setSeq(String seq) {
		 this.seq = seq;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
		

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getCcnumber() {
		return ccnumber;
	}

	public void setCcnumber(String ccnumber) {
		this.ccnumber = ccnumber;
	}


}
