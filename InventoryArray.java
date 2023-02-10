import java.util.*;
public class InventoryArray {
	static Scanner AK = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("ENTER NO OF PRODUCTS YOU WANT TO MANAGE ");
		int size = AK.nextInt();
		Map<String,List<String>> inventory = new HashMap<>();
		System.out.println("ENTER DETAILS : \n");
		for(int i = 0 ; i < size  ; i++ ) {
			System.out.println("Enter PRODUCT DETAILS LIKE NAME,SPECIFICATION,COST ,QUANTITY : \n");
			List<String> ll = new ArrayList<String>() ;
			String ProductName =AK.next();
			String Productspecs = AK.next();
			String cost = AK.next();
			String Quantity = AK.next();
			ll.add(Productspecs);
			ll.add(cost);
			ll.add(Quantity);
			inventory.put(ProductName, ll);
		}
        int option;
		do {
			System.out.println("	\n\n1.Product List  ");
			System.out.println("	2.Product Quantity ");
			System.out.println("	3.Product details ");
			System.out.println("	4.Edit product details ");
			System.out.println("	5.Update Inventory ");
			System.out.println("	Enter your option \n");
			 option = AK.nextInt();
			switch(option) {
                case 1:
					getInventoryDetails(inventory);
                    break;
			case 2:
				getproductQuantity(inventory);
                break;
			case 3:
				getproductdetails(inventory);
                break;
			case 4:
				ModifyProduct(inventory);
                break;
			case 5:
				InventoryUpdate(inventory);
                break;
			default:
			System.out.println("WRONG OPTION PLEASE TRY AGAIN LATER ");
			}
			
		}while(option<=5 && option>0);
	}
	public static void getInventoryDetails(Map<String,List<String>> invent) {
		int i = 1;
		for(String st :invent.keySet()) {
			System.out.println(i + " "+st);
			i++;
		}
	}
	public static void InventoryUpdate(Map<String,List<String>> invent) {
		System.out.println("-----------------------");
		System.out.println("   1. Add poduct");
		System.out.println("   2. Delete product");
		System.out.println("Enter your option");System.out.println();
		AK.nextLine();
		int n = AK.nextInt();
		if(n == 1) {
			System.out.println("\nEnter productName,Specification,cost,Quantity : ");
			AK.nextLine();
			String t = AK.nextLine();
			String []arr = t.split(" ");
			String name = arr[0];
			String spec = arr[1];
			String cost = arr[2];
			String Quantity = arr[3];
			List<String> list = new ArrayList<String>();
			list.add(spec);
			list.add(cost);
			list.add(Quantity);
			invent.put(name, list);
		}else {
			System.out.println("\nEnter product name to delete product : ");
			String ProductName = AK.nextLine();
			if(invent.containsKey(ProductName)) {
				invent.remove(ProductName);
				System.out.println("\nProduct removed Successfully");
			}else {
				System.out.println("Product Not Found");
			}
		}
	}
	public static void ModifyProduct(Map<String,List<String>> invent) {
		System.out.println("\nEnter product name : ");
		AK.nextLine();
		String ProductName = AK.nextLine();
		if(invent.containsKey(ProductName)) {
			System.out.println("\nwhat do you want to edit :\n1.Specification\n2.Cost\n3.Product Quantity");
			int ch = AK.nextInt();
			if(ch == 1) {
				System.out.println("Enter product specification ");
				String st = AK.nextLine();
				List<String> list = invent.get(ProductName);
				list.remove(0);
				list.add(0, st);
				invent.put(ProductName, list);
			}else if(ch == 2) {
				System.out.println("Enter product cost ");
				String cost = AK.next();
				List<String> list = invent.get(ProductName);
				list.remove(1);
				list.add(1, cost);
				invent.put(ProductName,list);
			}else {
				System.out.println("\nEnter product Quantity ");
				String Quantity = AK.next();
				List<String> list = invent.get(ProductName);
				list.remove(2);
				list.add(Quantity);
				invent.put(ProductName,list);
			}
			return;
		}else {
			System.out.println("Product not in  Inventory");
		}
	}
	public static void getproductQuantity(Map<String,List<String>> mp) {
		System.out.println("Enter product name");
		AK.nextLine();
		String ProductName = AK.nextLine();
		if(mp.containsKey(ProductName)) {
			List<String> temp = mp.get(ProductName);
			System.out.println("Quantity of "+ProductName+" is "+temp.get(2));
		}else {
			System.out.println("Product not found");
		}
	}
	public static void getproductdetails(Map<String,List<String>> mp) {
		System.out.println("Enter product name");
		AK.nextLine();
		String ProductName = AK.nextLine();
		if(mp.containsKey(ProductName)) {
			System.out.println("Product Name : "+ProductName);
			System.out.println("Product Specification : "+mp.get(ProductName).get(0));
			System.out.println("Product Cost : "+mp.get(ProductName).get(1));
			System.out.println("Product Quantity : "+mp.get(ProductName).get(2));
		}else {
			System.out.println("Product not in Inventory");
		}
	}
}