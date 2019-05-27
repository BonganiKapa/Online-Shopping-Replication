package bk.pnp.onlineshoppingBE.DAO;

import java.util.List;

import bk.pnp.onlineshoppingBE.dto.Product;

public interface ProductsDAO {
	
	Product get(int productId);
	List<Product> list();
	boolean add(Product pro);
	boolean update(Product pro);
	boolean delete(Product pro);

	
	List<Product> getProductByParam(String name, int count);
	
	//ADMINISTRATOR PURPOSES
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
}
