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

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO customerDAO;
	private SalesmanDAO salesmanDAO;
	private OrderDAO orderDAO;
	
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		customerDAO = new CustomerDAO(jdbcURL, jdbcUsername, jdbcPassword);
		salesmanDAO = new SalesmanDAO(jdbcURL, jdbcUsername, jdbcPassword);
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
            case "/newCustomer":
            	System.out.println(action.toString());
                showNewCustomerForm(request, response);
                break;
            case "/insertCustomer":
                insertCustomer(request, response);
                break;
            case "/deleteCustomer":
                deleteCustomer(request, response);
                break;
            case "/editCustomer":
                showEditCustomerForm(request, response);
                break;
            case "/updateCustomer":
                updateCustomer(request, response);
                break;
            case "/newOrder":
                showNewOrderForm(request, response);
                break;
            case "/insertOrder":
                insertOrder(request, response);
                break;
            case "/deleteOrder":
                deleteOrder(request, response);
                break;
            case "/editOrder":
                showEditorderForm(request, response);
                break;
            case "/updateOrder":
                updateOrder(request, response);
                break;
            case "/newSalesman":
                showNewSalesmanForm(request, response);
                break;
            case "/insertSalesman":
                insertSalesman(request, response);
                break;
            case "/deleteSalesman":
                deleteSalesman(request, response);
                break;
            case "/editSalesman":
                showEditSalesmanForm(request, response);
                break;
            case "/updateSalesman":
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
	
	private void listCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
	
		List<Customer> listCustomer = customerDAO.listAllCustomers();
		request.setAttribute("listCustomer", listCustomer);
		RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerList.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showNewCustomerForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
		System.out.println("Show New Customer Form");
		RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerForm.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void showEditCustomerForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
	
		int id = Integer.parseInt(request.getParameter("id"));
		Customer existingCustomer = customerDAO.getCustomer(id);
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerForm.jsp");
		request.setAttribute("customer", existingCustomer);
		dispatcher.forward(request, response);	
	}
	
	private void insertCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
		
		String cust_name = request.getParameter("cust_name");
		String city = request.getParameter("city");
		int grade = Integer.parseInt(request.getParameter("grade"));
		int salesman_id = Integer.parseInt(request.getParameter("salesman_id"));
		
		Customer newCustomer = new Customer(cust_name, city, grade, salesman_id);
		customerDAO.insertCustomer(newCustomer);
		response.sendRedirect("list");	
	}
	
	private void updateCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
		
		int customer_id = Integer.parseInt(request.getParameter("customer_id"));
		String cust_name = request.getParameter("cust_name");
		String city = request.getParameter("city");
		int grade = Integer.parseInt(request.getParameter("grade"));
		int salesman_id = Integer.parseInt(request.getParameter("salesman_id"));
		
		Customer customer = new Customer(customer_id, cust_name, city, grade, salesman_id);
		customerDAO.updateCustomer(customer);
		response.sendRedirect("list");	
	}
	
	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
		
		int customer_id = Integer.parseInt(request.getParameter("customer_id"));
		
		Customer customer = new Customer(customer_id);
		customerDAO.deleteCustomer(customer);
		response.sendRedirect("list");	
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