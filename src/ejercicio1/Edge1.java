package ejercicio1;

import us.lsi.graphs.virtual.SimpleEdgeAction;

public record Edge1(Vertex1 source, Vertex1 target, Integer action, Double weight) 
			implements SimpleEdgeAction<Vertex1, Integer> {

	public static Edge1 of(Vertex1 s, Vertex1 t, Integer a) {
		Double w = (a == 1) ? (double) Datos1.getValoracion(s.index()) : 0.;
		return new Edge1(s, t, a, w);
	}
}
