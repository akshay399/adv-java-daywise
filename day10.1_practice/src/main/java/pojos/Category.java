package pojos;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="categories")
public class Category extends BaseEntity{
	@Column(name="category_name")
	private String cName;
	@Column(name="category_description")
	private String cDescription;
	
	@OneToMany(mappedBy = "productCategory", cascade = CascadeType.ALL)
	List<Product> products = new ArrayList<>();
	public Category() {
		
	}
	public Category(String cName, String cDescription) {
		super();
		this.cName = cName;
		this.cDescription = cDescription;
	}
	
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcDescription() {
		return cDescription;
	}
	public void setcDescription(String cDescription) {
		this.cDescription = cDescription;
	}
	@Override
	public String toString() {
		return "Category [cName=" + cName + ", cDescription=" + cDescription + "]";
	}
	public void addProduct(Product p) {
		products.add(p);
		p.setProductCategory(this);
	}
}
