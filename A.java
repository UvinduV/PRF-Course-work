import java.util.*;
class A{
	private static String storeUsername = "uvindu";
    private static String storePassword = "1234";
	private static Scanner input = new Scanner(System.in);
	private static String[][] supplier = new String[2][0];
	private static String[] category = new String[0];
	private static String[][] itemDetails = new String[6][0];
	private static int[] count= new int[0];
	
	private final static void clearConsole() {
		final String os = System.getProperty("os.name");
		try {
			if (os.equals("Linux")) {
			System.out.print("\033\143");
		} else if (os.equals("Windows")) {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} else {
			System.out.print("\033[H\033[2J");
			System.out.flush();
		}
		} catch (final Exception e) {
		//handle the exception
		System.err.println(e.getMessage());
		}
	}
	
	public static void login(){
	    System.out.printf("+----------------------------------------------------------------------+%n");
		System.out.printf("|                             LOGIN PAGE                               |%n");
		System.out.printf("+----------------------------------------------------------------------+%n");
        
        while(true){
			System.out.print("UserName :");
			String username = input.next();
			if(username.equals(storeUsername)){
				break;	 	
			}else{
				System.out.println("invalied username. try again! ");
				
			}
        }
        
        while(true){
			System.out.print("Password :");
			String password = input.next();
			if(password.equals(storePassword)){
				break;
			}else{
				System.out.println("incorrect password. try again! ");
			}	
		}
		clearConsole();
		homePage();

	}
	public static void homePage(){
		System.out.printf("+----------------------------------------------------------------------+%n");
		System.out.printf("|               WELLCOME TO IJSE STOCK MANAGEMENT SYSTEM               |%n");
		System.out.printf("+----------------------------------------------------------------------+%n");
		System.out.println("[1] Change the Credentials             [2] Supplier Manage");
		System.out.println("[3] Stock Manage                       [4] Log out\n[5] Exit the system\n");
		
		while(true){
			System.out.print("Enter an option to continue > ");
			int option = input.nextInt();
			
			switch(option){
				case 1:
					clearConsole();
					credentials();
					break;
				case 2:
					clearConsole();
					supplierManage();
					break;
				case 3:
					clearConsole();
					stockManage();  
					break;
				case 4:
					clearConsole();
					logOut();
					break;
				case 5:
					exitSystem();
					break;
				default:
					System.out.println("incorrect option!, try again .");
			}
		}
	}
	
	public static void credentials(){ 
		System.out.printf("+----------------------------------------------------------------------+%n");
		System.out.printf("|                         CREDENTIAL MANAGE                            |%n");
		System.out.printf("+----------------------------------------------------------------------+%n");
		
		 while(true){
			System.out.print("Please enter username to verify it's you :");
			String username = input.next();
			if(username.equals(storeUsername)){
				System.out.println("Hey "+username);
				break;	 	
			}else{
				System.out.println("invalied username. try again! ");
			}
        }
        
        while(true){
			System.out.print("Enter your current password :");
			String password = input.next();
			if(password.equals(storePassword)){
				System.out.print("\nEnter your new password     :");
				String newPassword = input.next();
				storePassword=newPassword;
				
				System.out.println("Password change successfully");
				
			}else{
				System.out.println("incorrect password. try again! ");
			}
			
			System.out.print("Do you want to go home page (Y/N): ");
			char ch = input.next().charAt(0);
			System.out.println("");
			
			if((ch=='y')||(ch=='Y')){
				clearConsole();
				homePage();
				break;
			}
			
		}
	} 
	
	public static void logOut(){ 
		login();
	}
	public static void exitSystem(){
		clearConsole();
	}
	public static void supplierManage(){   ////// SUPPLIER////////
		System.out.printf("+----------------------------------------------------------------------+%n");
		System.out.printf("|                          SUPPLIER MANAGE                             |%n");
		System.out.printf("+----------------------------------------------------------------------+%n");
		System.out.println("[1] Add Supplier            [2] Update Supplier ");
		System.out.println("[3] Delete Supplier         [4] View Suppliers");
		System.out.println("[5] Search Supplier         [6] Home Page");
			
		while(true){
			System.out.print("\nEnter an option to continue > ");
			int option = input.nextInt();
			
			switch(option){
				case 1:
					clearConsole();
					addSupplier();
					break;
				case 2:
					clearConsole();
					updateSupplier();
					break;
				case 3:
					clearConsole();
					deleteSuplier();
					break;
				case 4:
					clearConsole();
					viewSupplier();
					break;
				case 5:
					clearConsole();
					searchSupplier();
					break;
				case 6:
					clearConsole();
					homePage();
					break;
				default:
					System.out.println("incorrect option!, try again .");	
			}
		}	
	}
	
