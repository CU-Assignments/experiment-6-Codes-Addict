import java.util.*;
import java.util.stream.Collectors;

class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', category='" + category + "', price=" + price + '}';
    }
}

public class Hard {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.0),
                new Product("Smartphone", "Electronics", 800.0),
                new Product("Tablet", "Electronics", 450.0),
                new Product("Chair", "Furniture", 100.0),
                new Product("Sofa", "Furniture", 500.0),
                new Product("Desk", "Furniture", 200.0),
                new Product("Blender", "Appliances", 150.0),
                new Product("Microwave", "Appliances", 300.0)
        );

        Map<String, List<Product>> groupedByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        Map<String, Product> mostExpensiveInCategory = groupedByCategory.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .max(Comparator.comparingDouble(Product::getPrice))
                                .orElse(null)
                ));

        double averagePrice = products.stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0.0);

        System.out.println("Most expensive product in each category:");
        mostExpensiveInCategory.forEach((category, product) ->
                System.out.println(category + ": " + product.getName() + " (" + product.getPrice() + ")"));

        System.out.println("\nAverage price of all products: " + averagePrice);
    }
}