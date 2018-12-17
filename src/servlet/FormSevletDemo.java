package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FormServletDemo", urlPatterns = "/formServletDemo")
public class FormSevletDemo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<body><h1>Form</h1>");
		writer.println("<form method='post'>");
		writer.println("<div>name:");
		writer.println("<input name='name' type='text' />");
		writer.println("</div>");
		writer.println("<div>contry:");
		writer.println("<select name='contry'>");
		writer.println("<option>USA</option>");
		writer.println("<option>China</option>");
		writer.println("</select>");
		writer.println("</div>");
		writer.println("<div>method:");
		writer.println("<input name='method' type='radio' value='one' />");
		writer.println("<input name='method' type='radio' value='two' />");
		writer.println("</div>");
		writer.println("<div>comfirm:");
		writer.println("<input name='comfirm' type='checkbox' />");
		writer.println("</div>");
		writer.println("<div>");
		writer.println("<input type='reset' />");
		writer.println("<input type='submit' />");
		writer.println("</div>");
		writer.println("</form>");
		writer.println("</body>");
		writer.println("</html>");
		response.addCookie(new Cookie("admin", "liujiaxiang"));
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("name:" + request.getParameter("name"));
		writer.println("contry:" + request.getParameter("contry"));
		writer.println("method:" + request.getParameter("method"));
		writer.println("comfirm:" + request.getParameter("comfirm"));
		writer.println("contextPath:" + request.getContextPath());
		writer.println("cookies:" + request.getCookies());
		writer.println("Header:" + request.getHeader("User-Agent"));
		writer.println("queryString" + request.getQueryString());
		writer.println("</html>");
		writer.println("</body>");
	}
}
