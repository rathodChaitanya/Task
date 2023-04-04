import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ContactServlet extends HttpServlet {
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String name = request.getParameter("name");
      String email = request.getParameter("email");
      String subject = request.getParameter("subject");
      String message = request.getParameter("message");

    
      String jdbcUrl = "jdbc:mysql://localhost:3306/xenonstack";
      String username = "root";
      String password = "pass@123";
      try {
         Connection conn = DriverManager.getConnection(jdbcUrl, username, password);

         
         PreparedStatement stmt = conn.prepareStatement("INSERT INTO messages (name, email, subject , message) VALUES (?, ?, ?, ?");
         stmt.setString(1, name);
         stmt.setString(2, email);
         stmt.setString(3, subject);
         stmt.setString(4, message);
         stmt.executeUpdate();

         
         conn.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }

      
      response.sendRedirect("thankyou.html");
   }
}
