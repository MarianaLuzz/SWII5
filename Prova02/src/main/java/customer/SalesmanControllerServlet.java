//Mariana Costa da Luz

package customer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SalesmanControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SalesmanDAO salesmanDAO;
	
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		salesmanDAO = new SalesmanDAO(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	        doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
            switch (action) {
            case "/new":
                showNewSalesmanForm(request, response);
                break;
            case "/insert":
                insertSalesman(request, response);
                break;
            case "/delete":
                deleteSalesman(request, response);
                break;
            case "/edit":
                showEditSalesmanForm(request, response);
                break;
            case "/update":
                updateSalesman(request, response);
                break;
            default:
                listSalesman(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
	
	private void listSalesman(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
	
		List<Salesman> listSalesman = salesmanDAO.listAllSalesmans();
		request.setAttribute("listSalesman", listSalesman);
		request.getRequestDispatcher("SalesmanList.jsp").forward(request, response);
	}
	
	private void showNewSalesmanForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
	
		request.getRequestDispatcher("SalesmanForm.jsp").forward(request, response);
	}
	
	private void showEditSalesmanForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
	
		int id = Integer.parseInt(request.getParameter("id"));
		Salesman existingSalesman = salesmanDAO.getSalesman(id);
	
		request.setAttribute("salesman", existingSalesman);
		request.getRequestDispatcher("SalesmanForm.jsp").forward(request, response);	
	}
	
	private void insertSalesman(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
		
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		float commission = Float.parseFloat(request.getParameter("commission"));
		
		System.out.println(name);
		System.out.println(name);
		System.out.print(commission);
		
		Salesman newSalesman = new Salesman(name, city, commission);
		salesmanDAO.insertSalesman(newSalesman);
		response.sendRedirect("list");	
	}
	
	private void updateSalesman(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
		
		int salesman_id = Integer.parseInt(request.getParameter("salesman_id"));
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		float commission = Float.parseFloat(request.getParameter("commission"));
		
		Salesman salesman = new Salesman(salesman_id, name, city, commission);
		salesmanDAO.updateSalesman(salesman);
		response.sendRedirect("list");	
	}
	
	private void deleteSalesman(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
		
		int salesman_id = Integer.parseInt(request.getParameter("salesman_id"));
		
		Salesman salesman = new Salesman(salesman_id);
		salesmanDAO.deleteSalesman(salesman);
		response.sendRedirect("list");	
	}	
}