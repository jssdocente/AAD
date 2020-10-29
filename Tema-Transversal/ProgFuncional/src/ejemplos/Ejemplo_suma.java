package ejemplos;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Ejemplo_suma {
    public static void main(String[] args) {

    }

    /* Stream.reduce() is a terminal operation that performs a reduction on the elements of the stream.
    It applies a binary operator (accumulator) to each element in the stream, where the first operand is the return value of the previous application, and the second one is the current stream element.
    In the first method of using the reduce() method,
    the accumulator function is a lambda expression that adds two Integer values and returns an Integer value:
     */
    public static void sumarNumerosConReduce(Integer[] numbers) {
        List<Integer> integers = Arrays.asList(numbers);
        Integer suma1 = integers.stream()
                .reduce(0, (a, b) -> a + b);

        //Tambien utilizando el método Sum
        Integer suma2 = integers.stream()
                .mapToInt(value -> Integer.valueOf(value))
                .sum();

        //Tambien podemos crear un método, y utilizarlo
        Integer suma3 = integers.stream()
                .reduce(0,(a,b) -> add(a,b));

        //Asi se haría sin programacion funcional
        Integer suma4=0;
        for (int i = 0; i < numbers.length - 1; i++) {
            suma4+=numbers[i];
        }

    }

    public static int add(int a, int b) {
        return a + b;
    }




}
