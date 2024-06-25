package TrabalhoGrauB;

import java.util.Iterator;

public abstract class MetodosDeOrdenacao {

	private long[] tempos = new long[10];
	private double tempoMedia;
	private double tempoVariancia;
	private double tempoDesvioPadrao;
	private double tempoMediaDentroIntervalo;

	public MetodosDeOrdenacao() {
		super();
	}

	public abstract String tipoDeOrdenacao();

	public abstract int[] ordena(int[] lista);

	public long[] getTempo() {
		return tempos;
	}

	public void adicionaTempo(long tempo) {
		for (int i = 0; i < 10; i++) {
			if (tempos[i] == 0) {
				tempos[i] = tempo;
			}
		}
	}
	
	public void calculaValores() {
		calulaMedia();
		calulaVariancia();
		calulaDesvioPadrao();
		calulaMediaDentroIntervalo();
	}
	
	public String exibeInfos() {
		return tipoDeOrdenacao() + " | média: " + tempoMedia + " | variancia: " + tempoVariancia + " | desvio padrão: " + tempoDesvioPadrao  + " | média no intervalo do desvio padrão: " + tempoMediaDentroIntervalo ; 
	}

	public void zeraTempos() {
		for (int i = 0; i < 10; i++) {
			tempos[i] = 0;
		}
	}

	private double calulaMedia() {
		long somaTempos = 0;
		for (int i = 0; i < 10; i++) {
			somaTempos = somaTempos + tempos[i];
		}
		this.tempoMedia = somaTempos / 10;
		return tempoMedia;
	}

	private double calulaVariancia() {
		double somaTemposMenosMediaQuadrado = 0;
		double tempoMenosMedia = 0;
		for (int i = 0; i < 10; i++) {
			tempoMenosMedia = tempos[i] - tempoMedia;
			somaTemposMenosMediaQuadrado = somaTemposMenosMediaQuadrado + Math.sqrt(tempoMenosMedia);
		}
		this.tempoVariancia = somaTemposMenosMediaQuadrado / 9;
		return tempoVariancia;
	}
	
	private double calulaDesvioPadrao() {
		this.tempoDesvioPadrao = Math.sqrt(tempoVariancia);
		return tempoDesvioPadrao;
	}
	
	private double calulaMediaDentroIntervalo() {
		double intervaloSuperior = tempoMedia + tempoDesvioPadrao;
		double intervaloInferior = tempoMedia - tempoDesvioPadrao;
		double somaTempos = 0;
		int contador = 0;
		
		for (int i = 0; i < 10; i++) {
			if(tempos[i] < intervaloSuperior && tempos[i] > intervaloInferior) {
				somaTempos = somaTempos + tempos[i];
				contador++;
			}
		}
		this.tempoMediaDentroIntervalo = somaTempos / contador;
		return tempoMediaDentroIntervalo;
	}

}
