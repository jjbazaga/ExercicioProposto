import Model.Produto;
import Model.ProdutoImportado;
import Model.ProdutoUsado;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        List<Produto> lista = new ArrayList<>();

        System.out.print("Entre com o número de produtos: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Dados do produto nº " + (i + 1) + ":");
            System.out.print("Comum, usado ou importado (c/u/i)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Nome: ");
            sc.nextLine();
            String nome = sc.nextLine();
            System.out.print("Preço: ");
            Double preco = sc.nextDouble();
            if(ch == 'i'){
                System.out.print("Valor da taxa de importação: ");
                double taxa = sc.nextDouble();
                Produto produto = new ProdutoImportado(nome, preco, taxa);
                lista.add(produto);
            } else if (ch == 'u') {
                System.out.print("Data de fabricação (DD/MM/YYYY): ");
                String dataFabricacao = sc.next();
                LocalDate data = LocalDate.parse(dataFabricacao, dtf);
                Produto produto = new ProdutoUsado(nome, preco, data);
                lista.add(produto);
            } else if (ch == 'c') {
                Produto produto = new Produto(nome, preco);
                lista.add(produto);
            }
        }
        for(Produto obj: lista){
            System.out.println(obj);
        }
        sc.close();
    }
}