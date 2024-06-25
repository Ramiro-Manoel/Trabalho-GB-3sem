package TrabalhoGrauB;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GeraListas {
	
	public static int[] CriaLista(int tipoLista, int tamanho) {
			 switch (tipoLista) {
			case 0:
				return GeraListaCrescente(tamanho);
			case 1:
				return GeraListaDecrescente(tamanho);
			case 2:
				return GeraListaAleatoriaSemRepetidos(tamanho);
			case 3:
				return GeraListaAleatoriaComRepetidos(tamanho);
			default:
				return null;
			}
	}
	
	 public static String TipoLista(int tipoLista) {
		 switch (tipoLista) {
		case 0:
			return "LISTA ORDENADA CRESCENTE";
		case 1:
			return "LISTA ORDENADA DECRESCENTE";
		case 2:
			return "LISTA ALEATÓRIA SEM REPETIDOS";
		case 3:
			return "LISTA ALEATÓRIA COM REPETIDOS";
		default:
			return null;
		}
	 }

	 private static int[] GeraListaCrescente(int tamanho) {
		 int[] lista = new int[tamanho];
		 
		 for(int i = 0 ; i < tamanho ; i++) {
			 lista[i] = i + 1;
		 }
		 
		 return lista;
	 }
	 
	private static int[] GeraListaDecrescente(int tamanho) {
		 int[] lista = new int[tamanho];
		 
		 for(int i = 0 ; i < tamanho ; i++) {
			 lista[i] = tamanho - i;
		 }
		 
		 return lista;
	 }
	 
	 private static int[] GeraListaAleatoriaSemRepetidos(int tamanho) {
		 int[] lista = new int[tamanho];
		 
		 lista = GeraListaCrescente(tamanho);
		 
			for (int i = 0; i < lista.length; i++) {
				int aux = (int) (Math.random() * tamanho);
				int temp = lista[aux];
				lista[aux] = lista[i];
				lista[i] = temp;
			}
			return lista;
	 }
	 
	 private static int[] GeraListaAleatoriaComRepetidos(int tamanho) {
		 int[] lista = new int[tamanho];
		 
		 for(int i = 0 ; i < tamanho ; i++) {
			 lista[i] = (int) (Math.random() * (tamanho / 2)) + 1;
		 }
		 
		 return lista;
	 }
	 
}
