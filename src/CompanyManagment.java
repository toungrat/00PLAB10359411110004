import java.util.List;
import java.util.Scanner;

public class CompanyManagment {
    public static void main(String[] args) {

        EmployeeDAOImpl dao=EmployeeDAOImpl.getInstance();

        didplayAllEmployee(dao);

        addNewEmployee(dao);

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
