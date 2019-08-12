# mini JUnit

Представьте, что у нас нет библиотеки JUnit и напишите собственную библиотеку miniJUnit, которая бы состояла из аннотации @Test и запускала бы все public void методы классов c пустыми аргументами, аннотированные этой аннотацией

#### Описание
Запускает бы все public void методы классов c пустыми аргументами, 
аннотированные аннотацией @Test. Результаты выводятся на экрани в файл
с помощью библиотеки log4j.

#### Применение
тестовый класс:
```java
import com.andrsam.minijunit.library.MiniJUnit;

public class TestClass {

    @Test
    public void test1() {
        System.out.println("Hello from test - 1!");
    }
}
```
запуск тестов:

```java
import com.andrsam.minijunit.runner.TestRunner;
import com.andrsam.minijunit.testclasses.TestClass;
import com.andrsam.minijunit.testclasses.TestNoSuitableMethodsClass;

public class MiniJUnitDemo {
    public static void main(String[] args) {
        TestRunner.runTests(new TestNoSuitableMethodsClass());
        TestRunner.runTests(new TestClass());
        TestRunner.runTests(new TestCalc());
    }
}
```

#### Запуск демонстрационного класса
```
mvn exec:java -Dexec.mainClass=com.andrsam.MiniJUnitDemo
```