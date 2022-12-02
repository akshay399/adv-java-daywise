package listener;
import static utils.HibernateUtils.*;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class SFManager
 *
 */
@WebListener
public class SFManager implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public SFManager() {
    	
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // closing the sf
    	getFactory().close();
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("in context init");
    	// create singleton, immutable, thread safe session factory instance
    	getFactory(); // this will create sessionFcoty on application deployement time itself
    	
    }
	
}
