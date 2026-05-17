package ejercicio2;

import java.util.ArrayList;
import java.util.List;

import us.lsi.graphs.virtual.VirtualVertex;

public interface Vertex2 extends VirtualVertex<Vertex2, Edge2, Integer> {

	Integer index();
	List<Integer> capRestante();
	
	Boolean goal();
	
	public static Vertex2 start() {
		List<Integer> capRestante = new ArrayList<>();
		for (int i = 0; i < Datos2.getNumContenedores(); i++) {
			capRestante.add(Datos2.getTamContenedor(i));
		}
		return new Vertex2I(0, capRestante);
	}
}
