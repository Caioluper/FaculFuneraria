package interfaces;
import java.util.List;
import entidades.PlanoFunerario;

public interface IRepositorio {
    void salvar(PlanoFunerario plano);
    void remover();
    PlanoFunerario alterar(PlanoFunerario planoAntigo, PlanoFunerario planoNovo);
    List<PlanoFunerario> listar();
}
