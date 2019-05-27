package bk.pnp.onlineshoppingBE.daoImplement;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bk.pnp.onlineshoppingBE.DAO.CategoryDAO;
import bk.pnp.onlineshoppingBE.dto.Category;

@Repository("cartegoryDAO")
@Transactional
public class CategoryImple implements CategoryDAO{
	
	
	@Autowired
	private SessionFactory sf;
	
	
	@Override
	public List<Category> list(){
		
		String selectActiveCategory = "FROM Category WHERE active = :active";
		
		Query q = sf.getCurrentSession().createQuery(selectActiveCategory);
		
		q.setParameter("active", true);
		
		return q.getResultList();
	}
	
	//GETTING CATEGORY BASED ON ID
	@Override
	public Category get(int id) {
		
		return sf.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}
	
	
	//ADDING TO THE CATEGORY
	@Override
	public boolean add(Category cat) {
		try {
			sf.getCurrentSession().persist(cat);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	
	
	//UPATING THE CATEGORY
	@Override
	public boolean update(Category cat) {
		try {
			sf.getCurrentSession().persist(cat);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	
	//DELETING FROM THE CATEGORY
	@Override
	public boolean delete(Category cat) {
		try {
			sf.getCurrentSession().persist(cat);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}	
}
