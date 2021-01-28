package students.model;

public class Student {

    private int id;
    private String fio;
    private int mark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return fio;
    }

    public void setName(String name) {
        this.fio = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Student() {
    }

    public Student(int id, String fio, int mark) {
        this.id = id;
        this.fio = fio;
        this.mark = mark;
    }
}
