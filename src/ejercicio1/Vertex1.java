package ejercicio1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import us.lsi.graphs.virtual.VirtualVertex;

public interface Vertex1 extends VirtualVertex<Vertex1, Edge1, Integer> {
	
	Integer index();
	Double presupuestoRestante();
	Set<String> cualidadesRestantes();
	List<Integer> elegidos();
	
	Boolean goal();
	
	public static Vertex1 start() {
		Set<String> cualidadesRestantes = new HashSet<>(Datos1.getCualidades());
		List<Integer> elegidos = new ArrayList<>();
		return new Vertex1I(0, (double) Datos1.getPresupuestoMax(), cualidadesRestantes, elegidos);
	}
}
