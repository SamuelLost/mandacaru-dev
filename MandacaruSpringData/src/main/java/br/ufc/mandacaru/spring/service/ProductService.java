package br.ufc.mandacaru.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.mandacaru.spring.dto.ProductDTO;
import br.ufc.mandacaru.spring.model.Product;
import br.ufc.mandacaru.spring.repository.ProductRepository;

@Service
public class ProductService {
	 
    @Autowired
    ProductRepository productRepository;
 
    public void save(int id, ProductDTO entity) {
        Product product = new Product();
 
        if (id != 0) {
            product = findProduct(id);
        }
 
        product.setName(entity.getName());
        product.setPrice(entity.getPrice());
        productRepository.save(product);
    }
 
    public void delete(int id) {
        Product product = findProduct(id);
        productRepository.delete(product);
    }
 
    public ProductDTO find(int id) {
//        if (id < 1) {
//            return null;
//        }
 
//        Optional<Product> product = productRepository.findById(id);
 
    	Product product = findProduct(id);
//        if (product.isPresent()) {
//            ProductDTO dto = new ProductDTO();
//            dto.setName(product.get().getName());
//            dto.setPrice(product.get().getPrice());
//            return dto;
//        }
    	
    	if(product != null) {
    		ProductDTO dto = new ProductDTO();
    		dto.setName(product.getName());
    		dto.setPrice(product.getPrice());
    		return dto;
    	}
 
        return null;
    }
 
    private Product findProduct(int id) {
        if (id < 1) {
            return null;
        }
 
        Optional<Product> product = productRepository.findById(id);
 
        if (product.isPresent()) {
            return product.get();
        }
 
        return null;
    }
 
    public List<ProductDTO> findAll() {
        List<Product> list = productRepository.findAll();
        List<ProductDTO> listDTO = new ArrayList<ProductDTO>();
 
        for (Product product : list) {
            ProductDTO dto = new ProductDTO();
            dto.setName(product.getName());
            dto.setPrice(product.getPrice());
            listDTO.add(dto);
        }
 
        return listDTO;
    }
 
    public ProductDTO findByName(String str) {
        if (str.length() < 3) {
            return null;
        }
 
        Product product = productRepository.findFirstByName(str);
 
        if (product != null) {
            ProductDTO dto = new ProductDTO();
            dto.setName(product.getName());
            dto.setPrice(product.getPrice());
            return dto;
        }
 
        return null;
    }
 
    public List<Product> findAllByName(String str) {
//    	List<Product> products = productRepository.findAllByName(str);
//    	List<ProductDTO> productsDTO = new ArrayList<>();
//    	ProductDTO aux = new ProductDTO();
//    	for (Product product : products) {
//			aux.setName(product.getName());
//			aux.setPrice(product.getPrice());
//			productsDTO.add(aux);
//		}
//    	return productsDTO;
        return productRepository.findAllByName(str);
    }
}
