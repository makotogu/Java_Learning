package makotogu.pattern.factory.before;

public class CoffeeStore {
    public Coffee orderCoffee(String type) {
        //声明一个变量Coffee类型的变量，根据不同类型创建不同的Coffee子类对象
        Coffee coffee = null;
        if ("american".equals(type)){
            coffee = new AmericanCoffee();
        } else if ("latte".equals(type)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("对不起，你所点的咖啡做不了");
        }
        //加糖
        coffee.addsugar();
        //加奶
        coffee.addMilk();

        return coffee;
    }
}
