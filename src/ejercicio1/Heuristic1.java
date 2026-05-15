package ejercicio1;

import java.util.function.Predicate;

public class Heuristic1 {

	/**
     * Heurística para el Ejercicio 1.
     * Estima la valoración máxima que se puede obtener desde el vértice v1 hasta el final.
     * Se basa en sumar las valoraciones de los candidatos restantes que aún no se han 
     * descartado, siempre que no superen el presupuesto máximo.
     */
	
	public static Double heuristic(Vertex1 v1, Predicate<Vertex1> goal, Vertex1 v2) {
		
		if (v1.index() >= Datos1.getNumCandidatos()) {
			return 0.;
		}
		
		Double presupuestoRestante = Datos1.getPresupuestoMax() - v1.sueldoAcumulado();
		Double valoracionEstimada = 0.;
		
		for (int i =  v1.index(); i < Datos1.getNumCandidatos(); i++) {
			if (Datos1.getSueldoMin(i) <= presupuestoRestante) {
				valoracionEstimada += Datos1.getValoracion(i);
			}
		}
		
		return valoracionEstimada;
	}
}
