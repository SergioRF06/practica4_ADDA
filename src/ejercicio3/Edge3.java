package ejercicio3;

import us.lsi.graphs.virtual.SimpleEdgeAction;

public record Edge3(Vertex3 source, Vertex3 target, Integer action, Double weight) implements SimpleEdgeAction<Vertex3, Integer> {
	
	public static Edge3 of(Vertex3 v1, Vertex3 v2, Integer a) {
		Double w = Datos3.esfuerzo(v1.index(), v2.index());
		return new Edge3(v1, v2, a, w);
	}

}
