package makotogu.pattern.factory.factoryMethod.impl;

import makotogu.pattern.factory.factoryMethod.Coffee;
import makotogu.pattern.factory.factoryMethod.CoffeeFactory;
import makotogu.pattern.factory.factoryMethod.LatteCoffee;

public class LatteCoffeeFactory implements CoffeeFactory {
    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }
}
