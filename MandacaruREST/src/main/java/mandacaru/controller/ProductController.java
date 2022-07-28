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
import mandacaru.dao.ProductDAO;
import mandacaru.dao.ProductHibernateDAO;
import mandacaru.entities.Product;

@Path("/products")
public class ProductController {
 
    ProductDAO productDAO = new ProductHibernateDAO();
 
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }
 
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getById(@PathParam("id") int id) {
        return productDAO.find(id);
    }
 
    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getByName(@QueryParam("name") String name) {
        return productDAO.findByName(name);
    }
 
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addProduct(@FormParam("name") String name, @FormParam("price") double price) {
        Product product = new Product(0, name, price);
        productDAO.save(product);
    }
 
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void updateProduct(@PathParam("id") int id, @FormParam("name") String name,
            @FormParam("price") double price) {
        Product product = new Product(id, name, price);
        productDAO.save(product);
    }
 
    @DELETE
    @Path("/{id}")
    public void deleteProduct(@PathParam("id") int id) {
        productDAO.delete(id);
    }
}