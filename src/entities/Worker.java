package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

	private String name;
	private WorkerLevel level;
	private Double basicSalary;
	private Department deparment;
	private List<HourContract> contract = new ArrayList<>();

	public Worker() {
	}

	public Worker(String name, WorkerLevel level, Double basicSalary, Department deparment) {
		this.name = name;
		this.level = level;
		this.basicSalary = basicSalary;
		this.deparment = deparment;
	}

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

	public Double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(Double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public Department getDepartment() {
		return deparment;
	}

	public void setDeparment(Department deparment) {
		this.deparment = deparment;
	}

	public List<HourContract> getContract() {
		return contract;
	}

	public void addContract(HourContract contract) { //adicionar o contrato no arrayList de HourContract.
		this.contract.add(contract);
	}

	public void removeContract(HourContract contract) { //remove o contrato no arrayList de HourContact.
		this.contract.remove(contract);

	}

	public double income(int year, int month) {
		double sum = basicSalary;
		Calendar cal = Calendar.getInstance();
		for (HourContract c : this.contract) {
			cal.setTime(c.getDate()); // pegando a data do contrato de definindo no calendario.
			int c_year = cal.get(Calendar.YEAR); // pegando ano da data
			int c_month = 1 + cal.get(Calendar.MONTH); // pegando o mês.
			if (year == c_year && month == c_month) {
				sum += c.totalValue();
			}
		}

		return sum;
	}
 
}
