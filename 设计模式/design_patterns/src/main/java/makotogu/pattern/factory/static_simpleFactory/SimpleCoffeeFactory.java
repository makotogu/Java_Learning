package makotogu.pattern.factory.static_simpleFactory;

public class SimpleCoffeeFactory {
    public static Coffee createCoffee (String type) {
        Coffee coffee = null;
        if ("american".equals(type)) {
            coffee = new AmericanCoffee();
        } else if ("latte".equals(type)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("对不起，您所点的咖啡做不了");
        }
        return coffee;
    }
}
