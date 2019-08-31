package quickSort;

public class ListaEstatica {
	 private String[] lista;
	  private static int index;
	  private int c;
	  
	  public ListaEstatica(int n) {
	    this.lista = new String[n];
	    index = 0;
	    this.c = 0;
	  }

	  
	  public void inserirLista(String nova) { this.lista[index++] = nova; }


	  
	  public String[] getLista() { return this.lista; }

	  
	  public long ordenarPorQuick(String[] arr, int low, int high) {
	    long tempoInicio = System.nanoTime();
	    
	    if (low < high) {
	      
	      int pi = partition(arr, low, high);
	      
	      ordenarPorQuick(arr, low, pi - 1);
	      ordenarPorQuick(arr, pi + 1, high);
	    } 
	    return System.nanoTime() - tempoInicio;
	  }

	  
	  int partition(String[] arr, int low, int high) {
	    String pivot = arr[high];
	    int i = low - 1;
	    for (int j = low; j < high; j++) {


	      
	      if (this.lista[j].compareTo(pivot) < 0) {
	        
	        i++;
	        this.c++;
	        
	        String temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	      } 
	    } 

	    
	    String temp = arr[i + 1];
	    arr[i + 1] = arr[high];
	    arr[high] = temp;
	    
	    return i + 1;
	  }

	  
	  public int getC() { return this.c; }
}
