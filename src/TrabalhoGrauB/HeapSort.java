package TrabalhoGrauB;

public class HeapSort extends MetodosDeOrdenacao{

	public HeapSort() {
		super();
	}
	
	public int[] ordena(int lista[]) {
        int n = lista.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(lista, n, i);

        for (int i = n - 1; i >= 0; i--) {
            int temp = lista[0];
            lista[0] = lista[i];
            lista[i] = temp;

            heapify(lista, i, 0);
        }
        return lista;
    }

    void heapify(int lista[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && lista[l] > lista[largest])
            largest = l;

        if (r < n && lista[r] > lista[largest])
            largest = r;

        if (largest != i) {
            int swap = lista[i];
            lista[i] = lista[largest];
            lista[largest] = swap;

            heapify(lista, n, largest);
        }
    }
	
	public String tipoDeOrdenacao() {
		return "Heap sort";
	}
}
