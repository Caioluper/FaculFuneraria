package servicos;
import interfaces.IServico;
import interfaces.IRepositorio;
import entidades.PlanoFunerario;
import java.util.List;

public class ServicoPlanoFunerario implements IServico {
    private IRepositorio repositorio;

    public ServicoPlanoFunerario(IRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public void cadastrarPlano(PlanoFunerario plano) {
        repositorio.salvar(plano);
    }

    @Override
    public void excluirPlano() {
        repositorio.remover();
    }

    @Override
    public PlanoFunerario atualizarPlano(PlanoFunerario planoAntigo, PlanoFunerario planoNovo) {
        return repositorio.alterar(planoAntigo, planoNovo);
    }

    @Override
    public List<PlanoFunerario> listarPlanos() {
        return repositorio.listar();
    }
}