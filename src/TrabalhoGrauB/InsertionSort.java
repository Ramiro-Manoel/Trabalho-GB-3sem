package TrabalhoGrauB;

public class InsertionSort extends MetodosDeOrdenacao{

    public InsertionSort() {
        super();
    }

    public int[] ordena(int[] lista) {
        int j;
        int aux;
        int i;

        for(j = 1; j < lista.length; j++) {
            aux = lista[j];
            for(i=j-1; (i >= 0) && (lista[i] > aux); i--) {
                lista[i+1] = lista[i];
            }
            lista[i+1] = aux;
        }
        return lista;
    }

    public String tipoDeOrdenacao() {
        return "Insertion sort";
    }
}