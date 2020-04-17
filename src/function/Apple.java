package function;

import java.util.ArrayList;
import java.util.List;

public class Apple {
    String color;
    List<Apple> inventory;

    public Apple(String color) {
        this.color = color;
        inventory = new ArrayList<>();
    }

    public String getColor() {

        return color;
    }
}
