package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletConfigDemoServlet", urlPatterns = "/servletConfigDemo",
            initParams = {@WebInitParam(name = "admin", value = "LiuJiaXiang"),
                    @WebInitParam(name = "email", value = "test@qq.com")
            })
public class ServletConfigDemoServlet implements Servlet {

    private transient ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException {
        ServletConfig servletConfig = getServletConfig();
        String admin = servletConfig.getInitParameter("admin");
        String email = servletConfig.getInitParameter("email");
        PrintWriter writer = servletResponse.getWriter();
        writer.print("<html><head></head><body>" +
                "admin: " + admin + "<br/>" +
                "email:" + email +
                " </body></html>");
    }

    @Override
    public String getServletInfo() {
        return "ServletConfigDemo";
    }

    @Override
    public void destroy() {

    }
}
