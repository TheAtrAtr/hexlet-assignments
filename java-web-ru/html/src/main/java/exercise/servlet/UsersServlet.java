package exercise.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.ArrayUtils;

public class UsersServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {

        String pathInfo = request.getPathInfo();

        if (pathInfo == null) {
            showUsers(request, response);
            return;
        }

        String[] pathParts = pathInfo.split("/");
        String id = ArrayUtils.get(pathParts, 1, "");

        showUser(request, response, id);
    }

    private List<User> getUsers() throws JsonProcessingException, IOException {
        // BEGIN
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> userList = objectMapper.readValue(new File("src/main/resources/users.json"), new TypeReference<>() {
        });
        return userList;
        // END
    }

    private void showUsers(HttpServletRequest request,
                           HttpServletResponse response)
            throws IOException {

        // BEGIN
        var userList = getUsers();

        StringBuilder body = new StringBuilder();
        body.append("""
                <!DOCTYPE html>
                <html lang=\"ru\">
                    <head>
                        <meta charset=\"UTF-8\">
                        <title>Example application | Users</title>
                        <link rel=\"stylesheet\" href=\"mysite.css\">
                    </head>
                    <body>
                    <table>
                    
                """);
        body.append("<tr>");
        body.append("<td>" + "user_Id" + "</td>");
        body.append("<td>" + "fullName" + "</td>");
        body.append("</tr>");


        for (var user : userList) {
            body.append("<tr>");

            body.append("<td>" + user.getId() + "</td>");
            body.append("<td><a href=\"/users/" + user.getId() + "\">" + user.getFirstName() + " " + user.getLastName() + "</a></td>");

            body.append("</tr>");
        }
        body.append("""
                    </table>
                    </body>
                </html>
                """);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(body.toString());
        // END
    }

    private void showUser(HttpServletRequest request,
                          HttpServletResponse response,
                          String id)
            throws IOException {

        // BEGIN
        var userList = getUsers();

        StringBuilder body = new StringBuilder();
        body.append("""
                <!DOCTYPE html>
                <html lang=\"ru\">
                    <head>
                        <meta charset=\"UTF-8\">
                        <title>Example application | Users</title>
                        <link rel=\"stylesheet\" href=\"mysite.css\">
                    </head>
                    <body>
                    <table>
                """);

        for (var user : userList) {
            if (id.equals(user.getId())) {
                body.append("<tr>");
                body.append("<td>" + "user_Id" + "</td>");
                body.append("<td>" + "FirstName" + "</td>");
                body.append("<td>" + "LastName" + "</td>");
                body.append("<td>" + "Email" + "</td>");
                body.append("</tr>");
                body.append("<tr>");
                body.append("<td>" + user.getId() + "</td>");
                body.append("<td>" + user.getFirstName() + "</td>");
                body.append("<td>" + user.getLastName() + "</td>");
                body.append("<td>" + user.getEmail() + "</td>");
                body.append("</tr>");
                body.append("""
                            </table>
                            </body>
                        </html>
                        """);
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println(body.toString());
                return;
            }
        }
        response.sendError(HttpServletResponse.SC_NOT_FOUND);

        // END
    }
}
