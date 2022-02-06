import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Fruit {
    String name;
    String colour;

    public Fruit(String name, String colour) {
        this.name = name;
        this.colour = colour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return name.equals(fruit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

public class HashMapDemo {


    public static void main(String args[]) {
        Map<Fruit, String> map = new HashMap<>();

        Fruit f1 = new Fruit("apple", "red");
        Fruit f2 = new Fruit("apple", "red");
        Fruit f3 = new Fruit("orange", "orange");

        map.put(f1, "fruit 1");
        map.put(f2, "fruit 2");
        map.put(f3, "fruit 3");

        /*
        normal o/p:
        apple : fruit 2
        orange : fruit 3
         */
        for (Map.Entry<Fruit, String> entry : map.entrySet()) {
            System.out.println(entry.getKey().getName() + " : "+ entry.getValue());
        }

        /*
        o/p when hashcode not overridden:
        orange : fruit 3
        apple : fruit 2
        apple : fruit 1
         */

        /*
        o/p when equals not overridden:
        apple : fruit 1
        apple : fruit 2
        orange : fruit 3
         */


    }

}
