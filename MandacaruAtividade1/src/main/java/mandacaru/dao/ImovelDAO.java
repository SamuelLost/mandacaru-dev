package mandacaru.dao;

import java.util.List;

import mandacaru.entities.Imovel;

public interface ImovelDAO {

	public void save(Imovel imovel);

	public void delete(int id);

	public Imovel find(int id);

	public List<Imovel> findAll();
	
	public Imovel findByName(String name);
	
	public List<Imovel> findAllByName(String name);
}
