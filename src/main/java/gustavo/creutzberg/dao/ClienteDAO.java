/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gustavo.creutzberg.dao;

import gustavo.creutzberg.modules.Cliente;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author GUSTAVO
 */
public class ClienteDAO extends DAO {

    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unchecked")
    public static List<Cliente> listar() {
        Query q = criarQuery("SELECT c FROM Cliente c ORDER BY c.clienteId");
        List<Cliente> l = q.getResultList();
        System.out.println("total: " + l.size());
        return l;
    }

    public static Object lerClienteId(long id) {
        return ler(Cliente.class, id);
    }

}
