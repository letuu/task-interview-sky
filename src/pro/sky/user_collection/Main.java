package pro.sky.user_collection;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        User ivan = new User("Ivan", 32);
        User alex = new User("Alex", 25);
        User anton = new User("Anton", 22);
        User tamara = new User("Tamara", 30);
        User tamara2 = new User("Tamara", 29);
        User elena = new User("Elena", 27);
        User elenaDouble = new User("Elena", 27);

        List<User> users = List.of(ivan, alex, anton, tamara, tamara2, elena, elenaDouble, anton);
        System.out.println(users);
        System.out.println();


        //Удаление дубликатов **************************************************************

        List<User> usersNoDouble = users.stream().distinct().collect(Collectors.toList());
        System.out.println(usersNoDouble);

        List<User> usersNoDouble2 = new ArrayList<>(new HashSet<>(users));
        System.out.println(usersNoDouble2);

        //сохраняем порядок элементов
        List<User> usersNoDouble3 = new ArrayList<>(new LinkedHashSet<>(users));
        System.out.println(usersNoDouble3);
        System.out.println();


        //Сортировка сначала по имени, потом по возрасту ************************************

        List<User> userSort = users.stream()
                .sorted(Comparator.comparing(User::getName).thenComparing(User::getAge))
                .collect(Collectors.toList());
        userSort.forEach(System.out::println);
        System.out.println();

        List<User> userSort2 = new ArrayList<>(users);
        userSort2.sort(Comparator.comparing(User::getName).thenComparing(User::getAge));
        System.out.println(userSort2);
        System.out.println();


        //Вернуть самого старого пользователя ***********************************************

        User userMaxAge = users.stream().max(Comparator.comparing(User::getAge)).get();
        System.out.println(userMaxAge);

        User userMaxAge2 = Collections.max(users);
        System.out.println(userMaxAge2);
    }
}
