package bk.pnp.onlineshoppingBE.DAO;

import java.util.List;

import bk.pnp.onlineshoppingBE.dto.Category;

public interface CategoryDAO {

	
	Category get(int Id);
	List<Category> list();
	boolean add(Category cat);
	boolean update(Category cat);
	boolean delete(Category cat);
}
