package learnrxjava.examples;

import java.util.ArrayList;

import rx.Observable;

public class ScanVsReduceExample {
    public static void main(String... args) {

        System.out.println("reduce ...");
        Observable.range(0, 10).reduce(new ArrayList<>(), (list, i) -> {
            list.add(i);
            return list;
        }).forEach(System.out::println);

        System.out.println("... vs collect ...");

        Observable.range(0, 10).collect(() -> new ArrayList<>(), (list, i) -> {
            list.add(i);
        }).forEach(System.out::println);

        System.out.println("... vs scan ...");

        Observable.range(0, 10).scan(new ArrayList<Integer>(), (list, i) -> {
            list.add(i);
            return list;
        }).forEach(System.out::println);

    }
}
