public class Cracha {
    private String nome;
    private String cargo;
    private int id;

    public Cracha(String nome, String cargo, int id) {
        this.nome = nome;
        this.cargo = cargo;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public int getId() {
        return id;
    }

    public boolean isValido() {
        // Simulando a validação do crachá (por exemplo, se o ID é positivo)
        return id > 0;
    }
}

