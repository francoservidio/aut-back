package org.serviconsulting.aut.dao;

import org.serviconsulting.aut.model.Cliente;

import java.util.List;

public interface ClienteDAO {

    public void createCliente(Cliente cliente);

    public Cliente getClienteById(Long id);

    public List<Cliente> getAllClientes();

    public Cliente updateCliente(Cliente cliente);

    public void deleteCliente(Long id);

}
