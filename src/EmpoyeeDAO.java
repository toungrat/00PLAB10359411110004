import java.util.List;

public interface EmpoyeeDAO {
    //CRUD
    public List<Employee> getAllEmp();
    public void addEmp(Employee emp);
    public Employee findEmp(int id);
    public void updateEmp(Employee emp);
    public void deletEmp(int id);

}
