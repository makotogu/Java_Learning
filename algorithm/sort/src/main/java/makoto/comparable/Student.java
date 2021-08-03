package makoto.comparable;


// 定义一个学生类Student 具有Age和username属性，通过comparable接口提交比较规则
public class Student implements Comparable<Student>{
    private String username;
    private int age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }

    public int compareTo(Student o) {

        return this.getAge()-o.getAge();
    }
}
