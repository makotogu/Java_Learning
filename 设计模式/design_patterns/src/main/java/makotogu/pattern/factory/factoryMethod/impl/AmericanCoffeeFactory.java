package makotogu.pattern.factory.factoryMethod.impl;

import makotogu.pattern.factory.factoryMethod.AmericanCoffee;
import makotogu.pattern.factory.factoryMethod.Coffee;
import makotogu.pattern.factory.factoryMethod.CoffeeFactory;

public class AmericanCoffeeFactory implements CoffeeFactory {
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }
}
