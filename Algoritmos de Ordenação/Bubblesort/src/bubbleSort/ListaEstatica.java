package bubbleSort;

public class ListaEstatica {
	private String[] lista;
	  private static int index;
	  private int c;
	  
	  public ListaEstatica(int n) {
	    this.lista = new String[n];
	    index = 0;
	    this.c = 0;
	  }

	  
	  public void inserirLista(String nova) { 
		  this.lista[index++] = nova; }


	  
	  public String[] getLista() { return this.lista; }

	  
	  public long ordenarPorBolha() {
	    long tempoInicio = System.nanoTime();
	    
	    for (int i = 0; i < this.lista.length - 1; i++) {
	      for (int j = 0; j < this.lista.length - i - 1; j++) {
	        
	        if (this.lista[j].compareTo(this.lista[j + 1]) > 0) {
	          troca(j);
	          this.c++;
	        } 
	      } 
	    } 
	    
	    return System.nanoTime() - tempoInicio;
	  }
	  
	  private void troca(int i) {
	    String temp = this.lista[i];
	    this.lista[i] = this.lista[i + 1];
	    this.lista[i + 1] = temp;
	  }

	  
	  public int getC() { 
		  return this.c; }
}
