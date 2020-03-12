import java.util.List;
import java.util.Scanner;

public class CompanyManagment {
    public static void main(String[] args) {

        EmployeeDAOImpl dao=EmployeeDAOImpl.getInstance();

        didplayAllEmployee(dao);

        //addNewEmployee(dao);
        //addNewEmployee(dao);

        //findEmployeeByID(dao);

        //UpdateEmployeeByID(dao);
        //delete employee by ID
        deleteEmployeeByID(dao);
    }

    private static void deleteEmployeeByID(EmployeeDAOImpl dao) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an employee ID that you want to delete:");
        int id = Integer.parseInt(sc.nextLine().trim());
        dao.deletEmp(id);
    }

    private static void UpdateEmployeeByID(EmployeeDAOImpl dao) {
        //Search employee ID
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an employee id");
        int id =Integer.parseInt(sc.nextLine());
        Employee emp=dao.findEmp(id);
        System.out.print(emp.toString());
        //get new data
        System.out.print("Enter new Salary for employee ID"+emp.getEmpID()+":");
        double ns = Double.parseDouble(sc.nextLine().trim());
        //edit data
        emp.setSalary(ns);
        //update data into database
        dao.updateEmp(emp);
    }

    private static void findEmployeeByID(EmployeeDAOImpl dao) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an employee id");
        int id =Integer.parseInt(sc.nextLine());
        Employee emp=dao.findEmp(id);
        System.out.print(emp.toString());
    }

    private static void addNewEmployee(EmployeeDAOImpl dao) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee id:");
        int id = Integer.parseInt(sc.nextLine().trim());
        System.out.println("Enter employee Name");
        String Name = sc.nextLine();
        System.out.print("Emter employee Position");
        String Position = sc.nextLine();
        System.out.print("Enter employee Salary:");
        Double salary = Double.parseDouble(sc.nextLine().trim());

        dao.addEmp(new Employee(id,Name,Position,salary));
    }

    private static void didplayAllEmployee(EmployeeDAOImpl dao) {
        List<Employee>emp=dao.getAllEmp();
        for (Employee e:emp){
            System.out.println(e.toString());
        }
    }
}
