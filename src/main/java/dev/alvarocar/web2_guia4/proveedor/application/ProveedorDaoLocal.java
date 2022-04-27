package dev.alvarocar.web2_guia4.proveedor.application;

import dev.alvarocar.web2_guia4.proveedor.domain.Proveedor;

import javax.ejb.Local;
import java.util.List;
import java.util.Optional;

@Local
public interface ProveedorDaoLocal {

  void addProveedor(Proveedor proveedor);
  void editProveedor(Proveedor proveedor);
  void deleteProveedor(Proveedor proveedor);
  Optional<Proveedor> getProveedorById(int id);
  List<Proveedor> getProveedor();
}
