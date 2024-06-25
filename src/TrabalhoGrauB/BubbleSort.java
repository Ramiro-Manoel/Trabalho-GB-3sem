package TrabalhoGrauB;

public class BubbleSort extends MetodosDeOrdenacao{

	public BubbleSort() {
		super();
	}
	
	public int[] ordena(int[] lista) {
		boolean troca = true;
		int aux;
		while(troca) {
			troca = false;
			for(int i = 0; i<lista.length - 1; i++) {
				if(lista[i] > lista[i+1]) {
					aux = lista[i];
					lista[i] = lista[i+1];
					lista[i+1] = aux;
					troca = true;
				}
			}
		}
		return lista;
	}
	
	public String tipoDeOrdenacao() {
		return "Bubble sort";
	}
}
