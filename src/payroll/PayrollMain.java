package payroll;
import java.util.Scanner;

public class PayrollMain {
	private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Payroll payroll = new Payroll();
        int menuOption;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Ingresar horas y tarifa de pago de los empleados.");
            System.out.println("2. Listar nómina.");
            System.out.println("3. Mostrar información de un empleado.");
            System.out.println("4. Salir.");
            System.out.print("Seleccione una opción: ");

            menuOption = getIntInput();

            switch (menuOption) {
                case 1:
                    enterEmployeeData(payroll);
                    break;
                case 2:
                    payroll.calculateWages();
                    payroll.printEmployeeWages();
                    break;
                case 3:
                    showEmployeeInfo(payroll);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (menuOption != 4);
    }

    private static void enterEmployeeData(Payroll payroll) {
        for (int i = 0; i < payroll.employeeId.length; i++) {
            System.out.println("\nEmpleado ID " + payroll.employeeId[i]);
            System.out.print("Ingrese horas trabajadas: ");
            int hours = getIntInput();
            while (hours < 0) {
                System.out.println("Las horas no pueden ser negativas. Por favor, intente de nuevo.");
                hours = getIntInput();
            }
            payroll.setHours(i, hours);

            System.out.print("Ingrese la tarifa de pago por hora: ");
            double payRate = getDoubleInput();
            while (payRate < 6.00) {
                System.out.println("La tarifa de pago debe ser al menos de 6.00. Por favor, intente de nuevo.");
                payRate = getDoubleInput();
            }
            payroll.setPayRate(i, payRate);
        }
    }

    private static void showEmployeeInfo(Payroll payroll) {
        System.out.print("Ingrese el ID del empleado: ");
        int id = getIntInput();
        int index = payroll.findEmployeeIndex(id);
        if (index != -1) {
            System.out.println("Empleado ID: " + payroll.employeeId[index] +
                               ", Horas trabajadas: " + payroll.getHours(index) +
                               ", Tarifa de pago: $" + payroll.getPayRate(index) +
                               ", Salario bruto: $" + payroll.getGrossPay(id));
        } else {
            System.out.println("ID de empleado no encontrado.");
        }
    }

    private static int getIntInput() {
        while (!scanner.hasNextInt()) {
            scanner.next(); 
            System.out.println("Entrada inválida. Por favor ingrese un número entero.");
        }
        return scanner.nextInt();
    }

    private static double getDoubleInput() {
        while (!scanner.hasNextDouble()) {
            scanner.next(); 
            System.out.println("Entrada inválida. Por favor ingrese un número.");
        }
        return scanner.nextDouble();
    }

}




    