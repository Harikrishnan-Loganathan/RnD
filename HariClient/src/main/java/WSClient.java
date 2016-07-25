
import java.net.URI;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.ClientFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class WSClient {

	private String m_sName;
	
	private String m_sURI;
	ClientConfig config = null;
	Client client = null;

	public WSClient() {
		config = new DefaultClientConfig();
		client = Client.create(config);
	}

	public String getURI() {
		return this.m_sURI;
	}

	public void setURI(String uRI) {
		this.m_sURI = uRI;
	}

	private URI getBaseURI() {
		String service = getURI();
		return UriBuilder.fromUri(service).build(new Object[0]);
	}

	public void setFilter(ClientFilter p_sFilter) {
		client.addFilter(p_sFilter);
	}

	public String getSearchResultsXML() {
		String searchresult = doPost();
		return searchresult;
	}

	public String doPost() {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI());
		MultivaluedMap<String, String> WSInputs = new MultivaluedMapImpl();// jersey-core-1.1.4.1.jar
		WSInputs.add("Name", "Hari");
		String result = (String) service.path("webservice").path("krish")//Will be check @Path("/krish") in server Class
				.accept(MediaType.TEXT_PLAIN).post(String.class, WSInputs);
		return result;
	}

	public static void main(String[] args) {
		WSClient wsclient = new WSClient();
		wsclient.setURI("http://localhost:8080/HariWebWs/");
		System.out.println(wsclient.getSearchResultsXML());
	}
}