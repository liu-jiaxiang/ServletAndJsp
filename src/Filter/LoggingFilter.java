package Filter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName = "LoggingFilter", urlPatterns = {"/*"},
		initParams = {
				@WebInitParam(name = "logFileName", value = "log.txt"),
				@WebInitParam(name = "prefix", value = "URI: ")
		})
public class LoggingFilter implements Filter {

	private PrintWriter logger;
	private String prefix;
	
	@Override
	public void destroy() {
		System.out.println("Destroying LoggerFilter...");
		if (logger != null) {
			logger.close();
		}
		
	}
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("LoggerFilter is working...");
		HttpServletRequest request = (HttpServletRequest) arg0;
		logger.println(new Date() + "" + prefix + request.getRequestURI());
		logger.flush();
		arg2.doFilter(arg0, arg1);
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		prefix = filterConfig.getInitParameter("prefix");
		String logFileName = filterConfig.getInitParameter("logFileName");
		String path = filterConfig.getServletContext().getRealPath("/");
		System.out.println("logFileName: " + logFileName);
		try {
			logger = new PrintWriter(new File(path, logFileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
