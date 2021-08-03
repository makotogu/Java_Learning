### Java 中Comparator 与 Comparable 有什么不同? 
* Comparable 接口用于定义对象的自然顺序，而 comparator 通常用于定义用户定制的顺序。Comparable 总是只有一个，但是可以有多个 comparator 来定义对象的顺序。

### 存在两个类，B 继承 A，C 继承 B，我们能将 B 转换为 C 么? 
* 如 C = (C) B； 可以，向下转型。但是不建议使用，容易出现类型转型异常。

