package Core.Selection;

import java.util.Random;

import Gen.Cromosoma;

public class Torneo extends Seleccion {
	private static final double P = 0.75;
	
	public Torneo(int func, int tipo) {
		super(func);
		this.tipo = tipo;
	}

	public Torneo() {
		// TODO Auto-generated constructor stub
	}

	public Cromosoma[] selecciona(Cromosoma[] poblacion, int tamPob) {
		Cromosoma subpoblacion[] =  new Cromosoma[2];
		Cromosoma poblacionAux[] = new Cromosoma[tamPob];
		Random rnd = new Random();
		int posElegida;
		double prob;
		
		for(int j = 0; j < tamPob; j++){
			
			for(int i = 0; i < 2; i++){ //Seleccionamos 2 individuos al azar
				posElegida = (int) (rnd.nextDouble() * tamPob);
				subpoblacion[i] = poblacion[posElegida].copia();
			}
			
			if(tipo == 2){
				poblacionAux[j] = getMejorSubpoblacion(subpoblacion);
			}else{
				prob = rnd.nextDouble();
				if(prob > P){
					poblacionAux[j] = getMejorSubpoblacion(subpoblacion);
				}else{
					poblacionAux[j] = getMenorSubpoblacion(subpoblacion);
				}
			}
		}
		
		for(int i = 0; i < tamPob; i++){
			poblacion[i] = poblacionAux[i].copia();
		}
		return poblacion;

	}
	
	private Cromosoma getMenorSubpoblacion(Cromosoma[] subpoblacion) {
		if(subpoblacion[0].getFitness() < subpoblacion[1].getFitness()){
			return subpoblacion[0];
		}
		else{
			return subpoblacion[1];
		}
	}

	private Cromosoma getMejorSubpoblacion(Cromosoma[] subpoblacion) {
		if(subpoblacion[0].getFitness() > subpoblacion[1].getFitness()){
			return subpoblacion[0];
		}
		else{
			return subpoblacion[1];
		}
	}

}