import java.sql.SQLOutput;

public class Main {

    static Employee[] EMPLOYEE = new Employee[10];

    public static void main(String[] args) {
        for (int i = 0; i < EMPLOYEE.length; i++) {
            EMPLOYEE[i] = generateEmployee(i + 1);
            printAllEmployee();
        }
        double allSalarys = allSalarys();
        System.out.println("Сумма ЗП в месяц = " + allSalarys);
        Employee employeeWithMinSalary = findEmployeeWithMinSalary();
        System.out.println("Сотрудник с минимальной ЗП: " + employeeWithMinSalary);
        Employee employeeWithMaxSalary = findEmployeeWithMaxSalary();
        System.out.println("Сотрудник с максимальной ЗП: " + employeeWithMaxSalary);
        double averageSalary = averageSalary();
        System.out.println("Средняя ЗП = " + averageSalary);
        printAllFullName();
    }

    public static void printAllEmployee() {
        for (int i = 0; i < EMPLOYEE.length; i++) {
            System.out.println(EMPLOYEE[i]);
        }
    }

    public static Employee generateEmployee(int i) {
        double salaryMin = 30000;
        double salaryMax = 80000;
        return new Employee(
                i,
                "Sergey" + i,
                "Stepanov" + i,
                "Vladimirovich" + i,
                (int) (1 + (5 - 1) * Math.random()),
                salaryMin + (salaryMax - salaryMin) * Math.random()
        );
    }

    public static double allSalarys() {
        double sum = 0;
        for (Employee employee : EMPLOYEE) {
            sum = sum + employee.getSalary();
        }
        return sum;
    }

    public static Employee findEmployeeWithMinSalary() {
        double minSalary = Double.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < EMPLOYEE.length; i++) {
            if (EMPLOYEE[i].getSalary() < minSalary) {
                minSalary = EMPLOYEE[i].getSalary();
                index = i;
            }
        }
        if (index != -1) {
            return EMPLOYEE[index];
        } else {
            return null;
        }
    }

    public static Employee findEmployeeWithMaxSalary() {
        double maxSalary = Double.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < EMPLOYEE.length; i++) {
            if (EMPLOYEE[i].getSalary() > maxSalary) {
                maxSalary = EMPLOYEE[i].getSalary();
                index = i;
            }
        }
        if (index != -1) {
            return EMPLOYEE[index];
        } else {
            return null;
        }

    }

    public static double averageSalary() {
        return allSalarys() / EMPLOYEE.length;
    }

    public static void printAllFullName() {
        for (Employee employee : EMPLOYEE) {
            System.out.println(employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymic());
        }
    }
}