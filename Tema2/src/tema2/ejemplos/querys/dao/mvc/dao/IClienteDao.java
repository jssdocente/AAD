package tema2.ejemplos.querys.dao.mvc.dao;

import tema2.ejemplos.querys.dao.mvc.cliente.Cliente;

import java.util.List;

public interface IClienteDao {
    public boolean registrar(Cliente cliente);
    public List<Cliente> obtener();
    public boolean actualizar(Cliente cliente);
    public boolean eliminar(Cliente cliente);
}