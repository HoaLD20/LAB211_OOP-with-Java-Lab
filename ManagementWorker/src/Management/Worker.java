package Management;

public class Worker{
    
    private String id;
    private String name;
    private int age;
    private int salary;
    private String worklocation;


    public Worker(String id, String name, int age, int salary, String worklocation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.worklocation = worklocation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getWorklocation() {
        return worklocation;
    }

    public void setWorklocation(String worklocation) {
        this.worklocation = worklocation;
    }

}