package entities;

public class Employee {
	
	private String empFirstName;
	private String empMiddleName;
	private String empLastName;
		
	public Employee(String firstName, String middleName, String lastName) {
		empFirstName = firstName;
		empMiddleName = middleName;
		empLastName = lastName;		
	}
	
	public String getFirstName() {
		return empFirstName;		
	}
	
	public String getMiddleName() {
		return empMiddleName;		
	}
	
	public String getLastName() {
		return empLastName;		
	}
}
