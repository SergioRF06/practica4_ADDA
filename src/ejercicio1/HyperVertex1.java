package ejercicio1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import us.lsi.hypergraphs.VirtualHyperVertex;

public interface HyperVertex1 extends 
	VirtualHyperVertex<HyperVertex1, HyperEdge1, Integer, List<Integer>> {
	
	Integer index();
	Set<String> cualidadesACubrir();
	Double presupRestante();
	Set<Integer> cand();

	public static HyperVertex1 start() {
		Set<String> cualidades = Datos1.getCualidades();
		Double presup = (double) Datos1.getPresupuestoMax();
		Set<Integer> candidatos = new HashSet<Integer>();
		
		return new HyperVertex1I(0, cualidades, presup, candidatos);
	}
}
