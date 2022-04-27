package dev.alvarocar.web2_guia4.proveedor.infra;

import dev.alvarocar.web2_guia4.proveedor.application.ProveedorDao;
import dev.alvarocar.web2_guia4.proveedor.application.ProveedorDaoLocal;
import dev.alvarocar.web2_guia4.proveedor.domain.Proveedor;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProveedorServlet", urlPatterns = {"/ProveedorServlet"})
public class ProveedorServlet extends HttpServlet {

  private ProveedorDaoLocal proveedorDao;

  public ProveedorServlet() {}

  public void init() {
    proveedorDao = new ProveedorDao();
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
  throws ServletException, IOException {
    String action = req.getParameter("action") == null ? "" : req.getParameter("action");
    String idProveedorStr = req.getParameter("idProveedor") == null ? "" : req.getParameter("idProveedor");

    int idProveedor = idProveedorStr.equals("") ? 0 : Integer.parseInt(idProveedorStr);
    String nombre = req.getParameter("nombre");
    Proveedor proveedor = new Proveedor(idProveedor, nombre);

    if (action.equalsIgnoreCase("search")) {
      proveedor = proveedorDao.getProveedorById(idProveedor).get();
    } else {
      doActionCrud(action, proveedor);
    }

    req.setAttribute("proveedor", proveedor);
    req.setAttribute("TodoProveedor", proveedorDao.getProveedor());
    req.getRequestDispatcher("proveedorInfo.jsp").forward(req, resp);
  }

  private void doActionCrud(String action, Proveedor proveedor) {
    switch (action.toLowerCase()) {
      case "add":
        proveedorDao.addProveedor(proveedor);
        break;
      case "edit":
        proveedorDao.editProveedor(proveedor);
        break;
      case "delete":
        proveedorDao.deleteProveedor(proveedor);
        break;
      default:

    }
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doGet(req, resp);
  }
}
