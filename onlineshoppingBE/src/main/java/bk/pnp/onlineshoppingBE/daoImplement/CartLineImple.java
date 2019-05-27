package bk.pnp.onlineshoppingBE.daoImplement;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bk.pnp.onlineshoppingBE.DAO.CartLineDAO;
import bk.pnp.onlineshoppingBE.dto.Cart;
import bk.pnp.onlineshoppingBE.dto.CartLine;
import bk.pnp.onlineshoppingBE.dto.OrderDetails;

@Repository("cartLineDAO")
@Transactional
public class CartLineImple implements CartLineDAO{

	@Autowired
	private SessionFactory sf;
	@Override
	public CartLine getByCartAndProduct(int cartId, int productId) {
	
		String query = "FROM CartLine WHERE cartId = :cartId AND product.id = :productId";
		try {
			
			return sf.getCurrentSession()
					.createQuery(query,CartLine.class)
					.setParameter("cartId", cartId)
					.setParameter("productId", productId)
					.getSingleResult();
		}
		catch(Exception e)
		{
			return null;
		}
				
	}
	
	//ADDING NEW PRODUCTS/ITEMS TO THE CART
	@Override
	public boolean add(CartLine cartLine) {
		try {
			sf.getCurrentSession()
			.persist(cartLine);
			return true;
		}
		catch (Exception excp) {
			excp.printStackTrace();
			return false;
		}
	} 
	
	//UPDATING A EXSISTING CART BY ADDING NEW PRODUCTS 
	@Override
	public boolean update(CartLine cartLine) {
		try {
			sf.getCurrentSession()
			.update(cartLine);
			return true;
		}
		catch (Exception excp) {
			excp.printStackTrace();
			return false;
		}
	}
	
	//REMOVING PRODUCTS/ITEMS FROM THE CART
	@Override
	public boolean remove(CartLine cartLine) {
		try {
			sf.getCurrentSession()
			.delete(cartLine);
			return true;
		}
		catch (Exception excp) {
			excp.printStackTrace();
			return false;
		}
	}
	
	@Override 
	public List<CartLine> list(int cartId){
		String query = "FROM CartLine WHERE cartId = :cartId";
		return sf.getCurrentSession()
				.createQuery(query, CartLine.class)
				.setParameter("cartId", cartId)
				.getResultList();
	}
	
	@Override 
	public CartLine get(int Id) {
		return sf.getCurrentSession().get(CartLine.class, Integer.valueOf(Id));
	}
	
	@Override
	public boolean updateCart(Cart cart) {
		try {
			sf.getCurrentSession().update(cart);
			return true;
		}
		catch(Exception e) 
		{
			return false;
		}
	}
	
	@Override
	public List<CartLine> listAvailable(int cartId){
		String query = "FROM CartLine WHERE cartId = :cartId AND available = :available";
		return sf.getCurrentSession()
				.createQuery(query, CartLine.class)
				.setParameter("avaialble", true)
				.getResultList();
	}

	@Override
	public boolean addOrderDetails(OrderDetails od) {
		try {
			sf.getCurrentSession().persist(od);
			return true;
		}
		catch(Exception e) 
		{
			return false;
		}
	}
}
