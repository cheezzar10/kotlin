package learn.atomic.objects;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class ObjectsDemo {
    public static void main(String[] args) {
        out.println("started");

        // using kotlin compiled classes
        Car car = new Car("Opel Astra", 0);
        out.printf("car: %s%n", car);

        out.printf("car name: %s%n", car.getName());

        out.println("completed");

        List<Integer> numbers = Arrays.asList(1, 2, 4);
        List<String> result = numbers.stream()
                .map(number -> String.format("[%s]", number))
                .collect(Collectors.toList());
    }
}
