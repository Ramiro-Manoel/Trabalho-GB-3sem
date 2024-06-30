package TrabalhoGrauB;

public class SelectionSort extends MetodosDeOrdenacao{

    public SelectionSort() {

        super();
    }

    public int[] ordena(int[] lista) {
        for (int fixo = 0; fixo < lista.length - 1; fixo++) {
            int menor = fixo;

            for (int i = menor + 1; i < lista.length; i++) {
               if (lista[i] < lista[menor]) {
                  menor = i;
               }
            }
            if (menor != fixo) {
              int t = lista[fixo];
              lista[fixo] = lista[menor];
              lista[menor] = t;
            }
          }
        return lista;
    }

    public String tipoDeOrdenacao() {
        return "Selection sort";
    }
}
