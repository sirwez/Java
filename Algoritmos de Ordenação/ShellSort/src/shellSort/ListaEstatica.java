package shellSort;

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

	  public long ordenaShellSort()
	  {
		  long tempoInicio = System.nanoTime();


	        for( int gap = this.lista.length / 2; gap > 0; gap = gap == 2 ? 1 : (int) ( gap / 2.2 ) )
           for( int i = gap; i < this.lista.length; i++ )
           {
               Comparable<String> tmp = this.lista[ i ];
               int j = i;

               for( ; j >= gap && tmp.compareTo( this.lista[ j - gap ] ) < 0; j -= gap ) {
            	   this.lista[ j ] = this.lista[ j - gap ];
     	          this.c++;
               }
               this.lista[ j ] = (String) tmp;
           }
	    
      return System.nanoTime() - tempoInicio;
	  }

	  public int getC() 
	  { 
		  return this.c; 
		  }
}
