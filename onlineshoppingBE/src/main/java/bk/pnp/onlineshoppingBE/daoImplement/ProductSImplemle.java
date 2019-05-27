package bk.pnp.onlineshoppingBE.daoImplement;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bk.pnp.onlineshoppingBE.DAO.ProductsDAO;
import bk.pnp.onlineshoppingBE.dto.Product;

@Repository("productsDAO")
@Transactional
public class ProductSImplemle implements ProductsDAO {
	
	@Autowired
	private SessionFactory sf;
	

	@Override
	public Product get(int productsId) {
		
		try {
			return sf.getCurrentSession()
					.get(Product.class, Integer.valueOf(productsId));
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Product> list(){
		return sf.getCurrentSession()
				.createQuery("FROM Product", Product.class)
				.getResultList();
	}
	
	//ADDING A NEW PRODUCT ON THE SYSTEM
	@Override
	public boolean add(Product product) {
		try{
			sf.getCurrentSession()
			.persist(product);
			return true;
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	
	//UPDATING THE PRODUCTS
	@Override
	public boolean update(Product product) {
		try{
			product.setActive(false);
			//CALLING THE UPDATE METHOD
			return this.update(product);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	
	//REMOVING A PRODUCT FROM THE PRODUCT TABLE
	@Override
	public boolean delete(Product product) {
		try{
			sf.getCurrentSession()
			.update(product);
			return true;
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	//LIST OF PRODUCTS BY CATEGORY
	@Override
	public List<Product> listActiveProductsByCategory(int categoryId){
		String selectProductsByCategory = "FROM Product WHERE active = :active AND categoryId = :categoryId";
		return sf.getCurrentSession()
				.createQuery(selectProductsByCategory, Product.class)
				.setParameter("active", true)
				.setParameter("categoryId", categoryId)
				.getResultList();
	}
	
	//LISTING THE LATEST ACTIVE PRODUCTS
	@Override
	public List<Product> getLatestActiveProducts(int count){
		
		return sf.getCurrentSession()
				.createQuery("FROM Product WHERE active = :active ORDER BY id", Product.class)
				.setParameter("active", true)
				.setFirstResult(0)
				.setMaxResults(count)
				.getResultList();
	}
	
	
	@Override
	public List<Product> getProductByParam(String name, int count){
		String query = "FROM Product WHERE active = true ORDER BY" + name + " DESC";
		
		return sf.getCurrentSession()
				.createQuery(query, Product.class)
				.setParameter("active", true)
				.setFirstResult(0)
				.setMaxResults(count)
				.getResultList();
	}

}
