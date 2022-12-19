package Model;

import javax.xml.crypto.Data;

public class ProdutoImportado extends Produto {

    private Double taxaAlfandega;

    public ProdutoImportado() {
        super();
    }

    public ProdutoImportado(String nome, Double preco, Double taxaAlfandega) {
        super(nome, preco);
        this.taxaAlfandega = taxaAlfandega;
    }

    public Double getTaxaAlfandega() {
        return taxaAlfandega;
    }

    public void setTaxaAlfandega(Double taxaAlfandega) {
        this.taxaAlfandega = taxaAlfandega;
    }

    public Double PrecoTotal() {
        return getPreco() + taxaAlfandega;
    }

    @Override
    public String EtiquetaPreco() {
        return Double.toString(PrecoTotal());
    }

    @Override
    public String toString() {
        return  getNome() +
                " $ " +
                EtiquetaPreco() +
                " (Taxa de alfandega: " +
                String.format("%.2f", getTaxaAlfandega()) +
                ")";
    }
}
