package payroll;

public class Payroll {

    int[] employeeId = {5658845, 4520125, 7895122, 8777541, 8451277, 1302850, 7580489};
    private int[] hours = new int[7];
    private double[] payRate = new double[7];
    private double[] wages = new double[7];


    public Payroll() {}

    public void setHours(int index, int hoursWorked) {
        if (hoursWorked >= 0) {
            this.hours[index] = hoursWorked;
        } else {
            System.out.println("Error: Hours cannot be negative.");
        }
    }

    public void setPayRate(int index, double payRate) {
        if (payRate >= 6.00) {
            this.payRate[index] = payRate;
        } else {
            System.out.println("Error: Pay rate must be at least 6.00.");
        }
    }

    public double getGrossPay(int employeeId) {
        int index = findEmployeeIndex(employeeId);
        if (index != -1) {
            return hours[index] * payRate[index];
        } else {
            System.out.println("Error: Employee ID not found.");
            return 0.0;
        }
    }

    int findEmployeeIndex(int employeeId) {
        for (int i = 0; i < this.employeeId.length; i++) {
            if (this.employeeId[i] == employeeId) {
                return i;
            }
        }
        return -1;
    }
    


    public void calculateWages() {
        for (int i = 0; i < this.employeeId.length; i++) {
            this.wages[i] = this.hours[i] * this.payRate[i];
        }
    }

    
    public void printEmployeeWages() {
        for (int i = 0; i < this.employeeId.length; i++) {
            System.out.println("Employee ID: " + this.employeeId[i] +
                               ", Gross Wages: $" + this.wages[i]);
        }
    }
    
    public int getHours(int index) {
        return hours[index];
    }

    public double getPayRate(int index) {
        return payRate[index];
    }
}



