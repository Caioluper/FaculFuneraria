package entidades;

public class PlanoFunerario {
    private String titular;
    private String cpf;
    private String plano;

    public PlanoFunerario(String titular, String cpf, String plano) {
        this.titular = titular;
        this.cpf = cpf;
        this.plano = plano;
    }

    public String getTitular() { return titular; }
    public String getCpf() { return cpf; }
    public String getPlano() { return plano; }

    @Override
    public String toString() {
        return "Titular: " + titular + " | CPF: " + cpf + " | Plano: " + plano;
    }
}
