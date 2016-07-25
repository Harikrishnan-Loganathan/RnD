import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/krish")
public class RuleITWSEndpoints {
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String searchPost(
			@DefaultValue("") @FormParam("Name") String name)
	  {
			String l_sSearchResult= "welcome" + name; 
			return   l_sSearchResult;
	  }
}