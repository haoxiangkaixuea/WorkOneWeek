package cn.edu.scujcc.workoneweke;

import java.io.Serializable;
import java.lang.annotation.Annotation;

public class Student implements Serializable {
 private  String StuName;
    private  String ClassName;

    @Override
    public String toString() {
        return "学生信息{" +
                "学生名字='" + StuName + '\'' +
                ", 班级名字='" + ClassName + '\'' +
                '}';
    }

    public String getStuName() {
        return StuName;
    }

    public void setStuName(String stuName) {
        StuName = stuName;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

}
