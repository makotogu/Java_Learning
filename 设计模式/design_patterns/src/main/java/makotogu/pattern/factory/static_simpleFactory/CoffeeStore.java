package makotogu.pattern.factory.static_simpleFactory;

public class CoffeeStore {
    public Coffee orderCoffee(String type) {

        Coffee coffee= SimpleCoffeeFactory.createCoffee(type);

        coffee.addMilk();
        coffee.addsugar();

        return coffee;
    }
}
