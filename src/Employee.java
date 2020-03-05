public class Employee {
    //attributes
    private int empID;
    private String Name;
    private String Position;
    private double Salary;

    public Employee(int empID, String name, String position, double salary) {
        this.empID = empID;
        Name = name;
        Position = position;
        Salary = salary;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empID=" + empID +
                ", Name='" + Name + '\'' +
                ", Position='" + Position + '\'' +
                ", Salary=" + Salary +
                '}';
    }
}

