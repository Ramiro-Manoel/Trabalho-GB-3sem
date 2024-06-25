package TrabalhoGrauB;

public class main {

	 public static void main(String[] args) {
		
		 MetodosDeOrdenacao[] listaOrdenadores = new MetodosDeOrdenacao[7];
		 long tempo;
		 int[] lista = null;
		 int[] listaDesordenada = null;
		 
		 listaOrdenadores[0] = new BubbleSort();
		 listaOrdenadores[1] = new InsetionSort();
		 listaOrdenadores[2] = new SelectionSort();
		 listaOrdenadores[3] = new HeapSort();
		 listaOrdenadores[4] = new ShellSort();
		 listaOrdenadores[5] = new MergeSort();
		 listaOrdenadores[6] = new QuickSort();
		 
		 for(int tamanho = 9999 ; tamanho <= 65536;) {
			 
			 System.out.println("\nTAMANHO DO ARRAY: " + tamanho);
			 
			 for(int i = 0 ; i < 4 ; i ++) {
				 
				 System.out.println("\n" + GeraListas.TipoLista(i) + "\n");
				 
				 for(int j = 0 ; j < 10 ; j ++) {
					 
					 lista = GeraListas.CriaLista(i, tamanho);
					 
						 for(int k = 0 ; k < listaOrdenadores.length ; k++) {	
							 listaDesordenada = lista;
							 tempo = CronometraOrdenacao(listaOrdenadores[k], listaDesordenada);
							 listaOrdenadores[k].adicionaTempo(tempo);
						 }					 
				 }
				 
				 for(int j = 0 ; j < listaOrdenadores.length ; j ++) {					 
					 listaOrdenadores[j].calculaValores();
					 System.out.println(listaOrdenadores[j].exibeInfos());
					 listaOrdenadores[j].zeraTempos();
				 }
			 }
			 tamanho = tamanho * 2;
		}
	 }
	
	 public static long CronometraOrdenacao(MetodosDeOrdenacao metodoDeOrdenacao, int[] lista) {
		 long tempoInicial = System.currentTimeMillis();
		 metodoDeOrdenacao.ordena(lista);
		 return System.currentTimeMillis() - tempoInicial;
	 }
	
}
