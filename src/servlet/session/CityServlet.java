package servlet.session;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CityServlet", urlPatterns = "/city")
public class CityServlet extends HttpServlet {

    private List<String> koreaCitys;
    private List<String> chinaCitys;

    @Override
    public void init() {
        chinaCitys = new ArrayList<String>();
        chinaCitys.add("ChenDu");
        chinaCitys.add("ShangHai");
        chinaCitys.add("BeiJing");
        koreaCitys = new ArrayList<String>();
        koreaCitys.add("Seoul");
        koreaCitys.add("Busan");
        koreaCitys.add("Jeju");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String country = request.getParameter("country");
        if (country != null && ("China".equals(country) ||"Korea".equals(country))) {
            showCities(request, response, country);
        } else {
            showIndex(request, response);
        }
    }

    private void showCities(HttpServletRequest request, HttpServletResponse response,
                            String country) throws IOException {
        String pageParam = request.getParameter("page");
        int page = 1;
        if (pageParam != null) {
            page = Integer.parseInt(pageParam);
            if (page >2 || page < 1) {
                page = 1;
            }
        }
        List<String> cities = null;
        if (country.equals("China")) {
            cities = chinaCitys;
        } else if (country.equals("Korea")) {
            cities = koreaCitys;
        }
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<html><head></head><body>");
        writer.print("<div><a href='city'>Select Country</a>");
        writer.print("<hr/>Page" + page + "<hr/>");
        writer.print("<div>");
        for(String city : cities) {
            writer.print(city);
            writer.print("<br/>");
        }
        writer.print("</div>");
        writer.print("<div>");
        writer.print("<a href='?country=" + country + "&page=1'>Page 1</a>");
        writer.print("<a href='?country=" + country + "&page=2'>Page 2</a>");
        writer.print("</div>");
        writer.print("</body></html>");
    }

    private void showIndex(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<html><head></head><body>");
        writer.print("Please select a country");
        writer.print("<br/><a href='?country=China'>China</a>");
        writer.print("<br/><a href='?country=Korea'>Korea</a>");
        writer.print("</body></html>");
    }
}
