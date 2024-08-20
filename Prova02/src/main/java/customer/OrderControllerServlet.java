//Mariana Costa da Luz

package customer;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderDAO orderDAO;
	
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		orderDAO = new OrderDAO(jdbcURL, jdbcUsername, jdbcPassword);
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
            case "/order/new":
                showNewOrderForm(request, response);
                break;
            case "/order/insert":
                insertOrder(request, response);
                break;
            case "/order/delete":
                deleteOrder(request, response);
                break;
            case "/order/edit":
                showEditorderForm(request, response);
                break;
            case "/order/update":
                updateOrder(request, response);
                break;
            default:
                listOrder(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
	
	private void listOrder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
	
		List<Order> listOrder = orderDAO.listAllOrders();
		request.setAttribute("listOrder", listOrder);
		request.getRequestDispatcher("OrderList.jsp").forward(request, response);
	}
	
	private void showNewOrderForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
	
		request.getRequestDispatcher("OrderForm.jsp").forward(request, response);
	}
	
	private void showEditorderForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
	
		int id = Integer.parseInt(request.getParameter("id"));
		Order existingOrder = orderDAO.getOrder(id);
	
		request.setAttribute("order", existingOrder);
		request.getRequestDispatcher("OrderForm.jsp").forward(request, response);	
	}
	
	private void insertOrder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
		
		float purch_amt = Float.parseFloat(request.getParameter("purch_amt"));
		Date ord_date = Date.valueOf(request.getParameter("ord_date"));
		int customer_id = Integer.parseInt(request.getParameter("customer_id"));
		int salesman_id = Integer.parseInt(request.getParameter("salesman_id"));
		
		Order neworder = new Order(purch_amt, ord_date, customer_id, salesman_id);
		orderDAO.insertOrder(neworder);
		response.sendRedirect("list");	
	}
	
	private void updateOrder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
		
		int order_id = Integer.parseInt(request.getParameter("order_id"));
		float purch_amt = Float.parseFloat(request.getParameter("purch_amt"));
		Date ord_date = Date.valueOf(request.getParameter("ord_date"));
		int customer_id = Integer.parseInt(request.getParameter("customer_id"));
		int salesman_id = Integer.parseInt(request.getParameter("salesman_id"));
		
		Order order = new Order(order_id, purch_amt, ord_date, customer_id, salesman_id);
		orderDAO.updateOrder(order);
		response.sendRedirect("list");	
	}
	
	private void deleteOrder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
		
		int order_id = Integer.parseInt(request.getParameter("order_id"));
		
		Order order = new Order(order_id);
		orderDAO.deleteOrder(order);
		response.sendRedirect("list");	
	}	
}