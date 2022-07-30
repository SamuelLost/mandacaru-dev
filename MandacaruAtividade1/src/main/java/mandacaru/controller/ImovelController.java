package mandacaru.controller;


import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import mandacaru.dao.ImovelDAO;
import mandacaru.dao.ImovelHibernateDAO;
import mandacaru.entities.Imovel;

@Path("/imoveis")
public class ImovelController {

	ImovelDAO imovelDAO = new ImovelHibernateDAO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Imovel> getAllImoveis() {
		return imovelDAO.findAll();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Imovel getById(@PathParam("id") int id) {
		return imovelDAO.find(id);
	}
	
	@GET
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	public Imovel getByName(@QueryParam("titulo") String titulo) {
		return imovelDAO.findByName(titulo);
	}
	
	@GET
	@Path("/searchEndereco")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Imovel> getAllByName(@QueryParam("endereco") String endereco) {
		return imovelDAO.findAllByName(endereco);
	}	
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void addImovel(@FormParam("id") int id, @FormParam("titulo") String titulo, @FormParam("endereco") String endereco, 
			@FormParam("bairro") String bairro, @FormParam("numero") int numero, @FormParam("metrosQuadrados") double tamanho,
			@FormParam("metrosConstruidos") double construido, @FormParam("quartos") int quartos, @FormParam("banheiros")
			int banheiros, @FormParam("garagem") int garagem, @FormParam("preco") double preco) {
		
		Imovel imovel = new Imovel(0, titulo, endereco, bairro, numero, tamanho, construido, quartos, banheiros, garagem, preco);
		imovelDAO.save(imovel);
	}
	
	@PUT
    @Path("/{id}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void updateImovel(@PathParam("id") int id, @FormParam("titulo") String titulo, @FormParam("endereco") String endereco, 
			@FormParam("bairro") String bairro, @FormParam("numero") int numero, @FormParam("metrosQuadrados") double tamanho,
			@FormParam("metrosConstruidos") double construido, @FormParam("quartos") int quartos, @FormParam("banheiros")
			int banheiros, @FormParam("garagem") int garagem, @FormParam("preco") double preco) {
		
		Imovel imovel = new Imovel(id, titulo, endereco, bairro, numero, tamanho, construido, quartos, banheiros, garagem, preco);
		imovelDAO.save(imovel);
	}
	
	@DELETE
	@Path("/{id}")
	public void deleteImovel(@PathParam("id") int id) {
		imovelDAO.delete(id);
	}
	
}