	public static void addSupplier(){
		System.out.printf("+----------------------------------------------------------------------+%n");
		System.out.printf("|                           ADD SUPPLIER                               |%n");
		System.out.printf("+----------------------------------------------------------------------+%n");
		
		while(true){
			System.out.print("\nSupplier Id   : ");
			String id = input.next();
			
			int index = search(id);
			if(index==-1){
				growSupplier();
				supplier=growSupplier();
				supplier[0][supplier[0].length-1]=id;
				System.out.print("Supplier Name : ");
				String name = input.next();
				
				supplier[1][supplier[1].length-1]=name;
				System.out.println("added successfully! ");
			}else{
				System.out.println("supplier already exists. try another supplier id! ");
				}
			
			System.out.print("Do you want to add another supplier (Y/N): ");
			char ch = input.next().charAt(0);
			System.out.println("");
			
			if((ch=='n')||(ch=='N')){
				clearConsole();
				supplierManage();
				break;
			}
		}
	}
	public static int search(String id ){
		for(int i=0; i< supplier[0].length;i++){
			if(supplier[0][i].equals(id)){
				return i;
			}
		}
	    return -1;
	}
	public static String[][] growSupplier(){
		String temp[][]=new String[2][supplier[0].length+1];
		for(int i=0,j=0; i< supplier[0].length;i++,j++){
			temp[j][i]=supplier[j][i];
		
		}
		return temp;
	}
	
	public static void updateSupplier(){
		System.out.printf("+----------------------------------------------------------------------+%n");
		System.out.printf("|                           UPDATE SUPPLIER                            |%n");
		System.out.printf("+----------------------------------------------------------------------+%n");
		
		while(true){
			System.out.print("\nSupplier Id	 : ");
			String id= input.next();
			
			int index= search(id);
			if(index!=-1){
				System.out.println("Supplier Name: "+supplier[1][index]);
				System.out.print("Enter the new supplier name: ");
				String newName= input.next();
				supplier[1][index]=newName;
				System.out.print("Updated successfully! ");
			}else{
				System.out.println("can't find supplier id. try again! ");
			}
			System.out.print("Do you want to update another supplier (Y/N): ");
			char ch = input.next().charAt(0);
			System.out.println("");
			
			if((ch=='n')||(ch=='N')){
				clearConsole();
				supplierManage();
				break;
			}
		}
	}
		
	public static void deleteSuplier(){
		System.out.printf("+----------------------------------------------------------------------+%n");
		System.out.printf("|                           DELETE SUPPLIER                            |%n");
		System.out.printf("+----------------------------------------------------------------------+%n");
		
		while(true){
			System.out.print("\nSupplier Id: ");
			String id= input.next();
			
			int index= search(id);
			if(index!=-1){
				removeSupplier(index);
				supplier=removeSupplier(index);
				System.out.print("deleted successfully! ");
			}else{
				System.out.println("can't find supplier id. try again! ");
				}
			System.out.print("Do you want to Delete another supplier (Y/N): ");
			char ch = input.next().charAt(0);
			System.out.println("");
			
			if((ch=='n')||(ch=='N')){
				clearConsole();
				supplierManage();
				break;
			}	
		}
	}
	public static String[][] removeSupplier(int index){
		String[][]temp= new String[2][supplier[0].length-1];
		
		for(int i=0,j=0;i<supplier[0].length;i++){
			if(i==index){
				continue;
			}
			temp[0][j]=supplier[0][i];
			temp[1][j]=supplier[1][i];	
			j++;
		}
		return temp;
	}
	
	public static void viewSupplier(){
		System.out.printf("+----------------------------------------------------------------------+%n");
		System.out.printf("|                           VIEW SUPPLIER                              |%n");
		System.out.printf("+----------------------------------------------------------------------+%n");
		
		System.out.println("");
		while(true){
			System.out.printf("+------------+-----------------+%n");
			System.out.printf("|%-12s|%-17s|%n"," SUPPLIER ID"," SUPPLIER NAME");
			System.out.printf("+------------+-----------------+%n");
			
			for(int i=0;i<supplier[0].length;i++){
				System.out.printf("|%-12s|%-17s|%n",supplier[0][i],supplier[1][i]);
			}
			System.out.printf("+------------+-----------------+%n");	
		
			System.out.print("Do you want to go supplier manage page (Y/N): ");
			char ch = input.next().charAt(0);
			System.out.println("");
			
			if((ch=='y')||(ch=='Y')){
				clearConsole();
				supplierManage();
				break;
			}
		}

	}
	
