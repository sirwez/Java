package insertionSort;

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


	  
	  public String[] getLista() 
	  { 
		  return this.lista; 
		  }

	  public long ordenaInsertionSort() {
		  long tempoInicio = System.nanoTime();
		        int i,j;  String x;
		        for (j = 1; j < this.lista.length; j++) {       
		            x = this.lista[j]; i = j - 1;

		            while (i >= 0) {
		                if (x.compareTo(this.lista[i]) > 0) {
		      	          this.c++;
		                    break;
		                }
		                this.lista[i + 1] = this.lista[i];
		                i--;
		            }
		            this.lista[i + 1] = x;
		        }
		        return System.nanoTime() - tempoInicio;
		}


	  public int getC() 
	  { 
		  return this.c; 
		  }
}
