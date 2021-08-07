package makotogu.pattern.prototype.test;

public class Citation implements Cloneable{
    //三好学生姓名
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Citation clone() throws CloneNotSupportedException {
        return (Citation) super.clone();
    }

    public void show() {
        System.out.println(name + " 同学：在2020学年第一学期中表现优秀，被评为三好学生，特发此状！");
    }
}
