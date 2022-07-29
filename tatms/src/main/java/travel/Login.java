package travel;
import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DB2
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
		PrintWriter pw=response.getWriter();  
		String email = request.getParameter("email");
        String pass = request.getParameter("pass");
                 
        try {
//        	Class.forName("com.mysql.cj.jdbc.Driver");
//          	pw.println("driver loaded");
//          	pw.println("<br>");
//            conn = DriverManager.getConnection("jdbc:mysql://localhost/login","root","Vikash@2468");
//            pw.println("connected");
//            
//            pstm = conn.prepareStatement("Select email,pass from sign where email=? and pass=?");
//            pstm.setString(1, email);
//            pstm.setString(2, pass);
//            rs = pstm.executeQuery();
//            
//            while (!rs.next()) {
//                //pw.println("Correct login credentials");
//                if (rs.getString(1).equals(pass) && rs.getString(2).equals(email)) {
//                    pw.println("Correct login credentials");
//           		 	RequestDispatcher rd = request.getRequestDispatcher("index.html");
//           		 	rd.forward(request, response);
//           		 	flag = 1;
//           		 	break;
//                } 
//            } 
//            
//            if(flag == 0) {
//            	response.sendRedirect("login.html");
//            }
        	
        	 if(LoginDao.validate(email, pass)){ 
        		 HttpSession session = request.getSession();
        	     RequestDispatcher rd=request.getRequestDispatcher("index.html");  
        	     rd.forward(request,response);  
        	    }  
        	    else{  
        	        pw.print("Sorry username or password error");  
        	        RequestDispatcher rd=request.getRequestDispatcher("login.html");  
        	        rd.include(request,response);  
        	    }  
            
          } catch (Exception e) {
        	  e.printStackTrace();
        }
        
	}


}
