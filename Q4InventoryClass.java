import java.util.*;
class Product {
 String name;
 String specification;
 double cost;
 int count;
public Product(String name, String specification, double cost, int count) {
    this.name = name;
    this.specification = specification;
    this.cost = cost;
    this.count = count;
  }
public void setDetails(String specification,double cost,int count){
    this.specification = specification;
    this.cost = cost;
    this.count = count; 
}
public void getDetails()
{
    System.out.print("\n\n THE PRODUCT DETAILS ARE ::\nProduct Name:"+this.name+"\nCost:"+this.cost+"\n");
            System.out.print("Product Count:"+this.count+"\nProduct Specification:"+this.specification+"\n\n");
}
  public int getCount() {
    return count;
  }


}

class Inventory {
 ArrayList<Product> products;

  public Inventory() {
    products = new ArrayList<>();
  }

  public void addProduct(Product product) {
    products.add(product);
  }

  public void removeProduct(Product product) {
    products.remove(product);
  }
  public ArrayList<Product> getProducts() {
    return products;
  }
}

public class Q4InventoryClass {
  static Scanner input = new Scanner(System.in);
  static Inventory inventory = new Inventory();

  static void viewProductList() {
    System.out.println("\n\nProduct List:");
    ArrayList<Product> products = inventory.getProducts();
    for (Product product : products) {
      System.out.println(product.name);
    }
    System.out.println("\n\n");
  }
  static void viewProductCount() {
    System.out.print("Enter product name: ");
    String j=input.next();
    ArrayList<Product> products = inventory.getProducts();
    for (Product product : products) 
        if (j.equals(product.name)) {
          System.out.println("\n\n\n The Quantity of "+product.name+" : "+product.getCount()+"\n\n\n");
          break;
          }
}
static void viewProductDetails(){
    System.out.print("Enter product name: ");
    String j=input.next();
    ArrayList<Product> products = inventory.getProducts();
    for (Product product : products) 
        if (j.equals(product.name)) {
            product.getDetails();
            break;
        }
}
static void editProduct(){
    System.out.print("\n\nEnter product name you want ot change details: ");
    String j=input.next();
    ArrayList<Product> products = inventory.getProducts();
    for (Product product : products) 
        if (j.equals(product.name)) {
            System.out.println("\nenter  specification,cost and count for product");
            String specification=input.next();
            double cost=input.nextDouble();
            int  count=input.nextInt();
            product.setDetails(specification, cost, count);
            System.out.println("Product details are changed successfully\n\n");
            break;
}
}
static void updateInventory(){
    System.out.print("\n\nSelect  1.To add product\n2.To delete Product ");
    int k=input.nextInt();
    if(k==1)
    {
        System.out.println("\n\nEnter Product Name , Specification,Cost and Count for product");
        String name=input.next();
        String specification=input.next();
        double cost=input.nextDouble();
        int  count=input.nextInt();
        Product p=new Product(name, specification, cost, count);
        inventory.addProduct(p);
    }
    else
    {
        System.out.print("\n\nEnter product name you want to delete ");
        String j=input.next();
        ArrayList<Product> products = inventory.getProducts();
        for (Product product : products) 
            if (j.equals(product.name)) { 
                inventory.removeProduct(product); 
                break;
    }
    }   
    
}
  public static void main(String[] args) {
    int choice;
    Product p=new Product("SAMSUNG", "5G,128GB STORAGE", 8999,15);
    inventory.addProduct(new Product("OPPO","4G,64GB STORAGE",7999, 45));
    inventory.addProduct(p);
    do {
      System.out.println("Inventory Management System");
      System.out.println("1. Product List");
      System.out.println("2. Product Count");
      System.out.println("3. View Product Details");
      System.out.println("4. Edit Product");
      System.out.println("5. Update Inventory");
      System.out.print("Enter your choice: ");
      choice = input.nextInt();
      switch (choice) {
        case 1:
          viewProductList();
          break;
        case 2:
          viewProductCount();
          break;
        case 3:
          viewProductDetails();
          break;
        case 4:
          editProduct();
          break;
        case 5:
          updateInventory();
          break;
          default:
          System.out.println("\n\nInvalid choice. Try again.\n\n");
      }
    } while (choice <= 5 && choice>0);
  }
}
