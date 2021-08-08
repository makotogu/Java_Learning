package makotogu.pattern.proxy.staticProxy;

public class ProxyPoint implements SellTickets{
    //声明火车站对象
    private TrainStation trainStation = new TrainStation();

    @Override
    public void sell() {
        System.out.println("代理点收取费用");
        trainStation.sell();
    }
}
