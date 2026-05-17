package ejercicio2;

import java.util.ArrayList;
import java.util.List;

public record Vertex2I(Integer index, List<Integer> capRestante) implements Vertex2 {

	@Override
	public List<Integer> actions() {
		// TODO Auto-generated method stub
		List<Integer> actions = new ArrayList<>();
		
		if (index < numElementos()) {
			actions.add(numContenedores());
			Integer tamActual = Datos2.getTamElemento(index);
			
			for (int i = 0; i < numContenedores(); i++) {
				if (Datos2.getPuedeUbicarse(index, i) && capRestante.get(i) >= tamActual) {
					actions.add(i);
				}
			}
		}
		
		return actions;
	}

	@Override
	public Vertex2 neighbor(Integer a) {
		// TODO Auto-generated method stub
		List<Integer> nuevoCapRestante = new ArrayList<>(capRestante);

		if (a < numContenedores()) {
			nuevoCapRestante.set(a, capRestante.get(a) - Datos2.getTamElemento(index));
		}
		
		return new Vertex2I(index + 1, nuevoCapRestante);
	}

	@Override
	public Edge2 edge(Integer a) {
		// TODO Auto-generated method stub
		return Edge2.of(this, this.neighbor(a), a);
	}

	@Override
	public Boolean goal() {
		// TODO Auto-generated method stub
		return index == numElementos();
	}	
	
	

	public static Integer numContenedores() {
		return Datos2.getNumContenedores();
	}
	
	public static Integer numElementos() {
		return Datos2.getNumElementos();
	}
}
