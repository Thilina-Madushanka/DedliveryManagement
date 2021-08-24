package BB;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AA.Delivery;
import AA.DeliveryDBUtil;

/**
 * Servlet implementation class DriverServlet
 */
@WebServlet("/DriverServlet")
public class DriverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DriverServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String date = request.getParameter("date");
		
			//driver and delivery
		
		try {
			
			List<Delivery> DelDetails = DeliveryDBUtil.validate(date);
			request.setAttribute("DelDetails", DelDetails);
			
			List<Driver> DriDetails = DriverDBUtil.getOrders();
			request.setAttribute("DriDetails", DriDetails);
			
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		
		RequestDispatcher dis = request.getRequestDispatcher("DisplayDriversAndDelivery.jsp");
		dis.forward(request, response);

		
	}

}
