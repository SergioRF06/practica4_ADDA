package ejercicio1;

import java.util.List;

import us.lsi.hypergraphs.SimpleHyperEdge;

public record HyperEdge1(HyperVertex1 source, List<HyperVertex1> targets, Integer action) implements SimpleHyperEdge<HyperVertex1, HyperEdge1, Integer> {
	
	public static HyperEdge1 of (HyperVertex1 source, List<HyperVertex1> targets, Integer action) {
		return new HyperEdge1(source, targets, action);
	}

	@Override
	public Double weight(List<Double> targetsWeight) {
		// TODO Auto-generated method stub
		Double valoracionActual = (this.action == 1) ? (double) Datos1.getValoracion(this.source.index()) : 0.0;
		return targetsWeight.get(0) + valoracionActual;
	}

}
