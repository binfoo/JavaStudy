package lamada;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class OptionalExample {
    public static void main(String[] args) {
//        String str = null;
//        Optional<String> optionStr = Optional.ofNullable(str);
//        String str2 = "Hello";
//        Optional<String> optionalS = Optional.of(str2);
//        System.out.println(optionalS.get());

//        String str = null;
//        Optional<String> optionalStr = Optional.ofNullable(str);
//        Supplier<String> supplier = () -> "Generated Value";
//        String value = optionalStr.orElseGet(supplier);
//        System.out.println(value);

        String str = "Hello";
        Optional<String> optionalStr = Optional.of(str);
        Consumer<String> consumer = (value) -> System.out.println("Value is: " + value);
        optionalStr.ifPresent(consumer);

        String str3 = "Hello";
        Optional<String> optionalStr3 = Optional.of(str);
        Function<String, Integer> function = (value) -> value.length();
        Optional<Integer> optionalLength = optionalStr.map(function);
        optionalLength.ifPresent(System.out::println);

        Optional<String> optionalStr5 = Optional.of("Hello");
        Function<String, Optional<Integer>> function5 = (value) -> Optional.of(value.length());
        Optional<Integer> optionalLength5 = optionalStr.flatMap(function5);
        optionalLength5.ifPresent(System.out::println);
    }

}
