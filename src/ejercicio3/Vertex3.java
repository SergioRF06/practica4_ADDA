package ejercicio3;

import java.util.ArrayList;
import java.util.List;

import us.lsi.graphs.virtual.VirtualVertex;

public interface Vertex3 extends VirtualVertex<Vertex3, Edge3, Integer> {

	Integer index();
	List<Integer> camino();
	Double durAcumulada();
	
	Boolean goal();
	
	public static Vertex3 start() {
		List<Integer> camino = new ArrayList<>();	
		camino.add(0);
		
		return new Vertex3I(0, camino, 0., false);
	}
}
