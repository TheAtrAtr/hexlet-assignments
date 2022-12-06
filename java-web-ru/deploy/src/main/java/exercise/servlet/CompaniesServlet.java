package exercise.servlet;

import exercise.Data;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static exercise.Data.getCompanies;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {

        // BEGIN
        String query = request.getQueryString();
        String param = request.getParameter("search");
        PrintWriter out = response.getWriter();

        if (query == null) {
            for (var companies : Data.getCompanies()) {
                out.print(companies);
                out.print("\n");
            }
        } else if (query.contains("search")) {
            if (param == null || param.equals("")) {
                for (var companies : Data.getCompanies()) {
                    out.print(companies);
                    out.print("\n");
                }
                return;
            }
            List<String> list = Data.getCompanies().stream()
                    .filter(n -> n.contains(param))
                    .toList();
            if (list.size() == 0)
                out.println("Companies not found");
            else {
                for (var companies : list) {
                    out.print(companies);
                    out.print("\n");
                }
            }
        } else {
            for (var companies : Data.getCompanies()) {
                out.print(companies);
                out.print("\n");
            }
        }
        // END
    }
}