	public static void searchSupplier(){
		System.out.printf("+----------------------------------------------------------------------+%n");
		System.out.printf("|                          SEARCH SUPPLIER                             |%n");
		System.out.printf("+----------------------------------------------------------------------+%n");
		
		while(true){
			System.out.print("\nSupplier Id 	:");
			String id= input.next();
			
			int index= search(id);
			if(index!=-1){
			System.out.println("Supplier Name	:"+supplier[1][index]);
				System.out.print("added successfully! ");
			}else{
				System.out.println("can't find supplier id. try again! ");
			}
			System.out.print("Do you want to add another find (Y/N): ");
			char ch = input.next().charAt(0);
			System.out.println("");
			
			if((ch=='n')||(ch=='N')){
				clearConsole();
				supplierManage();
				break;
			}
		}
	}
	
	public static void stockManage(){   /////stock manage/////
		System.out.printf("+----------------------------------------------------------------------+%n");
		System.out.printf("|                          STOCK MANAGEMENT                            |%n");
		System.out.printf("+----------------------------------------------------------------------+%n");
		System.out.println("[1] Manage Item Categories           [2] Add Item ");
		System.out.println("[3] Get Items Supplier Wise          [4] View Items");
		System.out.println("[5] Rank Items Per unit Price        [6] Home Page");
			
		while(true){
			System.out.print("\nEnter an option to continue > ");
			int option = input.nextInt();
			
			switch(option){
				case 1:
					clearConsole();
					manageItemCategory();
					break;
				case 2:
					clearConsole();
					addItem();
					break;
				case 3:
					clearConsole();
					getItemSupplierWise();
					break;
				case 4:
					clearConsole();
					viewItems();
					break;
				case 5:
					clearConsole();
					rankUnitPrice();
					break;
				case 6:
					clearConsole();
					homePage();
					break;
				default:
					System.out.println("incorrect option!, try again .");	
			}
		}		
	}
	
	public static void manageItemCategory(){
		System.out.printf("+----------------------------------------------------------------------+%n");
		System.out.printf("|                        MANAGE ITEM CATEGORY                          |%n");
		System.out.printf("+----------------------------------------------------------------------+%n");
		System.out.println("[1] Add New Item Category           [2] Delete Item Category ");
		System.out.println("[3] Update Item Category            [4] Stock Managemnet");
	
		while(true){
			System.out.print("\nEnter an option to continue > ");
			int option = input.nextInt();
			
			switch(option){
				case 1:
					clearConsole();
					addItemCategory();
					break;
				case 2:
					clearConsole();
					deleteItemCategory();
					break;
				case 3:
					clearConsole();
					updateItemCategory();
					break;
				case 4:
					clearConsole();
					stockManage();
					break;
				default:
					System.out.println("incorrect option!, try again .");	
			}
		}		
	}
	
	public static void addItemCategory(){
		System.out.printf("+----------------------------------------------------------------------+%n");
		System.out.printf("|                        ADD ITEM CATEGORY                             |%n");
		System.out.printf("+----------------------------------------------------------------------+%n");
		
		while(true){
			System.out.print("\nEnter the item category : ");
			String categoryName = input.next();
			
			int index = searchCategory(categoryName);
			if(index==-1){
				growItemCategory();
				category = growItemCategory();
				category[category.length-1]=categoryName;
				System.out.print("added successfully! ");
			}else{
				System.out.println("category already added. try another category! ");
			}
			
			System.out.print("Do you want to add another category (Y/N): ");
			char ch = input.next().charAt(0);
			System.out.println("");
				
			if((ch=='n')||(ch=='N')){
				clearConsole();
				manageItemCategory();
				break;
			}
		}
	}
	
	public static int searchCategory(String categoryName){
		for(int i=0; i< category.length;i++){
			if(category[i].equals(categoryName)){
				return i;
			}
		}
	    return -1;
	}
	
	public static String[] growItemCategory(){
		String temp[]=new String[category.length+1];
		for(int i=0; i< category.length;i++){
			temp[i]=category[i];
		
		}
		return temp;
	}
	
	public static void deleteItemCategory(){
		System.out.printf("+----------------------------------------------------------------------+%n");
		System.out.printf("|                        DELETE ITEM CATEGORY                          |%n");
		System.out.printf("+----------------------------------------------------------------------+%n");
		
		while(true){
			System.out.print("\nEnter the item category: ");
			String categoryName= input.next();
			
			int index= searchCategory(categoryName);
			if(index!=-1){
				removeCategory(index);
				category = removeCategory(index);
				System.out.print("deleted successfully! ");
			}else{
				System.out.println("can't find category. try again! ");
				}
			System.out.print("Do you want to Delete another category (Y/N): ");
			char ch = input.next().charAt(0);
			System.out.println("");
			
			if((ch=='n')||(ch=='N')){
				clearConsole();
				manageItemCategory();
				break;
			}	
		}
	}
	
