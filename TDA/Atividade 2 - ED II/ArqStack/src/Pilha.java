/*
Implementando operações com pilhas em Java
Criando a Classe Pilha
Implementamos as funções isEmpty, peek, push e pop
*/
public class Pilha {
   static final int MAX = 1000;
   int top;
   String[] a = new String[MAX]; // Define tamanho máximo da pilha   

   // Construtor
   Pilha() {
      top = -1;
   }

   // Métodos da pilha
   boolean isEmpty() {
     return (top < 0);
   }
   boolean push(String x) {
      if (top >= (MAX-1)) {
         System.out.println("Estouro de Pilha!");
         return false;
      }
      else {
         a[++top] = x;
         return true;
      }
   }
   String pop() {
         String x = a[top--];
         return x;
   }
}
