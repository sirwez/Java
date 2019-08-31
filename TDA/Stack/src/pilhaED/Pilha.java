package pilhaED;

import javax.swing.JOptionPane;

public class Pilha<Item> {
	private Item[] stack;
	private int n;
	
	@SuppressWarnings("unchecked")
	public Pilha(int max) {
		stack = (Item[]) new Object[max];
		n = 0;
	}
	public void push(Item item) {
		
	      if (n == stack.length)
	          resize(2 * stack.length);
	       stack[n++] = item;
		
	}
    private void resize(int capacity) {
        assert capacity >n;
        @SuppressWarnings("unchecked")
		Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = this.stack[i];
        }
        this.stack = temp;
    }
	Object pop() {
	      Object item = stack[--n];
	      if (n > 0 && n == stack.length/4)
	         resize(stack.length/2);
	      return item;
	}
	boolean isEmpty() {
		return (n==0);
	}
	int size() {
		return n;
	}
	double sizePorcent() {
		
	       int total = stack.length;
	       float porcentagem=0;
		
		porcentagem= ((n * 100)/ total);
		
		return porcentagem;
	}
	void printStackBetter(Pilha<Integer> s){
		if(s.isEmpty()){
			return;
		}
		Integer item = (Integer) s.pop();
		JOptionPane.showMessageDialog(null, item); //Actually print here
		printStackBetter(s); //Recursive part
		s.push(item); //Re-add the item. If you investigate closely, you'll see that first item popped will be pushed last, as usual.
	}
}
