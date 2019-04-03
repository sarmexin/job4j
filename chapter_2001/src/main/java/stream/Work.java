package stream;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Work {

    public static void main(String[] args) {
        Collect<Integer> collect = new Collect<>();
        System.out.println("Заполнение коллекции");
        collect.listAdd(10, 20, 30, 40);
        System.out.println("Проверка");
        for(Integer integer: collect.list) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.println("stream фильтрация >20");
        List<Integer> integerList = collect.list.stream().filter(x -> x > 20).collect(Collectors.toList());
        for(Integer integer: integerList) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.println("Преобразование каждого елемента с помощью map");
        List<Integer> list2 = collect.list.stream().map(x -> x + 2).limit(3).collect(Collectors.toList());
        for(Integer integer: list2) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.println("Создание стрима");
        Stream<Integer> stream = collect.list.stream();
        System.out.println("Вывод каждого елемента с помощью forEach");
        stream.forEach(System.out::println);
        System.out.println();
        System.out.println("Параллельный стрим");
        Stream<Integer> stream1 = collect.list.parallelStream();
        List<Integer> list3 = stream1.filter(x -> x > 10)
                .map(x -> x * 2)
                .collect(Collectors.toList());
        for(Integer integer: list3) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.println("iterate");
        Stream.iterate(2, x -> x + 6)
                .limit(6)
                .forEach(System.out::println);
        System.out.println("Обьединение стримов contact");
        Stream.concat(
                Stream.of(1, 2, 3),
                Stream.of(4, 5, 6))
                .forEach(System.out::println);
        System.out.println("range");
        IntStream.range(0, 10)
                .limit(10)
                .skip(3)
                .forEach(System.out::println);
        long num = collect.list.stream().count();
        System.out.println("num = " + num);
        System.out.println("reduce");
        int sum = Stream.of(1, 2, 3, 4, 5)
                .reduce(10, (acc, x) -> acc + x);
        System.out.println(sum);
        System.out.println("reduce без начального елемента");
        Optional<Integer> sum1 = Stream.of(1, 2, 3, 4, 5)
                .reduce((acc, x) -> acc + x);
        System.out.println(sum1.get());
        System.out.println("Optional min(Comparator comparator)");
        int min = Stream.of(20, 11, 45, 78, 13)
                .min(Integer::compare).get();
        System.out.println(min);

    }
}
