package com.food.ordermanagement.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.ordermanagement.model.DeliveryBoy;
import com.food.ordermanagement.model.OrderDetails;
import com.food.ordermanagement.model.Restaurant;

@Repository
public class RestaurantRepo implements JpaRepository<Restaurant, Long>{
	
	@Autowired
	EntityManager em;
	
	
	//String username,String restname,String item,int price '"+fields.getId()+"',
	public String postOrderDetails (OrderDetails od) throws Exception
	{  
		 Query qury =em.createNativeQuery("insert into order_details(id,username,mail,restname,itemname,phone,paid) values('"+od.getId()+"','"+od.getUsername()+"','"+od.getMail()+"','"+od.getRestname()+"','"+od.getItemname()+"','"+od.getPhone()+"','"+od.getPaid()+"')");
         qury.executeUpdate();
        if(qury.getResultList().isEmpty())
        		 throw new Exception();
        else return "order placed successfully";
        
	}
	
	
	public DeliveryBoy getDeliveryBoyDetails(int id)
	{
		 TypedQuery<OrderDetails> qry=em.createQuery("from OrderDetails t where t.id ='"+id+"'",OrderDetails.class);
		 OrderDetails od =qry.getSingleResult();
		 System.out.println(od.getRestname());
		 TypedQuery<DeliveryBoy> temp =em.createQuery("from DeliveryBoy d where for_rest='"+od.getRestname()+"'",DeliveryBoy.class);
         DeliveryBoy boy =temp.getSingleResult();
         System.out.println(od.getRestname());
         return boy;
	}
	
	
	
	
	@Override
	public Page<Restaurant> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Restaurant> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Restaurant> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Restaurant entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Restaurant> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Restaurant> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Restaurant> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Restaurant> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Restaurant> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Restaurant> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Restaurant> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Restaurant> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Restaurant> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Restaurant> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Restaurant> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Restaurant getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Restaurant> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Restaurant> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
