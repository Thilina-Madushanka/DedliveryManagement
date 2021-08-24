package thh;



import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import thh.assigndriverDao;
import thh.DriverBean;


@SuppressWarnings("unused")
@WebServlet("/")
public class assigndriverServ extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private assigndriverDao assigndriverdao;

    public void init() {
        this.assigndriverdao = new assigndriverDao();
    }
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/newassigning":
                    showNewAssigningForm(request, response);
                    break;
                case "/insert":
                    insertAssigning(request, response);
                    break;
                case "/delete":
                    deleteAssigning(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateAssigning(request, response);
                    break;
                default:
                    listAssignings(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listAssignings(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List <DriverBean > listUser = assigndriverdao.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewAssigningForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("driver-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        int deliveryid = Integer.parseInt(request.getParameter("deliveryid"));
       DriverBean existingUser = assigndriverdao.selectUser(deliveryid);
        RequestDispatcher dispatcher = request.getRequestDispatcher("driver-form.jsp");
        request.setAttribute("assign", existingUser);
        dispatcher.forward(request, response);

    }

    private void insertAssigning(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String drivername = request.getParameter("drivername");
        String time = request.getParameter("time");
       
        DriverBean newAssign= new DriverBean(drivername,time);
       assigndriverdao.insertUser(newAssign);
        response.sendRedirect("list");
    }

    private void updateAssigning(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int deliveryid = Integer.parseInt(request.getParameter("deliveryid"));
        String drivername = request.getParameter("drivername");
        String time = request.getParameter("time");
      

       DriverBean driverbean = new DriverBean(deliveryid,drivername,time);
        assigndriverdao.updateUser(driverbean);
        response.sendRedirect("list");
    }

    private void deleteAssigning(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int deliveryid = Integer.parseInt(request.getParameter("deliveryid"));
       assigndriverdao.deleteUser(deliveryid);
        response.sendRedirect("list");

    }
}