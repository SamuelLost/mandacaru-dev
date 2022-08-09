package br.ufc.mandacaru.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import br.ufc.mandacaru.spring.model.Product;

@Component
public class ProductJDBCDAO implements ProductDAO {

	@Autowired //injetar a dependencia
	JdbcTemplate jdbcTemplate;

	@Override
	public void save(Product entity) {
		String insert_sql = "insert into products (name, price) values (?, ?)";
		String update_sql = "update products set name = ?, price = ? where id = ?";

		if (entity.getId() == 0) {
			jdbcTemplate.update(insert_sql, entity.getName(), entity.getPrice());

		} else {
			jdbcTemplate.update(update_sql, entity.getName(), entity.getPrice(), entity.getId());

		}
	}

	@Override
	public void delete(int id) {
		String sql = "delete from products where id = ?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public Product find(int id) {
		String sql = "select * from products where id = ?";

		try {
			return jdbcTemplate.queryForObject(sql,
					(rs, rowNum) -> new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price")), id);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Product> findAll() {
		String sql = "select * from products";

		return jdbcTemplate.query(sql,
				(rs, rowNum) -> new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price")));

	}

	@Override
	public Product findByName(String str) {
		String sql = "select * from products where name = ? LIMIT 1";

		try {
			return jdbcTemplate.queryForObject(sql,
					(rs, rowNum) -> new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price")), str);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Product> findAllByName(String str) {
		String sql = "select * from products where name = ?";

		try {
			return jdbcTemplate.query(sql,
					(rs, rowNum) -> new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price")), str);
		} catch (Exception e) {
			return null;
		}
	}

}

