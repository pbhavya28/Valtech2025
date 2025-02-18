 package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class LoadConfigListner implements ServletContextListener {
	
	

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		Properties p = new Properties();
		ServletContext context = sce.getServletContext();
		try(InputStream is = context.getResourceAsStream("WEB-INF/cofig.properties")){
			
			if(is == null) {
				throw new RuntimeException("File not found");
				
			}
			p.load(is);
			String url = p.getProperty("url");
			String username = p.getProperty("username");
			String password = p.getProperty("password");
			String driver = p.getProperty("driver");
			
			Class.forName(driver);
			
			context.setAttribute("url", url);
			context.setAttribute("username", username);
			context.setAttribute("password", password);

			
		}
		catch(IOException |ClassNotFoundException e){
			throw new RuntimeException(e);
		}
				
//		System.out.println("First piece of code tha will be executed...");
//		System.out.println("Loading...Config....Done");
//		System.out.println("Creating database pool....");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Closing all databse connections in the connection pool....");
	}
}
