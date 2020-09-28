/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramaMercearia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabri
 */
public class FakeBD {
    //definido um vetor de produtos
    private static Vector<Produto> produtos;
    
    //carregando os itens do nosso banco de dados falso
    private static void carga() {
        
        //inicializando o vetor
        if (produtos == null) {
            produtos = new Vector<>();
        } else {
            produtos.clear();
        }
        
        //caminho do arquivo com nossos produtos
        File arqCsv = new File("C:\\Users\\gabri\\Documents\\produtos.csv");
        
        try {
            //marcando a leitura do arquivo
            FileReader marcaLeitura = new FileReader(arqCsv);
            
            //utlizando o buffer reader pra ler os arquvivos do armazenamento interno pra memória RAM
            BufferedReader bufferLeitura = new BufferedReader(marcaLeitura);   
            
            
            String linha = "";
            //lendo a primeira linha do cabeçalho
            bufferLeitura.readLine();
            
            //lendo a primeira linha dos produtos pra entrar no while
            linha = bufferLeitura.readLine();
            while (linha != null) {
                //usando um array de string pra amarzenar as informações separadas por ';'
                String infos[] = linha.split(";");
                
                //armazenando o código e a quantidade do item lido
                int cod = Integer.parseInt(infos[0]), quant = Integer.parseInt(infos[3]);
                
                //armazenando o nome do item
                String nome = infos[1];
                
                //armazenando o preço do item
                double preco = Double.parseDouble(infos[2]);
                
                //adicionando um produto com os dados lidos
                produtos.add(new Produto(cod, quant, nome, preco));
                linha = bufferLeitura.readLine();
            }
            //fechando o buffer de leitura
            bufferLeitura.close();
        } catch (FileNotFoundException ex) {
            System.err.println("Arquivo verificado não existe");
        } catch (IOException e) {
            System.err.println("Arquivo corrompido");
        }
        
    }
    
    //função de verificação de produto por código
    public static Produto consultaProdutoCod(int cod) {
        if (produtos == null) {
            carga();
        }
        
        //varrendo o vetor de produtos
        for (Produto prodI : produtos) {
            if (prodI.getCod() == cod) {
                return prodI;
            }
        }
        return null;
    }
    
    //atualizando o arquivo no final
    public static void atualizaArquivo() {
        File arquivo = new File("C:\\Users\\gabri\\Documents\\produtos.csv");
        try {
            //usando o fileWriter pra editar o arquivo
            FileWriter escrita = new FileWriter(arquivo);
            BufferedWriter bufEscrita = new BufferedWriter(escrita);
            
            //escrevendo o toStringo do produto no arquvio e quebrando uma linha depois
            for (Produto i : produtos) {
                bufEscrita.write(i + "\n");
            }
            
            //limpando e fechando o buffer de escrita
            bufEscrita.flush();
            bufEscrita.close();
            
        } catch (IOException ex) {
            System.err.println("dispositivo com falha");
        }
        
    }
}
