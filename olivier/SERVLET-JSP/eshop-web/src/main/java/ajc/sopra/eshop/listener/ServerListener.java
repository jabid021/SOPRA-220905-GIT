package ajc.sopra.eshop.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ajc.sopra.eshop.config.JpaConfig;

/**
 * Application Lifecycle Listener implementation class ServerListener
 *
 */
@WebListener
public class ServerListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public ServerListener() {
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext) sce.getServletContext()
				.getAttribute("springCtx");
		if (ctx != null) {
			ctx.close();
		}
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JpaConfig.class);
		sce.getServletContext().setAttribute("springCtx", ctx);
	}

}
