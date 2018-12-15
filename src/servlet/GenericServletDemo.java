package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "GenericServletDemo", urlPatterns = "/GenericServletDemo",
		initParams = {
				@WebInitParam(name = "admin", value = "LiuJiaxiang"),
				@WebInitParam(name = "email", value = "1186380068@qq.com")
		})
public class GenericServletDemo extends GenericServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		ServletConfig servletConfig = getServletConfig();
		String admin = servletConfig.getInitParameter("admin");
		String email = servletConfig.getInitParameter("email");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print("<html><head></head><body>" 
				+ "Admin: " + admin
				+ "<br/>"
				+ "Email: " + email
				+ "</body></html>");

	}

}
