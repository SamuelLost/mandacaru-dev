package mandacaru.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mandacaru.entities.Imovel;

public class ImovelHibernateDAO implements ImovelDAO{
	// nome do persistence-unit é passado
	static EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory("mandacaru");
	static EntityManager entityManager;

	// Utilizando o Postman
	@Override
	public void save(Imovel entity) {
		entityManager = sessionFactory.createEntityManager();
		entityManager.getTransaction().begin();

		if (entity.getId() == 0) {
			entityManager.persist(entity); // insert
		} else {
			entityManager.merge(entity); // update
		}

		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public void delete(int id) {
		entityManager = sessionFactory.createEntityManager();
		Imovel product = entityManager.find(Imovel.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(product);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public Imovel find(int id) {
		entityManager = sessionFactory.createEntityManager();
		Imovel product = entityManager.find(Imovel.class, id);
		entityManager.close();

		return product;
	}

	@Override
	public List<Imovel> findAll() {
		entityManager = sessionFactory.createEntityManager();
		List<Imovel> products = entityManager.createQuery("from imoveis", Imovel.class).getResultList();
		entityManager.close();

		return products;
	}

	@Override
	public Imovel findByName(String str) {
		entityManager = sessionFactory.createEntityManager();
		Imovel product = null;

		try {
			product = entityManager.createQuery("from imoveis where name=?1", Imovel.class).setParameter(1, str)
					.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			return null;
		}
		entityManager.close();

		return product;
	}

	@Override
	public List<Imovel> findAllByName(String str) {
		entityManager = sessionFactory.createEntityManager();
		List<Imovel> products = null;

		try {
			products = entityManager.createQuery("from imoveis where name=?1", Imovel.class).setParameter(1, str)
					.getResultList();
		} catch (Exception e) {
			return null;
		}
		entityManager.close();

		return products;
	}
}
