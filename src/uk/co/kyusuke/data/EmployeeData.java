package uk.co.kyusuke.data;

public class EmployeeData {
	private int employeeId;
	private String name;
	
	public EmployeeData(int employeeId, String name){
		this.employeeId = employeeId;
		this.name = name;
	}
	
	public int getEmployeeId() { return employeeId; }
	public String getName() { return name; }
}
