package makotogu.pattern.prototype.deepClone.after;

import java.io.Serializable;

public class Citation implements Cloneable, Serializable {
    private Student stu;

    public Student getStu() {
        return stu;
    }

    public void setStu(Student stu) {
        this.stu = stu;
    }

    @Override
    public Citation clone() throws CloneNotSupportedException {
        return (Citation) super.clone();
    }

    public void show(){
        System.out.println(stu.getName() + " 同学：在2020学年第一学期中表现优秀，被评为三好学生，特发此状！");
    }
}
