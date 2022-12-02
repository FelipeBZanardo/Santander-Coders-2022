package aula3.versao_desacoplada;

public enum ItensParaVenda {
    COCA_COLA("Coca-Cola", 5.0f),
    COCA_COLA_0("Coca-Cola 0", 4.5f),
    PEPSI("Pepsi", 4.4f),
    GUARANA_ANTARCTICA("Guaraná Antarctica", 3.5f),
    FANTA_LARANJA("Fanta Laranja", 4.2f),
    AGUA("Água", 2.5f),
    PIPOCA("Pipoca", 3.0f),
    PIPOCA_DOCE("Pipoca Doce", 4.0f);

    private String nome;
    private float valor;

    ItensParaVenda(String nome, float valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public float getValor() {
        return valor;
    }
}
