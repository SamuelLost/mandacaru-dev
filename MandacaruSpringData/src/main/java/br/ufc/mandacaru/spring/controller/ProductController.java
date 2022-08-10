package br.ufc.mandacaru.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.mandacaru.spring.dto.ProductDTO;
import br.ufc.mandacaru.spring.service.ProductService;

@RestController
@RequestMapping(path = "/api/products")
public class ProductController {

	@Autowired //já faz a injeção de dependencia
	ProductService service;

	@GetMapping
	public ResponseEntity<List<ProductDTO>> findAll() {
		return new ResponseEntity<List<ProductDTO>>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = "{id}")
	public ResponseEntity<ProductDTO> find(@PathVariable("id") int id) {
		ProductDTO product = service.find(id);
		if(product != null)
			return new ResponseEntity<ProductDTO>(service.find(id), HttpStatus.OK);
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	} 

	@GetMapping(path = "/search")
	public ResponseEntity<ProductDTO> findByName(@RequestParam("name") String name) {
		ProductDTO product = service.findByName(name);
		
		if(product != null) {
			return new ResponseEntity<ProductDTO>(product, HttpStatus.OK);	
		} else {
			return new ResponseEntity<ProductDTO>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public void save(@RequestBody ProductDTO product) {
		service.save(0, product);
	}

	@PutMapping(path = "{id}")
	public void update(@PathVariable("id") int id, @RequestBody ProductDTO product) {
		service.save(id, product);
	}

	@DeleteMapping(path = "{id}")
	public void delete(@PathVariable("id") int id) {
		service.delete(id);
	}
}

