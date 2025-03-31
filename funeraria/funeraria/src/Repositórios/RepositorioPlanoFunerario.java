package repositorios;
import interfaces.IRepositorio;
import entidades.PlanoFunerario;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class RepositorioPlanoFunerario implements IRepositorio {
    private Stack<PlanoFunerario> planos = new Stack<>();

    @Override
    public void salvar(PlanoFunerario plano) {
        planos.push(plano);
    }

    @Override
    public void remover() {
        if (!planos.isEmpty()) {
            planos.pop();
        } else {
            System.out.println("Nenhum plano para remover.");
        }
    }

    @Override
    public PlanoFunerario alterar(PlanoFunerario planoAntigo, PlanoFunerario planoNovo) {
        Stack<PlanoFunerario> tempStack = new Stack<>();
        PlanoFunerario atualizado = null;

        while (!planos.isEmpty()) {
            PlanoFunerario p = planos.pop();
            if (p.getCpf().equals(planoAntigo.getCpf())) {
                tempStack.push(planoNovo);
                atualizado = planoNovo;
            } else {
                tempStack.push(p);
            }
        }

        while (!tempStack.isEmpty()) {
            planos.push(tempStack.pop());
        }

        return atualizado;
    }

    @Override
    public List<PlanoFunerario> listar() {
        return new ArrayList<>(planos);
    }
}
