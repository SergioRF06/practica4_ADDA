package ejercicio3;

import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Heuristic3 {

	public static Double heuristic(Vertex3 v1, Predicate<Vertex3> goal, Vertex3 v2) {
		if (goal.test(v1)) return 0.;
		
		Double esfuerzoEstimado = esfuerzoMin(v1.index(), v1);
		
		esfuerzoEstimado += IntStream.range(0, Datos3.N)
								.filter(i -> !v1.camino().contains(i))
								.mapToDouble(i -> esfuerzoMin(i, v1))
								.sum();
		
		return esfuerzoEstimado;
	}
	
	private static Double esfuerzoMin(Integer origen, Vertex3 v) {
		return IntStream.range(0, Datos3.N)
						.filter(destino -> origen != destino)
						.filter(destino -> destino == 0 || !v.camino().contains(destino))
						.mapToDouble(destino -> Datos3.esfuerzo(origen, destino))
						.min()
						.orElse(0.);
	}
}
