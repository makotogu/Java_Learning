package makotogu.pattern.factory.factoryMethod;

public class CoffeeStore {

    private CoffeeFactory factory;

    public void setFactory(CoffeeFactory factory){
        this.factory = factory;
    }

    public Coffee orderCoffee() {
        Coffee coffee = factory.createCoffee();
        coffee.addMilk();
        coffee.addsugar();
        return coffee;
    }
}
