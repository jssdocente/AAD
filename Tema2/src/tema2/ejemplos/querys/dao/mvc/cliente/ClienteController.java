package tema2.ejemplos.querys.dao.mvc.cliente;

import tema2.ejemplos.querys.dao.mvc.dao.IClienteDao;

import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    private ClienteView vista= new ClienteView();

    public ClienteController() {
    }

    //llama al DAO para guardar un cliente
    public void registrar(Cliente cliente ) {
        IClienteDao dao= new  ClienteDaoImpl();
        dao.registrar(cliente);
    }

    //llama al DAO para actualizar un cliente
    public void actualizar(Cliente cliente) {
        IClienteDao dao= new  ClienteDaoImpl();
        dao.actualizar(cliente);
    }

    //llama al DAO para eliminar un cliente
    public void eliminar(Cliente cliente) {
        IClienteDao dao= new  ClienteDaoImpl();
        dao.eliminar(cliente);
    }

    //llama al DAO para obtener todos los clientes y luego los muestra en la vista
    public void verClientes(){
        List<Cliente> clientes = new ArrayList<Cliente>();
        IClienteDao dao= new  ClienteDaoImpl();
        clientes=dao.obtener();
        vista.verClientes(clientes);
    }
}
