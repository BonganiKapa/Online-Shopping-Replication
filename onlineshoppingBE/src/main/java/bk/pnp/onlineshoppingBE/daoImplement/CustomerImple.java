package bk.pnp.onlineshoppingBE.daoImplement;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bk.pnp.onlineshoppingBE.DAO.CustomerDAO;
import bk.pnp.onlineshoppingBE.dto.Address;
import bk.pnp.onlineshoppingBE.dto.Customer;

@Repository("customerDAO")
@Transactional
public class CustomerImple implements CustomerDAO{

	@Autowired
	private SessionFactory sf;
	
	@Override
	public Customer getByEmail(String email) {
		String queries = "FROM Customer WHERE email = :email";
		try {
			return sf.getCurrentSession()
					.createQuery(queries, Customer.class)
					.setParameter("email", email)
					.getSingleResult();
		}
		catch (Exception ex) {
			return null;
		}
	}
	
	
	//ADDING A NEW CUSTOMER TO THE DATABASE
	@Override
	public boolean add(Customer cus) {
		sf.getCurrentSession().persist(cus);
		return true;
	}
	catch (Exception ex) {
		return false;
	}
	
	
	@Override
	public boolean addAddress(Address address) {
		sf.getCurrentSession().persist(address);
		return true;
	}
	catch (Exception ex) {
		return false;
	}
	
	//UPDATING THE CUSTOMER ADDRESS
	@Override
	public boolean updateAddress(Address address) {
		sf.getCurrentSession().update(address);
		return true;
	}
	catch (Exception ex) {
		return false;
	}
	
	//SHOWING CUSTOMER ADDRESS BY DECENDING 
	@Override
	public List<Address> listShippingAddress(int userId){
		String selectQuery = "FROM  address WHERE userId = :userId AND Shipping = :isShipping ORDER BY id DESC";
		return sf.getCurrentSession()
				.createQuery(selectQuery, Address.class)
				.setParameter("userId", userId)
				.setParameter("isShipping", true)
				.getResultList();
	}
	
	
	@Override
	public Address getBillingAddress(int cutomerId){
		String selectQuery = "FROM  address WHERE userId = :userId AND billing = :isBilling";
		try {
			return sf.getCurrentSession()
					.createQuery(selectQuery, Address.class)
					.setParameter("userId", cutomerId)
					.setParameter("isBilling", true)
					.getSingleResult();
		}
		catch (Exception ex){
			return null;
		}
	}
	
	@Override 
	public Customer get(int id) {
		try {
			return sf.getCurrentSession()
					.get(Customer.class, id);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
	
	@Override 
	public Address getAddress(int addressId) {
		try {
			return sf.getCurrentSession()
					.get(Address.class, addressId);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
}

