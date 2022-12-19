package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class ProdutoUsado extends Produto {

    private LocalDate dataFabricacao;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ProdutoUsado() {
        super();
    }

    public ProdutoUsado(String nome, Double preco, LocalDate dataFabricacao) {
        super(nome, preco);
        this.dataFabricacao = dataFabricacao;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public String EtiquetaPreco() {
        return  String.format("%.2f", getPreco());
    }

    @Override
    public String toString() {
        return  getNome() +
                " (usado) $ " +
                EtiquetaPreco() +
                " (Produto fabricado na data: " +
                dtf.format(dataFabricacao) +
                ")";
    }
}
