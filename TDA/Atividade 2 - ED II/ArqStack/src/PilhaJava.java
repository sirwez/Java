// Código do main
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class PilhaJava {

	private static BufferedReader reader;
	private static Pilha novaPilha;
public static void main(String args[]) throws IOException {
      novaPilha = new Pilha();
      
      System.out.println("Entre com um número:");

      String path = "nomes100.txt";
      File arq = new File(path);


     // String aba = null;
	 // novaPilha.push(aba);
      if (arq.exists()) {
	        
	        FileReader ler = new FileReader(path);
	        reader = new BufferedReader(ler); 
	        String linha;
	        while ((linha = reader.readLine()) != null)
	          novaPilha.push(linha); 
	      }
		while(true) {
			int opcao = Integer.parseInt(
					JOptionPane.showInputDialog("\n1 - Listar\n0 - Sair")
					);
			
//			int opcao = StdIn.readInt();
			switch(opcao) {

				case 1: 
					int num = Integer.parseInt(
							JOptionPane.showInputDialog("Digite as K linhas que deseja imprimir\n")
							);
					listar(num); break;				
				default: return;
			}
		}
   }
private static void listar(int num) {
	StdOut.print("Ordem: Do ultimo ao K digitado: ");
	Pilha auxiliar = new Pilha();
	int i=0;
	int cont =1;
	while(!novaPilha.isEmpty()) {
		String item = (String) novaPilha.pop();
		if(i<num) {
		StdOut.print("\n"+cont+"-Linha"+":"+item + "\n");
		cont++;
		}
		i++;
		auxiliar.push(item);
	}
			 
	while(!auxiliar.isEmpty()) {
		String item = (String) auxiliar.pop();
		novaPilha.push(item);
	}
}
}