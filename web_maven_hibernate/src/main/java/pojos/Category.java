package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Category extends BaseEntity {
	@Column(name="category_name",length = 30,unique = true)
	private String categoryName;
	@Column(length = 100)
	private String description;
	//one to many association  Category 1--->* Product
	//hib creates three tables, onee extra having id mapping, bcs we didnt instruct that our mapping is biderctional
	//Category: one, parent, not owning (=inverse)
	@OneToMany(mappedBy = "productCategory")
	private List<Product> products=new ArrayList<>();//Tip : init the collection else we get null pointer exception!
	public Category() {
		// TODO Auto-generated constructor stub
	}
	public Category(String categoryName, String description) {
		super();
		this.categoryName = categoryName;
		this.description = description;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Category ID "+getId()+" [categoryName=" + categoryName + ", description=" + description + "]";
	}
	
	
}