	public static String[] removeCategory(int index){
		String[] temp= new String[category.length-1];
		
		for(int i=0,j=0;i<category.length;i++){
			if(i==index){
				continue;
			}
			temp[j]=category[i];	
			j++;
		}
		return temp;
	}
	
	public static void updateItemCategory(){
		System.out.printf("+----------------------------------------------------------------------+%n");
		System.out.printf("|                        UPDATE ITEM CATEGORY                          |%n");
		System.out.printf("+----------------------------------------------------------------------+%n");
		
		while(true){
			System.out.print("\nEnter the item category: ");
			String categoryName= input.next();
			
			int index= searchCategory(categoryName);
			if(index!=-1){
				System.out.print("Enter the new Category name: ");
				String newName= input.next();
				category[index]=newName;
				System.out.print("Updated successfully! ");
			}else{
				System.out.println("can't find category name. try again! ");
			}
			
			System.out.print("Do you want to update another category (Y/N): ");
			char ch = input.next().charAt(0);
			System.out.println("");
			
			if((ch=='n')||(ch=='N')){
				clearConsole();
				manageItemCategory();
				break;
			}
		}	
	}
	
	public static void addItem(){
		System.out.printf("+----------------------------------------------------------------------+%n");
		System.out.printf("|                             ADD ITEM                                 |%n");
		System.out.printf("+----------------------------------------------------------------------+%n");
		
		if(category.length==0){
		System.out.println("\nOOPS! It seems that you don't have any item categories in the system.");
		System.out.print("Do you want to add a new item category(Y/N)? ");
		char ch=input.next().charAt(0);
			
			if(ch=='Y'||ch=='y'){
				clearConsole();
				addItemCategory();
			}else{
				clearConsole();
				stockManage();
			}
		}
		if(supplier[0].length==0){
		System.out.println("OOPS! It seems that you don't have any suppliers in the system");
		System.out.print("DO you want to add a new supplier(Y/N)? ");
		char ch=input.next().charAt(0);
			
			if(ch=='Y'||ch=='y'){
				clearConsole();
				addSupplier();
			}else{
				clearConsole();
				stockManage(); 
			}
		}
			
		while(true){
			System.out.print("\nItem Code : ");
			String code = input.next();
			
			int index = searchItemCode(code);
			if(index==-1){
				growItemDetails();
				itemDetails = growItemDetails();
				itemDetails[0][itemDetails[0].length-1]=code;
				
				//----------------------------------------
				System.out.println("\nSupplier list : \n");
				System.out.printf("+-----+-------------------------+-------------------------+%n");
				System.out.printf("|%5s|%25s|%25s|%n","  #  ","     SUPPLIER ID       ","      SUPPLIER NAME     ");
				System.out.printf("+-----+-------------------------+-------------------------+%n");
				for (int i=0; i <supplier[0].length; i++){
					System.out.printf("|%-5s|%-25s|%-25s|%n",(i+1),supplier[0][i],supplier[1][i]);
				}
				System.out.printf("+-----+-------------------------+-------------------------+%n");
				
				System.out.print("Enter the supplier number > ");
				int supplierNum= input.nextInt();
				itemDetails[1][itemDetails[1].length-1]= supplier[0][supplierNum-1];
				
				//----------------------------------------
				System.out.println("\nItem Categories : \n");
				System.out.printf("+-----+-------------------------+%n");
				System.out.printf("|%5s|%25s|%n","  #  ","    CATEGORY NAME      ");
				System.out.printf("+-----+-------------------------+%n");
				for (int i=0; i <category.length; i++){
					System.out.printf("|%5s|%25s|%n",(i+1),category[i]);
				}
				System.out.printf("+-----+-------------------------+%n");
				
				System.out.print("Enter the category number > ");
				int categoryNum= input.nextInt();
				itemDetails[2][itemDetails[2].length-1]= category[categoryNum-1];
				
				//---------------------------------------
				System.out.print("\nDescription  : ");
				String desc = input.next();
				itemDetails[3][itemDetails[3].length-1]= desc;
				
				System.out.print("\nUnit Price   : ");
				String price = input.next();
				itemDetails[4][itemDetails[4].length-1]= price;
				
				System.out.print("\nQty on hand : ");
				String qty =input.next();
				itemDetails[5][itemDetails[5].length-1]= qty;
				
				System.out.print("\nadded successfully! ");
			}else{
				System.out.println("Item code already added. try another Item code! ");
			}
			System.out.print("Do you want to add another Item (Y/N): ");
			char ch = input.next().charAt(0);
			System.out.println("");
			
			if((ch=='n')||(ch=='N')){
				clearConsole();
				stockManage();
				break;
			}
		}	
			
	}
	
