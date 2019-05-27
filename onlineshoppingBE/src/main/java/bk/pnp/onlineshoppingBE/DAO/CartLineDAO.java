package bk.pnp.onlineshoppingBE.DAO;

import java.util.List;

import bk.pnp.onlineshoppingBE.dto.Cart;
import bk.pnp.onlineshoppingBE.dto.CartLine;
import bk.pnp.onlineshoppingBE.dto.OrderDetails;

public interface CartLineDAO {
	
	public List<CartLine> list (int cartId);
	public CartLine get(int id);
	public boolean add (CartLine cl);
	public boolean update(CartLine cl);
	public boolean remove(CartLine cl);
	
	//CART BASED ON CARTID & PRODUCTID
	public CartLine getByCartAndProduct(int cartId, int productId);
	
	//CART UPDATE
	boolean updateCart(Cart cart);
	
	//LIST OF CART LINE
	public List listAvailable(int cartId);
	
	//ADD ORDER LIST
	boolean addOrderDetails(OrderDetails od);
}
