package cn.edu.scujcc.workoneweke;

import java.io.Serializable;

/**
 * @author Administrator
 */
public class Student implements Serializable {
    private String stuName;
    private String className;

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "学生信息{" +
                "学生名字='" + stuName + '\'' +
                ", 班级名字='" + className + '\'' +
                '}';
    }

    //    @Override
//    public String toString() {
//        return "学生信息{" +
//                "学生名字='" + StuName + '\'' +
//                ", 班级名字='" + ClassName + '\'' +
//                '}';
//    }
//
//    public String getStuName() {
//        return StuName;
//    }
//
//    public void setStuName(String stuName) {
//        StuName = stuName;
//    }
//
//    public String getClassName() {
//        return ClassName;
//    }
//
//    public void setClassName(String className) {
//        ClassName = className;
//    }

}
