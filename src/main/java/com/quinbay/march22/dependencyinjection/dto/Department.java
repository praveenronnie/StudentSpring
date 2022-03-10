package com.quinbay.march22.dependencyinjection.dto;

public class Department {
    public Integer getId() {
        return Dept_Id;
    }

    public void setId(Integer Dept_Id) {
        this.Dept_Id = Dept_Id;
    }
    private Integer Dept_Id;

    public String getfName() {
        return Dept_Name;
    }

    public void setfName(String Dept_Name) {
        this.Dept_Name = Dept_Name;
    }

    private String Dept_Name;

    public String Prof_Name() {
        return Prof_Name;
    }

    public void Prof_Name(String Prof_Name) {
        this.Prof_Name = Prof_Name;
    }
    private String Prof_Name;


    public Department(int id, String Dept_Name, String Prof_Name){
        this.Dept_Id = id;
        this.Dept_Name = Dept_Name;
        this.Prof_Name = Prof_Name;
    }


    public Department() {

    }

    @Override
    public String toString() {
        return "Department{" +
                "Dept_Id=" + Dept_Id +
                ", Dept_Name='" + Dept_Name + '\'' +
                ", Prof_Name='" + Prof_Name + '\'' +
                '}';
    }
}