	public static int searchItemCode(String code){
		for(int i=0; i< itemDetails[0].length;i++){
			if(itemDetails[0][i].equals(code)){
				return i;
			}
		}
	    return -1;
	}
	
	public static String[][] growItemDetails(){
		String temp[][]=new String[6][itemDetails[0].length+1];
		
		for(int i=0,j=0; i< itemDetails[0].length;i++,j++){
			temp[j][i]=itemDetails[j][i];
		
		}
		return temp;
	}
	
	public static void getItemSupplierWise(){
		System.out.printf("+----------------------------------------------------------------------+%n");
		System.out.printf("|                       GET ITEM SUPPLIER WISE                         |%n");
		System.out.printf("+----------------------------------------------------------------------+%n");
		
		while(true){
			System.out.print("Enter supplier Id: ");
			String id= input.next();
			
			for (int i = 0; i <itemDetails[1].length; i++){
				if(id.equals(itemDetails[1][i])){
					growCount();
					count=growCount();
					count[count.length-1]=i;
				}
			}
			
			System.out.println("");
			System.out.printf("+-------------------+----------------------+--------------------+-------------------------+--------------------+%n");
			System.out.printf("|%20s|%22s|%20s|%20s|%20s|%n","     item code     ","     catergory    ","    description    ","      unit price    ","    qty on hand    ");
			System.out.printf("+-------------------+----------------------+--------------------+-------------------------+--------------------+%n");
			
			for (int i = 0; i <count.length; i++){
				System.out.printf("|%-20s|%-22s|%-20s|%-20s|%-20s|%n",itemDetails[0][count[i]],itemDetails[2][count[i]],itemDetails[3][count[i]],itemDetails[4][count[i]],itemDetails[5][count[i]]);
				
			}
			System.out.printf("+-------------------+----------------------+--------------------+-------------------------+--------------------+%n");
			
			System.out.print("\nItems search sucessfully! Do you want to another supplier items (Y/N)?");
			char ch=input.next().charAt(0);
			if((ch=='n')||(ch=='N')){
				clearConsole();
				stockManage();
				break;
			}
		}	
		
	}
	
	public static int[] growCount(){
		int temp[]=new int[count.length+1];
		
		for(int i=0; i< count.length;i++){
			temp[i]=count[i];
		}
		return temp;	
	}
	
	public static void viewItems(){
		System.out.printf("+----------------------------------------------------------------------+%n");
		System.out.printf("|                            VIEW ITEMS                                |%n");
		System.out.printf("+----------------------------------------------------------------------+%n");
		System.out.println("");
		System.out.println("");
		while(true){
			System.out.printf("+-------------------+----------------------+--------------------+--------------------+-------------------------+--------------------+%n");
			System.out.printf("|%20s|%22s|%20s|%20s|%20s|%20s|%n","     item code     ","     supplier    ","     catergory    ","    description    ","      unit price      ","    qty on hand    ");
			System.out.printf("+-------------------+----------------------+--------------------+--------------------+-------------------------+--------------------+%n");
			
			for(int i=0;i<itemDetails[0].length;i++){
				System.out.printf("|%-20s|%-22s|%-20s|%-20s|%-20s|%-20s|%n",itemDetails[0][i],itemDetails[1][i],itemDetails[2][i],itemDetails[3][i],itemDetails[4][i],itemDetails[5][i]);
				
			}
			System.out.printf("+-------------------+----------------------+--------------------+--------------------+-------------------------+--------------------+%n");	
		
			System.out.print("Do you want to go stock manage page (Y/N): ");
			char ch = input.next().charAt(0);
			System.out.println("");
			
			if((ch=='y')||(ch=='Y')){
				clearConsole();
				stockManage();
			}
		}
	}
	public static void rankUnitPrice(){
		System.out.printf("+----------------------------------------------------------------------+%n");
		System.out.printf("|                        RANK UNIT PRICE                               |%n");
		System.out.printf("+----------------------------------------------------------------------+%n");
		System.out.println("");
	}	
	
    public static void main(String[] args){
        
        login();
	}
}

	








	





					
	
	








