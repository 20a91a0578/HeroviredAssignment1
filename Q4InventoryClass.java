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
    System.out.print("\nProduct Name:"+this.name+"\nCost:"+this.cost+"\n");
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

public class InventoryClass {
  static Scanner input = new Scanner(System.in);
  static Inventory inventory = new Inventory();

  static void viewProductList() {
    int i=1;
    System.out.println("\n\nProduct List:");
    ArrayList<Product> products = inventory.getProducts();
    for (Product product : products) {
      System.out.print("Product : "+i);
      product.getDetails();
      i+=1;
    }
    System.out.println("\n\n");
  }
  static void viewProductCount() {
    System.out.print("Enter product name: ");
    String j=input.next();
    int c=0;
    ArrayList<Product> products = inventory.getProducts();
    for (Product product : products) 
        if (j.equals(product.name)) {
          System.out.println("\n\n\n The Quantity of "+product.name+" : "+product.getCount()+"\n\n\n");
          c=1;
          break;
          }
          if(c==0)
          System.out.println("\nProduct not present in the Inventory\n\n");
}
static void viewProductDetails(){
    System.out.print("Enter product name: ");
    String j=input.next();
    int c=0;
    ArrayList<Product> products = inventory.getProducts();
    for (Product product : products) 
        if (j.equals(product.name)) {
          System.out.println("Product Detailsare:");
            product.getDetails();
            c=1;
            break;
        }
        if(c==0)
          System.out.println("\nProduct not present in the Inventory\n\n");
}
static void editProduct(){
    System.out.print("\n\nEnter product name you want ot change details: ");
    String j=input.next();
    int c=0;
    ArrayList<Product> products = inventory.getProducts();
    for (Product product : products) 
        if (j.equals(product.name)) {
          String specification=product.specification;
    double cost=product.cost;
    int count=product.count;
            System.out.println("\nselect to change 1.Specification\n2.Cost\n3.Count");
            int op=input.nextInt();
            if(op==1)
            {
              System.out.println("Enter new Specification:\n");
              specification=input.next();
            }
            else if(op==2)
            {
              System.out.println("Enter New Cost:");
              cost=input.nextDouble();
            }
            else if(op==3)
            {
              System.out.println("Enter New  Cost:");
              count=input.nextInt();
            } 
            product.setDetails(specification, cost, count);
            System.out.println("Product details are changed successfully\n\n");
            c=1;
            break;
}
if(c==0)
          System.out.println("\nProduct not present in the Inventory\n\n");
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
                System.out.println("Product is Removed from Inventory\n");
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
      System.out.println("Inventory Management System\n1. ProductList\n2. Product Count\n3. View Product Details\n4. Edit Product\n5. Update Inventory");
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
