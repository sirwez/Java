package mergeSort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MergerSort {
	private static BufferedReader reader;
	private static Scanner entrada;

	public static void main(String[] args) throws IOException {
	    int tamanho = 0;






	    
	    entrada = new Scanner(System.in);

	    
	    while (true) {
	      System.out.println("[1] Arquivo com 100 nomes\n[2] Arquivo com 1000 nomes\n[3] Arquivo com 10000 nomes\n[4] Sair\n");
	      int n = entrada.nextInt();
	      switch (n) {
	        case 1:
	          tamanho = 100;
	          break;
	        case 2:
	          tamanho = 1000;
	          break;
	        case 3:
	          tamanho = 10000;
	          break;
	        case 4:
	          return;
	        default:
	          System.out.println("Opcao invalida.");
	          continue;
	      } 
	      String path = "nomes" + tamanho + ".txt";
	      File arq = new File(path);
	      ListaEstatica L = new ListaEstatica(tamanho);
	      
	      if (arq.exists()) {
	        
	        FileReader ler = new FileReader(path);
	        reader = new BufferedReader(ler); String linha;
	        while ((linha = reader.readLine()) != null)
	          L.inserirLista(linha); 
	        System.out.println("NOMES LIDOS DO ARQUIVO:");
	        imprimeLista(L.getLista());
	        long tempo = L.mergeSort(L.getLista(), tamanho);
	        System.out.println("NOMES ORDENADOS:");
	        imprimeLista(L.getLista());
	        System.out.println("TEMPO GASTO: " + tempo + "ns\n");
	        System.out.println("COMPARACOES: " + L.getC());
	        continue;
	      } 
	      System.out.println("Arquivo nao existe.");
	    } 
	  }
	  
	  public static void imprimeLista(String[] lista) throws IOException {
	    for (int i = 0; i < lista.length; i++) {
	      System.out.println(lista[i]);
	    }
	    System.out.println("");
	  }
}
