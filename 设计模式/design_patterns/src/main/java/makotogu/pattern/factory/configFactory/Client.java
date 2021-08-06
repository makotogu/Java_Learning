package makotogu.pattern.factory.configFactory;

public class Client {
    public static void main(String[] args) {
        Coffee coffee = CoffeeFactory.createCoffee("american");
        System.out.println(coffee.getName());

        System.out.println("=============");
        System.out.println(CoffeeFactory.createCoffee("latte").getName());
    }
}
