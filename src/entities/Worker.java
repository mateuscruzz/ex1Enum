package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	private Department department;
	private List <HourContract> contracts = new ArrayList<>(); // essa lista começa vazia e vai sendo adicionada
															   // contratos nela pelo addContracts
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	public Worker(){
		
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}
	
	public void addContract(HourContract contract) { 	//esse metodo vai pegar a lista de contratos e adicionar o 
		contracts.add(contract);						//contrato que ta no argumento
	}
	public void removeContract(HourContract contract) { 	//esse metodo vai pegar a lista de contratos e remover o 
		contracts.remove(contract);						//contrato que ta no argumento
	}
	
	public double income(int year, int month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for (HourContract c : contracts) {
			cal.setTime(c.getDate()); // pegou a data do contrato e definiu como da data do calendario
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH); //o mes do calendar começa com 0 por isso add mais 1
			if (year== c_year &&  month == c_month) {
				sum += c.totalValue();
			}
		}
		return sum;
	}
}
