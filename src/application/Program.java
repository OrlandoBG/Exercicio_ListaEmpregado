package application;

import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>();
		
		System.out.println("How many employees will be registered?");
		int employeeQuantity = sc.nextInt();
		
		for(int i=0;i<employeeQuantity;i++) {
			System.out.println("Enter the employee id:");
			int id = sc.nextInt();
			
			sc.nextLine();
			System.out.println("Enter the employee name:");
			String name = sc.nextLine();
			
			System.out.println("Enter the employee salary:");
			double salary = sc.nextDouble();
			
			 list.add(new Employee(id,name,salary));
			
		}
		
		System.out.println("Enter the employee id that will have salary  increase:");
		int idSalaryIncrease = sc.nextInt();
		
		Employee emp = list.stream().filter(x -> x.getId() == idSalaryIncrease).findFirst().orElse(null);
		
		if(emp == null) {
			System.out.println("The employee does not exist");
		}else {
			
			System.out.println("Enter the percentage");
			int percentage = sc.nextInt();
			emp.increaseSalary(percentage);
		}
		
		System.out.println("List of employee:");
		
		for(Employee obj : list) {
			System.out.println(obj);
		}
		
		sc.close();

	}

}
