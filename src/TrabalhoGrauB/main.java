package TrabalhoGrauB;

import java.util.Scanner;

public class main {

	 public static void main(String[] args) {
		
		 MetodosDeOrdenacao[] listaOrdenadores = new MetodosDeOrdenacao[7];
		 long tempo;
		 int[] lista;
		 int[] listaDesordenada;
		 int tamanho;
		 int tipoLista;
		 
		 Scanner sc = new Scanner(System.in);
		 listaOrdenadores[0] = new BubbleSort();
		 listaOrdenadores[1] = new InsertionSort();
		 listaOrdenadores[2] = new SelectionSort();
		 listaOrdenadores[3] = new HeapSort();
		 listaOrdenadores[4] = new ShellSort();
		 listaOrdenadores[5] = new MergeSort();
		 listaOrdenadores[6] = new QuickSort();
			 
			 System.out.println("Digite o tamanho do array: ");
			 tamanho = sc.nextInt();
			 System.out.println("Digite o tipo do array: ");
			 tipoLista = sc.nextInt();
			 
			 System.out.println(GeraListas.TipoLista(tipoLista));

				 //10 listas diferentes
				 for(int j = 0 ; j < 10 ; j ++) {
					 					
					 lista = GeraListas.CriaLista(tipoLista, tamanho);
					 
					 //7 tipos de ordenacao
					 for(int k = 0 ; k < listaOrdenadores.length ; k++) {	
							 listaDesordenada = copiaArray(lista);
							 tempo = CronometraOrdenacao(listaOrdenadores[k], listaDesordenada);
							 listaOrdenadores[k].adicionaTempo(tempo, j);
						 }					 
				 }
				 
				 //exibe todas as ordenacoes
				 for(int j = 0 ; j < listaOrdenadores.length ; j ++) {					 
					 listaOrdenadores[j].calculaValores();
					 System.out.println(listaOrdenadores[j].exibeInfos());
					 listaOrdenadores[j].zeraTempos();
				 }
			 }
	 
	
	 public static long CronometraOrdenacao(MetodosDeOrdenacao metodoDeOrdenacao, int[] listaDesordenada) {
		 long tempoInicial = System.currentTimeMillis();
		 metodoDeOrdenacao.ordena(listaDesordenada);
		 return System.currentTimeMillis() - tempoInicial;
	 }
	 
	public static int[] copiaArray(int[] lista) {
		int[] result = new int[lista.length]; 
		for(int i = 0 ; i < lista.length ; i++) {
			result[i] = lista[i];
		}
		return result;
	}
	
}
