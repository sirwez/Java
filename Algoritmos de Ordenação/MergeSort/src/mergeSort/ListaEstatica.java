package mergeSort;

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



	  
	  public void merge(String[] a, String[] l, String[] r, int left, int right) {
	    int i = 0, j = 0, k = 0;
	    while (i < left && j < right) {
	      if (l[i].compareTo(r[j]) < 0) {
	        this.c++;
	        a[k++] = l[i++];
	        continue;
	      } 
	      a[k++] = r[j++];
	    } 
	    
	    while (i < left) {
	      a[k++] = l[i++];
	    }
	    while (j < right) {
	      a[k++] = r[j++];
	    }
	  }

	  
	  public long mergeSort(String[] a, int n) {
	    long tempoInicio = System.nanoTime();
	    
	    if (n < 2) {
	      return 0L;
	    }
	    int mid = n / 2;
	    String[] l = new String[mid];
	    String[] r = new String[n - mid];
	    
	    for (int i = 0; i < mid; i++) {
	      l[i] = a[i];
	    }
	    for (int i = mid; i < n; i++) {
	      r[i - mid] = a[i];
	    }
	    mergeSort(l, mid);
	    mergeSort(r, n - mid);
	    
	    merge(a, l, r, mid, n - mid);
	    
	    return System.nanoTime() - tempoInicio;
	  }

	  
	  public int getC() { return this.c; }
}
