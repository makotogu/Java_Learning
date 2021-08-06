package makotogu.pattern.factory.abstractFactory;

public interface DessertFactory {
    //生产咖啡
    Coffee createCoffee();
    //生产甜品
    Dessert createDessert();
}
