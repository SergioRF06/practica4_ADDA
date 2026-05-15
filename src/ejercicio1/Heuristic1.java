package ejercicio1;

import java.util.function.Predicate;

public class Heuristic1 {

	public static Double heuristic(Vertex1 v1, Predicate<Vertex1> goal, Vertex1 v2) {
		
		if (v1.index() == Datos1.getNumCandidatos()) {
			return 0.;
		}
		
		Double valoracionAprox = 0.;
		
		for (int i = v1.index(); i < Datos1.getNumCandidatos(); i++) {
			valoracionAprox += Datos1.getValoracion(i);
		}
		
		return valoracionAprox;
	}
	 
}
