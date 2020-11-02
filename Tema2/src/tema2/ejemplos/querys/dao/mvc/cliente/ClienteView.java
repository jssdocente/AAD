package tema2.ejemplos.querys.dao.mvc.cliente;

import java.util.List;

public class ClienteView {
    public void verCliente(Cliente cliente) {
        System.out.println("Datos del Cliente: "+cliente);
    }

    public void verClientes(List<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            System.out.println("Datos del Cliente: "+cliente);
        }
    }
}
