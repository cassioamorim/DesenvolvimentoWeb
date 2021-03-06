package DAOs;

import Entidades.Venda;
import static DAOs.DAOGenerico.em;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DAOVenda extends DAOGenerico<Venda> {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public DAOVenda() {
        super(Venda.class);
    }

    public int autoIdVenda() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idVenda) FROM Venda e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Venda> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Venda e WHERE e.data LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Venda> listById(int id) {
        return em.createQuery("SELECT e FROM Venda e WHERE e.idVenda = :id").setParameter("id", id).getResultList();
    }

    public List<Venda> listInOrderNome() {
        return em.createQuery("SELECT e FROM Venda e ORDER BY e.data").getResultList();
    }

    public List<Venda> listInOrderId() {
        return em.createQuery("SELECT e FROM Venda e ORDER BY e.idVenda").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Venda> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdVenda() + "-" + sdf.format(lf.get(i).getData()) + "-" + lf.get(i).getClienteCpf().getNome());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOVenda daoVenda = new DAOVenda();
        List<Venda> listaVenda = daoVenda.list();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Venda venda : listaVenda) {
            System.out.println(venda.getIdVenda() + "-" + sdf.format(venda.getData()) + "-" + venda.getClienteCpf().getNome());
        }
    }
}
