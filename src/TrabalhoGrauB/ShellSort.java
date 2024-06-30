package TrabalhoGrauB;

public class ShellSort extends MetodosDeOrdenacao{
	
	public ShellSort() {
		super();
	}

	public int[] ordena(int lista[]) {
        int n = lista.length;
        for (int gap = n/2; gap > 0; gap /= 2)
        {

            for (int i = gap; i < n; i += 1)
            {
                int temp = lista[i];
                int j;
                for (j = i; j >= gap && lista[j - gap] > temp; j -= gap)
                lista[j] = lista[j - gap];
                lista[j] = temp;
            }
        }
        return lista;
    }
	
	public String tipoDeOrdenacao() {
		return "Shell sort";
	}
}
