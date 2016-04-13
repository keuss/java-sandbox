package org.coenraets.cellar;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/wines")
public class WineResource {

	WineDAO dao = new WineDAO();
	
	// exemple : http://localhost:8088/cellar/api/wines
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Wine> findAll() {
		System.out.println("WineResource.findAll");
		return dao.findAll();
	}

	// exemple : http://localhost:8088/cellar/api/wines/search/SERENE
	@GET @Path("search/{query}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Wine> findByName(@PathParam("query") String query) {
		System.out.println("WineResource.findByName: " + query);
		return dao.findByName(query);
	}

	// exemple : http://localhost:8088/cellar/api/wines/10 
	@GET @Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Wine findById(@PathParam("id") String id) {
		System.out.println("WineResource.findById " + id);
		return dao.findById(Integer.parseInt(id));
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Wine create(Wine wine) {
		wine = dao.create(wine);
		// add gga
		System.out.println("WineResource.create " + wine.getName() + " with id : " + wine.getId());
		return wine;
	}

	@PUT @Path("{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Wine update(Wine wine) {
		System.out.println("WineResource.Updating wine: " + wine.getName());
		dao.update(wine);
		return wine;
	}
	
	@DELETE @Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void remove(@PathParam("id") int id) {
		System.out.println("WineResource.remove wine id: " +id);
		dao.remove(id);
	}

}
