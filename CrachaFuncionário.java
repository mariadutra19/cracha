public class CrachaFuncionário extends Cracha {
    private long horaEntrada;
    private long horaSaida;

    public CrachaFuncionário(String nome, String cargo, int id) {
        super(nome, cargo, id);
    }

    public void registrarEntrada() {
        this.horaEntrada = System.currentTimeMillis();
    }

    public void registrarSaida() {
        this.horaSaida = System.currentTimeMillis();
    }

    public long calcularHorasNoEstabelecimento() {
        if (horaEntrada != 0 && horaSaida != 0) {
            return (horaSaida - horaEntrada) / (1000 * 60 * 60);
        } else {
            return 0;
        }
    }
}
