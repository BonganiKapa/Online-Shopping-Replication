package bk.pnp.onlineshoppingBE.DAO;

import java.util.List;

import bk.pnp.onlineshoppingBE.dto.Address;
import bk.pnp.onlineshoppingBE.dto.Customer;

public interface CustomerDAO {
	
	Customer getByEmail(String email);
	Customer get (int id);
	
	boolean add(Customer cus);
	
	Address getAddress(int addressId);
	boolean addAddress(Address addrs);
	boolean updateAddress(Address addrs);
	Address getBillingAddress(int customerId);
	List<Address> listShippingAddress(int cusId);
	

}
