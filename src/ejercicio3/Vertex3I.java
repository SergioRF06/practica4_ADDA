package ejercicio3;

import java.util.ArrayList;
import java.util.List;

public record Vertex3I(Integer index, List<Integer> camino, Double durAcumulada, Boolean monumentosConsecutivos) implements Vertex3 {

	@Override
	public List<Integer> actions() {
		// TODO Auto-generated method stub
		List<Integer> actions = new ArrayList<>();
		Integer actual = camino.getLast();
		
		if (this.camino.size() == Datos3.N) {
			if (Datos3.tiempo(actual, 0) < 1000.) {
				if (this.durAcumulada + Datos3.tiempo(actual, 0) <= Datos3.maxTime) {
					actions.add(0);
				}
			}
			
			return actions;
		}
		
		for (int i = 0; i < Datos3.N; i++) {
			if (actual == i) continue;
			
			if (Datos3.tiempo(actual, i) < 1000.) {
				if (!camino.contains(i)) {
					if (durAcumulada + Datos3.tiempo(actual, i) <= 1000.) {
						actions.add(i);
					}
				}
			}
		}
		
		return actions;
	}

	@Override
	public Vertex3 neighbor(Integer a) {
		// TODO Auto-generated method stub
		Integer actual = camino.getLast();
		
		List<Integer> nuevoCamino = new ArrayList<Integer>(camino);
		nuevoCamino.add(a);
		Double nuevaDurAcumulada = durAcumulada + Datos3.esfuerzo(actual, a);
		Boolean nuevoMonumentosConsecutivos = monumentosConsecutivos || Datos3.sonMonumentos(actual, a);
		
		return new Vertex3I(index + 1, nuevoCamino, nuevaDurAcumulada, nuevoMonumentosConsecutivos);
	}

	@Override
	public Edge3 edge(Integer a) {
		// TODO Auto-generated method stub
		return Edge3.of(this, this.neighbor(a), a);
	}

	@Override
	public Boolean goal() {
		// TODO Auto-generated method stub
		return index == Datos3.N && monumentosConsecutivos && durAcumulada < 0.75*Datos3.maxTime;
	}

}
