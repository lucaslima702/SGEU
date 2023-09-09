
package SistemaDeGestaoEscolarUniversitaria;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	    String nome = request.getParameter("login");
        String senha = request.getParameter("senha");
        String registroTemporario = request.getParameter("registro");
	    int registro = Integer.parseInt(registroTemporario); 
	    try {
	      	Class.forName("com.mysql.cj.jdbc.Driver");
	       	Database.verificacaoDeLogin(registro, nome, senha);
	       	doGet(request, response);
		} catch (ClassNotFoundException | SQLException | NullPointerException e) {
			response.sendRedirect("index.jsp");
			e.printStackTrace();
			}	   
	    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("tarefas.jsp");
		rd.forward(request, response);
	}
}

