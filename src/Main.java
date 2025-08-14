import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        /*
         * 1) Вывести список
         * Создайте список из 5 целых чисел
         */
        List<Integer> integerList = new ArrayList<>(List.of(1, 3, 5, 7, 11));
        // Выведите его элементы через пробел
        System.out.print("Элементы списка целых чисел: ");
        printListInOneLine(integerList);
        System.out.println();

        /*
         * 2) Доступ по индексу
         * Выведите третий элемент списка
         */
        System.out.println("Третий элемент списка: " + integerList.get(2));

        /*
         * 3) Удаление элемента
         * Удалите второй элемент списка и выведите оставшиеся
         */
        integerList.remove(1);
        System.out.print("Элементы списка целых чисел после удаления второго элемента: ");
        printListInOneLine(integerList);
        System.out.println();

        /*
         * 4) Сумма элементов
         * Найдите сумму всех чисел в списке
         */
        {
            long sum = 0;
            for (Integer element : integerList) {
                sum += element;
            }
            System.out.printf("Сумма всех чисел в списке: %s\n", sum);
        }

        /*
         * 5) Подсчёт количества
         * Подсчитайте, сколько раз в списке встречается число 7
         */
        {
            int count = 0;
            for (Integer element : integerList) {
                if (element == 7) {
                    count++;
                }
            }
            System.out.printf("Число 7 в списке встречается столько раз: %s\n", count);
        }

        /*
         * 6) Поиск элемента
         * Проверьте, содержится ли число 42 в списке
         */
        {
            int intToFind = 42;
            System.out.printf("Число %s в списке%s содержится\n", intToFind, (integerList.contains(intToFind) ? "" : " не"));
        }

        /*
         * 7) Минимум и максимум
         * Найдите и выведите минимальное и максимальное число в списке
         */
        {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (Integer element : integerList) {
                min = Math.min(min, element);
                max = Math.max(max, element);
            }
            System.out.printf("В списке минимальное число равно %s, максимальное число равно %s\n", min, max);
        }

        /*
         * 8) Удалить все чётные числа
         * Удалите из списка все числа, делящиеся на 2.
         */
        integerList.removeIf(element -> (element % 2) == 0);

        /*
         * 9) Создание списка из массива
         * Создайте список из массива int[] arr = {1, 2, 3, 4}.
         */
        int[] arrInt = new int[]{1, 2, 3, 4};
        List<Integer> integerList2 = Arrays.asList(Arrays.stream(arrInt).boxed().toArray(Integer[]::new));

        /*
         * 10) Количество элементов > N
         * Найдите количество элементов, больше чем число N
         */
        {
            int N = 2;
            int countGreaterN = 0;
            for (Integer element : integerList2) {
                if (element > N) {
                    countGreaterN++;
                }
            }
            System.out.printf("Количество элементов, больше чем число N=%s: %s\n", N, countGreaterN);
        }

        /*
         * 11) Создание списка строк и фильтрация
         * Создайте список строк. Выведите строки, длина которых больше 5
         */
        List<String> stringList = new ArrayList<>() {{
            add("Раз");
            add("Два");
            add("Три");
            add("Четыре");
            add("Пять");
            add("Вышел");
            add("Зайчик");
            add("Погулять");
        }};
        // Выведите строки, длина которых больше 5
        {
            System.out.println("Строки, длина которых больше 5:");
            for (String element : stringList) {
                if (element.length() > 5) {
                    System.out.println(element);
                }
            }
        }

        /*
         * 12) Инвертировать список
         * Напишите метод, который возвращает список в обратном порядке
         */
        System.out.println();
        listOutput(invertList(stringList), "invertList(alString)");

        System.out.println();
        listOutput(stringList, "alString");

        /*
         * 13) Объединение двух списков без дубликатов
         * Даны два списка. Объедините их в один, не добавляя повторы
         */
        List<Integer> intList1 = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        List<Integer> intList2 = new ArrayList<>(List.of(3, 4, 5, 6, 7));
        List<Integer> mergedList = new ArrayList<>(intList1);
        for (Integer element : intList2) {
            if (!mergedList.contains(element)) {
                mergedList.add(element);
            }
        }

        System.out.println();
        listOutput(intList1, "Первый список");

        System.out.println();
        listOutput(intList2, "Второй список");

        System.out.println();
        listOutput(mergedList, "Объединенный список");

        /*
         * 14) Сумма только нечётных чисел
         * Считайте List<Integer> и посчитайте сумму только нечётных чисел
         */
        System.out.println();
        long sum = 0;
        for (Integer element : mergedList) {
            if ((element % 2) == 1) {
                sum += element;
            }
        }
        System.out.printf("Сумма всех нечетных чисел в объединенном списке: %s\n", sum);

        /*
         * 15) Фильтр по первой букве
         * Дан список строк
         */
        List<String> stringList2 = new ArrayList<>(List.of("Апельсин", "Банан", "Арбуз", "Вишня", "Гранат", "Ананас", "Дыня", "Черника"));

        System.out.println();
        listOutput(stringList, "Дан список строк");

        // Верните новый список, содержащий только строки, начинающиеся с буквы "А"

        System.out.println();
        listOutput(filterFirstChar(stringList2, 'А'), "Список, содержащий только строки, начинающиеся с буквы \"А\"");
    }

    public static void printListInOneLine(List<?> list) {
        for (Object element : list) {
            System.out.print(element.toString() + " ");
        }
    }
    /*
     * 12) Инвертировать список
     * Напишите метод, который возвращает список в обратном порядке
     */
    public static List<?> invertList(List<?> list) {
        List<?> invertedList = new ArrayList<>(list);
        Collections.reverse(invertedList);
        return invertedList;
    }

    public static void listOutput(List<?> list, String name) {
        System.out.println(name + ":");
        for (Object element : list) {
            System.out.println(element);
        }
    }

    /*
     * 15) Фильтр по первой букве
     * Дан список строк. Верните новый список, содержащий только строки, начинающиеся с буквы "А"
     */
    public static List<String> filterFirstChar(List<String> list, char firstChar) {
        List<String> filteredList = new ArrayList<>();

        for (String element : list) {
            if (element.startsWith(Character.toString(firstChar))) {
                filteredList.add(element);
            }
        }

        return filteredList;
    }
}