package br.com.alura;

import br.com.alura.model.Produto;
import br.com.alura.service.TraduzProdutoService;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        CsvToBean<Produto> csvToBean = new CsvToBeanBuilder<Produto>(new FileReader("src/main/resources/products.csv"))
                                           .withType(Produto.class)
                                           .build();
        List<Produto> produtos = csvToBean.parse();

        for (Produto produto: produtos){
            System.out.println(produto);
        }

        TraduzProdutoService traduzProdutoService = new TraduzProdutoService();

        for (Produto produto: produtos){
            traduzProdutoService.traduzir(produto);
            System.out.println(produto);
        }
    }
}