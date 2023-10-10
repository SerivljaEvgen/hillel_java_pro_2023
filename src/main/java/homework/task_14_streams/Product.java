package homework.task_14_streams;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Product {
    private final String type;
    private final double price;
    private final boolean isDiscount;
    LocalDateTime date;

    public Product(String type, double price, boolean isDiscount) {
        this.type = type;
        this.price = price;
        this.isDiscount = isDiscount;
        date = LocalDateTime.now();
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isDiscount() {
        return isDiscount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return
                "type='" + type + '\'' +
                        ", price=" + price;
    }


    // 1 метод отримання всіх продуктів у вигляді списку, категорія яких еквівалентна “Book” та ціна більш ніж 250.
    public static List<Product> typeFilter(List<Product> products, String requiredType) {
        return products.stream().filter(product -> product.getType().equals(requiredType))
                .filter(product -> product.getPrice() > 250).collect(Collectors.toList());

    }

    // 2 метод отримання всіх продуктів як списку, категорія яких еквівалентна “Book” і з можливістю застосування знижки.
    // Фінальний список повинен містити продукти з застосованою знижкою 10%.
    public static List<Product> typeFilterWithDiscount(List<Product> products, String requiredType) {
        return products.stream().filter(product -> product.getType().equals(requiredType))
                .filter(Product::isDiscount)
                .map(product -> new Product(product.getType(), product.getPrice() * 0.9, product.isDiscount()))
                .collect(Collectors.toList());
    }


    //3 метод отримання найдешевшого продукту з категорії “Book”
    public static Product cheapestProductInCategory(List<Product> products, String requiredType) {
        return products.stream().filter(product -> product.getType().equals(requiredType))
                .min(Comparator.comparing(Product::getPrice))
                .orElseThrow(() -> new NoSuchElementException
                        ("Product [category: " + requiredType + " ] not found"));
    }

    //4 метод отримання трьох останніх доданих продуктів
    public static List<Product> getThreeLastAddedProducts(List<Product> products) {
        return products.stream().sorted(Comparator.comparing(Product::getDate)
                        .reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    //5 метод калькуляції загальної вартості продуктів, які відповідають критеріям
    public static double totalPrice(List<Product> products, String requiredType) {
        return products.stream().filter(product -> product.getDate().getYear() == LocalDateTime.now().getYear())
                .filter(product -> product.getType().equals(requiredType))
                .filter(product -> product.getPrice() < 76)
                .mapToDouble(Product::getPrice).sum(); //.collect(Collectors.summingDouble(Product::getPrice));

    }

    //6 Реалізувати метод групування об'єктів за типом продукту. Таким чином результатом виконання методу
    //  буде тип даних “Словник”, що зберігає пару ключ-значення: {тип: список_продуктів}
    public static Map<String, List<Product>> getGroupingMap(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }


    public static void main(String[] args) {

        List<Product> productsList = Arrays.asList(
                new Product("Book", 300, true),
                new Product("Pen", 50, false),
                new Product("Book", 400, true),
                new Product("Pencil", 30, false),
                new Product("Book", 200, false),
                new Product("Book", 50, false),
                new Product("Book", 10, false)

        );

        // Перебор всех элементов productsList с помощью forEach() и вывод их в консоль.
        productsList.forEach(System.out::println);
        System.out.println("-----------------");

        //1 метод отримання всіх продуктів у вигляді списку, категорія яких еквівалентна “Book” та ціна більш ніж 250.
        System.out.println("Books over 250:");
        typeFilter(productsList, "Book").forEach(System.out::println);
        System.out.println("-----------------");

        //2 метод отримання всіх продуктів як списку, категорія яких еквівалентна “Book” і з можливістю застосування знижки.
        // Фінальний список повинен містити продукти з застосованою знижкою 10%.
        System.out.println("Books with 10% discounts: ");
        typeFilterWithDiscount(productsList, "Book").forEach(System.out::println);
        System.out.println("-----------------");

        //3 метод отримання найдешевшого продукту з категорії “Book”
        System.out.println("The cheapest book: ");
        System.out.println(cheapestProductInCategory(productsList, "Book"));
        System.out.println("-----------------");

        //3.1 У випадку, якщо жоден продукт не знайдено (ситуація, коли немає продукту з категорією),
        // викинути виняток з повідомленням “Продукт [категорія: ім'я_категорії] не знайдено”.

        //System.out.println(cheapestProductInCategory(productsList, "Paper"));
        //System.out.println("-----------------");

        //4 метод отримання трьох останніх доданих продуктів
        System.out.println("3 last added: ");
        getThreeLastAddedProducts(productsList).forEach(System.out::println);
        System.out.println("-----------------");

        //5 метод калькуляції загальної вартості продуктів, які відповідають наступним критеріям
        System.out.println("Total sum: " + totalPrice(productsList, "Book"));
        System.out.println("-----------------");

        //6 Реалізувати метод групування об'єктів за типом продукту. Таким чином результатом виконання методу
        //буде тип даних “Словник”, що зберігає пару ключ-значення: {тип: список_продуктів}
        System.out.println("Map grouping by type: ");
        System.out.println(getGroupingMap(productsList));

    }
    
}

