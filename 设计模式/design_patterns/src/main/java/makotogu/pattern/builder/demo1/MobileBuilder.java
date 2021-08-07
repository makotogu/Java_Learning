package makotogu.pattern.builder.demo1;

//构建摩拜单车对象
public class MobileBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("摩拜车架");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("摩拜车座");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
