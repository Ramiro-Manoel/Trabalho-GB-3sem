package TrabalhoGrauB;

public class MergeSort extends MetodosDeOrdenacao{

	public MergeSort() {
		super();
	}
	
	public int[] ordena(int[] lista) {
		mergeSort(lista, lista.length);;
		return lista;
	}

	public void mergeSort(int[] lista, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = lista[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = lista[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);
        merge(lista, l, r, mid, n - mid);

    }

    private void merge(int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
	
	public String tipoDeOrdenacao() {
		return "Merge sort";
	}
	
}
