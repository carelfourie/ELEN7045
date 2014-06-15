package za.ac.wits.eie.ELEN7045.aps.controller;

//@Named @RequestScoped
public class Credentials {

	private String username;
    private String password;
    private String url;
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
	public String getUrl() { return url; }
	public void setUrl(String url) { this.url = url; }
    
}
