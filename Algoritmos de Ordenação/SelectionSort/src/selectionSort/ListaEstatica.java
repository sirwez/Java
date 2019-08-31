package selectionSort;

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

	  public long ordenaSelectionSort()
	  {
		  long tempoInicio = System.nanoTime();


	    for ( int j=0; j < this.lista.length-1; j++ )
	    {
	      int min = j;
	      for ( int k=j+1; k < this.lista.length; k++ ) {
	        if ( this.lista[k].compareTo( this.lista[min] ) < 0 )
	        	{
	        	min = k;  
		          this.c++;
	        	}
	      }
	      String temp = this.lista[j];
	      this.lista[j] = this.lista[min];
	      this.lista[min] = temp;
	    }
	    
      return System.nanoTime() - tempoInicio;
	  }

	  public int getC() 
	  { 
		  return this.c; 
		  }
}
