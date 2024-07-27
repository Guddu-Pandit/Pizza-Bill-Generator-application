import java.util.Scanner;

// Base class for Pizza
abstract class Pizza {
    String name;
    double basePrice;
    boolean extraCheese;
    boolean extraToppings;
    boolean takeAway;

    public Pizza(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
        this.extraCheese = false;
        this.extraToppings = false;
        this.takeAway = false;
    }

    public void addExtraCheese() {
        this.extraCheese = true;
    }

    public void addExtraToppings() {
        this.extraToppings = true;
    }

    public void setTakeAway() {
        this.takeAway = true;
    }

    public double calculateTotalPrice() {
        double totalPrice = basePrice;
        if (extraCheese) {
            totalPrice += 100; // Extra Cheese charge
        }
        if (extraToppings) {
            totalPrice += 150; // Extra Toppings charge
        }
        if (takeAway) {
            totalPrice += 20; // Packaging charge
        }
        return totalPrice;
    }

    public void generateBill() {
        System.out.println("------- " + name + " Bill -------");
        System.out.println("Base Price: " + basePrice);
        if (extraCheese) {
            System.out.println("Extra Cheese: 100");
        }
        if (extraToppings) {
            System.out.println("Extra Toppings: 150");
        }
        if (takeAway) {
            System.out.println("Packaging Charges: 20");
        }
        System.out.println("Total: " + calculateTotalPrice());
        System.out.println("Thank you!! Visit Again...");
        System.out.println("----------------------------");
    }
}

// Veg Pizza class
class VegPizza extends Pizza {
    public VegPizza() {
        super("Veg Pizza", 300);
    }
}

// Non-Veg Pizza class
class NonVegPizza extends Pizza {
    public NonVegPizza() {
        super("Non-Veg Pizza", 400);
    }
}

// Delux Veg Pizza class
class DeluxVegPizza extends Pizza {
    public DeluxVegPizza() {
        super("Delux Veg Pizza", 550);
        addExtraCheese();
        addExtraToppings();
    }
}

// Delux Non-Veg Pizza class
class DeluxNonVegPizza extends Pizza {
    public DeluxNonVegPizza() {
        super("Delux Non-Veg Pizza", 650);
        addExtraCheese();
        addExtraToppings();
    }
}

// Main class
public class PizzaBillGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pizza pizza = null;

        System.out.println("Welcome to Pizzamania!");
        System.out.println("1. Veg Pizza");
        System.out.println("2. Non-Veg Pizza");
        System.out.println("3. Delux Veg Pizza");
        System.out.println("4. Delux Non-Veg Pizza");
        System.out.print("Select the type of pizza: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                pizza = new VegPizza();
                break;
            case 2:
                pizza = new NonVegPizza();
                break;
            case 3:
                pizza = new DeluxVegPizza();
                break;
            case 4:
                pizza = new DeluxNonVegPizza();
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        if (!(pizza instanceof DeluxVegPizza) && !(pizza instanceof DeluxNonVegPizza)) {
            System.out.print("Do you want extra cheese (yes/no)? ");
            if (scanner.next().equalsIgnoreCase("yes")) {
                pizza.addExtraCheese();
            }

            System.out.print("Do you want extra toppings (yes/no)? ");
            if (scanner.next().equalsIgnoreCase("yes")) {
                pizza.addExtraToppings();
            }
        }

        System.out.print("Do you want take away (yes/no)? ");
        if (scanner.next().equalsIgnoreCase("yes")) {
            pizza.setTakeAway();
        }

        pizza.generateBill();
           
    }
}
