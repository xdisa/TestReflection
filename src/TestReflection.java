import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class TestReflection {

    //считаем из косоли названия 2-х классов
    // и создадим объекты этих классов,
    // считаем названия метода
    // и вызовем его на объекте первого класса
    // и в арг передадим объект второго класса

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Scanner s = new Scanner(System.in);
       //передадим все одной строчной через пробел
        //название_класса1 название_класса2 название_метода
        //

        Class classObject1 = Class.forName(s.next());//создание объекта класса Класс из точного названия класса
        Class classObject2 = Class.forName(s.next());
        String methodName = s.next();

Method m = classObject1.getMethod(methodName, classObject2);
//получение метода по сигнатуре
        //сигнатура метода в рефлексии
        // это имя и набор параметров,
        // имя это methodName, параметры это classObject2
        //
        // создадим объекты объектов класса класс через .newInstanse();
        //у второго объекта создадим объект с конструктором , который принимает в объект объекта строку
        //т е на обьект обьекта 2-го класса вызываем конструктор который паринимает строковое значение
        //и на этот контруктор вызываем гетИнстас

        Object o1 = classObject1.newInstance();
        Object o2 = classObject2.getConstructor(String.class).newInstance("String value");

        m.invoke(o1,o2);
        System.out.println(o1);//если ввести Person java.lang.String setName
        //вывод будет -1 и Стринг Велью
//рефлексия гибкая и можно вызвать этот код на java.lang.Thread java.lang.String setName
        

    }
}
