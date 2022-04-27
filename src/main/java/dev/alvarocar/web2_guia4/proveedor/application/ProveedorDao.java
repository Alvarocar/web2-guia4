package dev.alvarocar.web2_guia4.proveedor.application;

import dev.alvarocar.web2_guia4.proveedor.domain.Proveedor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

public class ProveedorDao implements ProveedorDaoLocal {

  @PersistenceContext
  private EntityManager em;

  public ProveedorDao() {

  }

  @Override
  public void addProveedor(Proveedor proveedor) {
    em.persist(proveedor);
  }

  @Override
  public void editProveedor(Proveedor proveedor) {
    em.merge(proveedor);
  }

  @Override
  public void deleteProveedor(Proveedor proveedor) {
    em.remove(proveedor);
  }

  @Override
  public Optional<Proveedor> getProveedorById(int id) {
    return Optional.of(em.find(Proveedor.class, id));
  }

  @Override
  public List<Proveedor> getProveedor() {
    System.out.println(em);
    return em.createNamedQuery("Proveedor.getTodo").getResultList();
  }
}

