package interfaces;
import java.util.List;
import entidades.PlanoFunerario;

public interface IServico {
    void cadastrarPlano(PlanoFunerario plano);
    void excluirPlano();
    PlanoFunerario atualizarPlano(PlanoFunerario planoAntigo, PlanoFunerario planoNovo);
    List<PlanoFunerario> listarPlanos();
}
