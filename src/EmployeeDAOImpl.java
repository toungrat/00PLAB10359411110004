import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmpoyeeDAO{

    public static String driverName ="org.sqlite.JDBC";
    public static String url ="jdbc:sqlite:D:/OOPLAB10_DATABASE_IS/IS_Company.sqilte";
    public static Connection conn = null;

    public static final String ADD_NEW_EMP="insert into Employee(emoID,Name,Position,Salary)values(?,?,?,?)";


    public static final String GET_ALL_EMP="select * from Employee";

    public static final String FIND_EMP_BY_ID="select * from Emloyee where empID = ? ";

    public static final String UPDATE_EMP = "update Emploree set Name = ?,Position=?,Salary=? where empID=?";

    public static final String DELETE_EMP="delete from Employee where empID=?";

    private static EmployeeDAOImpl instance = new EmployeeDAOImpl();
    public static EmployeeDAOImpl getInstance(){
        return instance;
    }
    private EmployeeDAOImpl(){
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> getAllEmp() {
        List<Employee>emp = new ArrayList<Employee>();
        try {
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(GET_ALL_EMP);

            while (rs.next()){
                int id =rs.getInt(1);
                String Name =rs.getString(2);
                String Position=rs.getString(3) ;
                double Salary =rs.getDouble(4);

                emp.add(new Employee(id,Name,Position,Salary));
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
           return emp;

    }//getAllEmp

    @Override
    public void addEmp(Employee emp) {
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement ps = conn.prepareStatement(ADD_NEW_EMP);

            ps.setInt(1,emp.getEmpID());
            ps.setString(2,emp.getName());
            ps.setString(3,emp.getPosition());
            ps.setDouble(4,emp.getSalary());

            if(ps.execute() == false ) {
                System.out.println("Already add new employee.");
            }else {
                System.out.println("Conld not add new employee");
                ps.close();
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Employee findEmp(int id) {
        Employee emp = null;

        try {
                conn = DriverManager.getConnection(url);
                PreparedStatement ps = conn.prepareStatement(FIND_EMP_BY_ID);

                ps.setInt(1,id);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    int empid = rs.getInt(1);
                    String Name = rs.getString(2);
                    String Position = rs.getString(3);
                    double Salary = rs.getDouble(4);

                }else {
                    System.out.println("Could not found employee with id:"+id);
                }
                rs.close();
                ps.close();
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return emp;

        }




    @Override
    public void updateEmp(Employee emp) {
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement ps = conn.prepareStatement(UPDATE_EMP);

            ps.setString(1,emp.getName());
            ps.setString(2,emp.getPosition();
            ps.setDouble(3),emp.getSalary();
            ps.setInt(4),emp.getEmpID();

            int rs = ps.executeUpdate();
            if (rs!=0){
                System.out.println("Employee with id" + emp.getEmpID());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletEmp(int id) {

        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement ps = conn.prepareStatement(DELETE_EMP);
            ps.setInt(1,id);
            int rs = ps.executeUpdate();
            if (rs!=0){
                System.out.println("Employee with id was deleted.");
            }else {
                System.out.println("conld not delete employee with id"+id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
