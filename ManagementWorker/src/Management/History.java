package Management;

public class History extends Worker{
    private String status;
    private String date;
    public History( String status, String date, String id, String name, int age, int salary, String worklocation) {
        super(id, name, age, salary, worklocation);
        this.date = date;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    

}
