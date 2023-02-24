package com.masai.service;

import com.masai.exception.CustomerException;
import com.masai.heybroker.exception.*;
import com.masai.heybroker.model.*;
import com.masai.heybroker.repository.*;
import com.masai.model.Customer;
import com.masai.model.CustomerCurrentSession;
import com.masai.model.Deal;
import com.masai.repository.CustomerDao;
import com.masai.repository.CustomerSessionDao;

import org.hibernate.validator.internal.properties.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.security.auth.login.LoginException;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private CustomerSessionDao customerSessionDao;

    @Autowired
    private PropertyDao propertyDao;

    @Autowired
    private DealDao dealDao;

    @Autowired
    private BrokerDao brokerDao;


    @Override
    public Customer createCustomer(Customer customer) throws CustomerException {
        Customer existingCustomer = customerDao.findByEmail(customer.getEmail());



        if(existingCustomer!=null) throw new CustomerException("Customer already registered with email "+customer.getEmail());

        return customerDao.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer, String key) throws CustomerException,LoginException {

        CustomerCurrentSession logeedInUser = customerSessionDao.findByCid(key);

        if(logeedInUser==null) throw new LoginException("Please provide valid key to update customer");

        if(customer.getCustomerId()==logeedInUser.getCustomerId()){

            return customerDao.save(customer);
        }else throw new CustomerException("Invalid customer details please log in first");
    }

    @Override
    public Customer getProfile(String key) throws LoginException {

        CustomerCurrentSession customerCurrentSession =customerSessionDao.findByCid(key);

        if(customerCurrentSession==null) throw new LoginException("please login first");

        Optional<Customer> opt= customerDao.findById((Integer) customerCurrentSession.getCustomerId());

        return opt.get();
    }

    @Override
    public List<Property> viewPropertyByPropertyType(String key, String prpType) throws PropertyException,LoginException {

        CustomerCurrentSession customerCurrentSession =customerSessionDao.findByCid(key);

        if(customerCurrentSession==null) throw new LoginException("please login first");

        PropertyType obj=PropertyType.valueOf(prpType);

        List<Property> propertyList=propertyDao.findByPropertyType(obj);
        if(propertyList.isEmpty()) throw new PropertyException("property not found with given property type");

        return propertyList;

    }

	@Override
	public List<Property> viewAllProperty(String key) throws PropertyException, LoginException, CustomerException {
        // TODO Auto-generated method stub
        CustomerCurrentSession logeedInUser = customerSessionDao.findByCid(key);

        if (logeedInUser == null) throw new LoginException("Please Login first");


        List<Property> properties = propertyDao.findAll();

        if (properties.isEmpty()) throw new PropertyException("No Properties available for now");

        return properties;
    }

    @Override
    public Deal addDeal(Integer propid, String key) throws PropertyException, LoginException {

        CustomerCurrentSession logeedInUser = customerSessionDao.findByCid(key);

        if (logeedInUser == null) throw new LoginException("Please Login first");


       Optional<Property> opt = propertyDao.findById(propid);

       if(!opt.isPresent()) throw  new PropertyException("No Properties available with proerty Id: " + propid);

       Property property = opt.get();

       if(property.isStatus()==false){
           throw new PropertyException("Property already sold");
       }

       Optional<Customer> opt1= customerDao.findById(logeedInUser.getCustomerId());

       Customer customer= opt1.get();

       Deal deal = new Deal();

       deal.setDate(LocalDate.now());
       deal.setDealCost(property.getOfferCost());
       deal.setCustomerDeals(customer);
       deal.setProperty(property);
       deal.setDealBroker(property.getBroker());

      customer.getDeals().add(deal);
      property.getBroker().getDeals().add(deal);
      property.setStatus(false);
        property.setCustomer(customer);
      customerDao.save(customer);

      return deal;
    }

    @Override
    public List<Deal> viewAllDeals(String key) throws LoginException, DealException {
        CustomerCurrentSession logeedInUser = customerSessionDao.findByCid(key);

        if (logeedInUser == null) throw new LoginException("Please Login first");

           Optional<Customer> customer = customerDao.findById(logeedInUser.getCustomerId());

           List<Deal> deals = customer.get().getDeals();

           if (deals.isEmpty()) throw new DealException("No any deal in your portfolio");

           return deals;
    }

	@Override
	public CustomerCurrentSession findByCid(String key) {
		// TODO Auto-generated method stub
		return null;
	}
}