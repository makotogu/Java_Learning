package makotogu.pattern.builder.demo1;

//构建ofo单车对象
public class OfoBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("ofo车架");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("ofo车座");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
