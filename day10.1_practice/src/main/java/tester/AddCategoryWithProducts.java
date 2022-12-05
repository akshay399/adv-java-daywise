package tester;

import org.hibernate.SessionFactory;

import dao.CategoryDaoImpl;
import dao.ProductDaoImpl;
import pojos.Category;
import pojos.Product;

import static utils.HibernateUtils.getSessionFactory;

import java.time.LocalDate;
import java.util.Scanner;
public class AddCategoryWithProducts {
	public static void main(String[] args) {
		try(SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)){
			
			CategoryDaoImpl cDao = new CategoryDaoImpl();
			System.out.println("Enter details : categoryName");
			String nm = sc.nextLine();
			System.out.println("Enter category desc");
			Category category = new Category(nm, sc.nextLine());
			
			System.out.println("enter the number of products to add: ");
			for (int i = 0; i < 1; i++) {
				System.out.println("Enter product name");
				String name = sc.nextLine();
				System.out.println("Enter product price");
				double price = sc.nextDouble();
				sc.nextLine();
				System.out.println("Enter product desc");
				String desc = sc.nextLine();
				System.out.println("Enter product's exp date : yyyy-MM-dd");
				LocalDate expDate = LocalDate.parse(sc.next());
				if (expDate.isAfter(LocalDate.now())) {
//valid date 
					//add product to the category : establish bi dir link
					//not gpoing in db, just linking within the objects
					category.addProduct(new Product(name, price, desc, expDate));
				} else
					System.out.println("Invalid exp date!!!!!!!!!!!!!!!!");
				sc.nextLine();
				

			}
			cDao.addNewCategory(category);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
