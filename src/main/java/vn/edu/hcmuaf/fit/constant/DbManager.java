package vn.edu.hcmuaf.fit.constant;

import vn.edu.hcmuaf.fit.database.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class DbManager implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
    public static IConnectionPool connectionPool = null;


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        String uid = "root";
        String pwd = "";
        String database = "apple_store";
        connectionPool = DbConnection.init(uid, pwd, database);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
        if (connectionPool != null) {
            connectionPool.shutdown();
            connectionPool = null;
        }
    }
}
