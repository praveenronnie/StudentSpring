package com.quinbay.march22.dependencyinjection.Repository;

import com.quinbay.march22.dependencyinjection.dto.Department;
import com.quinbay.march22.dependencyinjection.dto.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Departmentdb {
    List<Department> list = new ArrayList<>();

    public  List<Department> getDepartmentList(){

        //if(list.size() == 0 )
        //{
        Department  d1 = new Department(1, "IT", "1234");
        Department  d2 = new Department(2, "CSE", "pqr");
        Department  d3 = new Department(3, "ECE", "xyz");
        list.add(d1);
        list.add(d2);
        list.add(d3);
        return list;
        //}
        //return null;

    }
}
