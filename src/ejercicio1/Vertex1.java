package ejercicio1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import us.lsi.graphs.virtual.VirtualVertex;

public interface Vertex1 extends VirtualVertex<Vertex1, Edge1, Integer>{

		Integer index();
		Set<String> cualidades();
		Double sueldoAcumulado();
		List<Integer> elegidos();
		
		Boolean isGoal();
				
		public static Vertex1 initial() {
			return new Vertex1I(0, new HashSet<>(), 0., new ArrayList<>());
		}
}
