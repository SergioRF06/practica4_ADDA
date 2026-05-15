package ejercicio1;

import us.lsi.graphs.virtual.SimpleEdgeAction;

public record Edge1(Vertex1 source, Vertex1 target, Integer action, Double weight) implements SimpleEdgeAction<Vertex1, Integer> {

	public static Edge1 of(Vertex1 v1, Vertex1 v2, Integer a) {
		Double w = (double) Datos1.getValoracion(v1.index()) * a;
		return new Edge1(v1, v2, a, w);
	}
}
