import java.beans.Customizer;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        int a = 5;
        Predicate<Integer> isPositive = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if (integer < 0) {
                    return false;
                } else {
                    return true;
                }
            }
        };
        Predicate<Integer> isPositive2 = x -> x > 0;
        System.out.println("Integer a=" + a + " is Positive: " + isPositive.test(a));
        System.out.println("Integer a=" + a + " is Positive: " + isPositive2.test(a));

        Consumer<String> name = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Приветствую Вас " + s);
            }
        };
        name.accept("Sergey");

        Consumer<String> name2 = x -> System.out.println("Приветствую Вас " + x);
        name2.accept("Vasya");


        Function<Double, Long> count = new Function<Double, Long>() {

            @Override
            public Long apply(Double aDouble) {
                return aDouble.longValue();
            }
        };
        System.out.println(count.apply(1.923));

        Function<Double, Long> count2 = x -> {return  x.longValue();};
        System.out.println(count2.apply(21.312));

        Supplier <Integer> random = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return (new Random()).nextInt(100);
            }
        };
        System.out.println(random.get());

        Supplier <Integer> random2 = () -> {
            return new Random().nextInt(100);
        };
        System.out.println(random2.get());


        Function <Double, Integer> ter = x -> {
            Predicate<? super Double> condition = y -> y > 0;
            Function<? super Double, ? extends Integer> ifTrue = x2 -> {return x2.intValue();};
            Function<? super Double, ? extends Integer> ifFalse = x2->{return 0;};
            return (condition.test(x))? ifTrue.apply(x): ifFalse.apply(x);
        };
        System.out.println(ter.apply(12.4323d));
    }
}