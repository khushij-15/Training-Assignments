package controller;

import java.io.IOException;
import model.UserStore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String username = request.getParameter("username");
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");
	    String confirmPassword = request.getParameter("confirmPassword");

	    if (!password.equals(confirmPassword)) {

	        response.setContentType("text/html");

	        response.getWriter().println("<h2>Passwords do not match!</h2>");
	        response.getWriter().println("<a href='register.jsp'>Try Again</a>");

	        return;
	    }

	    User user = new User(username, email, password);

	    UserStore.users.add(user);
	    response.sendRedirect("login.jsp");
	}

}
