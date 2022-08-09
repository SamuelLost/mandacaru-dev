package br.ufc.mandacaru.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.ufc.mandacaru.spring.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	Product findFirstByName (String name);
	
	List<Product> findAllByName (String name);
	
	@Query(value = "select * from product where name = ?1", nativeQuery = true)
	Product getAlmada(String name);
}
