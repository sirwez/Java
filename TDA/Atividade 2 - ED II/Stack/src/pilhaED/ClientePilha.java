package pilhaED;

import javax.swing.JOptionPane;

public class ClientePilha {

	private static Pilha<Integer> pilha;
	private static final int MAX = 10;

	public static void main(String[] args) {
		
		pilha = new Pilha<Integer>(MAX);
		
		while(true) {
			int opcao = Integer.parseInt(
					JOptionPane.showInputDialog("Escolha uma das opcoes:"
					+"\n1 - Empilhar\n2 - Desempilhar"
					+"\n3 - Listar\n4-Porcentagem\n"
					+ "0 - Sair")
					);
			switch(opcao) {
				case 1: empilhar(); break;
				case 2: desempilhar(); break;
				case 3: listar(); break;
				case 4: porcentagem();break;
				default: return;
			}
		}
	}

	private static void porcentagem() {
		JOptionPane.showMessageDialog(null,"PORCENTAGEM DE OCUPAÇÃO: "+ pilha.sizePorcent()+"%\n"
	                                                 +"TAMANHO: "+ pilha.size());
	}

	private static void empilhar() {
		int item = Integer.parseInt(JOptionPane.showInputDialog("Item a ser inserido: "));
		pilha.push(item);
	}

	private static void desempilhar() {
		if(pilha.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Pilha vazia");
		}else {
			int item = (int) pilha.pop();
			JOptionPane.showMessageDialog(null,"Item \""+item+"\" removido");
		}
	}

	private static void listar() {
		if(!pilha.isEmpty()) {
		JOptionPane.showMessageDialog(null, "Um elemento por vez");
		pilha.printStackBetter(pilha);
		}
		else {JOptionPane.showMessageDialog(null, "VAZIO");}

		}
}
