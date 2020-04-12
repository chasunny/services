package com.order.my.food.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.order.my.food.model.FoodMenu;
import com.order.my.food.model.Restaurant;

@Repository
public class RepoImplementation implements JpaRepository<Restaurant, Long> {

	@Autowired
	EntityManager em;
	
	
	//search with type(veg or nonveg)
	public List<Restaurant> findRestByType(String type) { 
    
         TypedQuery<Restaurant> qry =em.createQuery("from Restaurant r where r.type='"+type+"'",Restaurant.class);
         List<Restaurant> fields =qry.getResultList();
         return fields;
	}
	
	//search by distance
	public List<Restaurant> findRestByDistance(int dist)
	{
		TypedQuery<Restaurant> qry =em.createQuery("from Restaurant r where r.distance<='"+dist+"'",Restaurant.class);
        List<Restaurant> fields =qry.getResultList();
        return fields;
	}

	//search by price
	public List<Restaurant> findRestByPrice(int price) {
		
        TypedQuery<Restaurant> qry =em.createQuery("from Restaurant r where r.price<='"+price+"'",Restaurant.class);
        List<Restaurant> fields =qry.getResultList();
        return fields;
	}
	
	//search by rating
	public List<Restaurant> findRestByRating(double rating) {
        
        TypedQuery<Restaurant> qry =em.createQuery("from Restaurant r where r.rating >='"+rating+"'",Restaurant.class);
        List<Restaurant> fields =qry.getResultList();
        return fields;
	}
	
	public List findItemList(String name,String type)
	{
		   return em.createNativeQuery("select f.itemname,f.price from food_menu f where f.n_of_rest ='"+name+"' and f.itemtype='"+type+"'").getResultList();
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
}
