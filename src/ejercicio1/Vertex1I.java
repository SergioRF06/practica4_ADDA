package ejercicio1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record Vertex1I(Integer index, Double presupuestoRestante, Set<String> cualidadesRestantes, List<Integer> elegidos) implements Vertex1 {
	
	@Override
	public List<Integer> actions() {
		// TODO Auto-generated method stub
		List<Integer> actions = new ArrayList<>();
		       
		if (index < (double) Datos1.getNumCandidatos()) {
			actions.add(0);
			Double sueldoActual = (double) Datos1.getSueldoMin(index);
			Boolean compatible = true;
			
			for (int i = 0; i < elegidos.size(); i++) {
				if (elegidos.get(i) == 1) {
					if (Datos1.getSonIncompatibles(index, i) || Datos1.getSonIncompatibles(i, index)) {
			            compatible = false;
			            break; // Ya sabemos que no es compatible, no hace falta seguir buscando
			        }
				}
			}
			
			if (sueldoActual <= presupuestoRestante && compatible) {
				actions.add(1);
			}
		}
		
		return actions;
	}

	@Override
	public Vertex1 neighbor(Integer a) {
		// TODO Auto-generated method stub
		Double nuevoPresupuestoRestante = presupuestoRestante;
		
		Set<String> nuevoCualidadesRestantes = new HashSet<>(cualidadesRestantes);
		List<Integer> nuevoElegidos = new ArrayList<>(elegidos);
		
		if (a == 1) {
			nuevoCualidadesRestantes.removeAll(Datos1.getCualidades(index));
			nuevoPresupuestoRestante -= Datos1.getSueldoMin(index);
		}
		
		nuevoElegidos.add(a);

		return new Vertex1I(index + 1, nuevoPresupuestoRestante, nuevoCualidadesRestantes, nuevoElegidos);
	}

	@Override
	public Edge1 edge(Integer a) {
		// TODO Auto-generated method stub
		return Edge1.of(this, this.neighbor(a), a);
	}

	@Override
	public Boolean goal() {
		// TODO Auto-generated method stub
		return this.index == (double) Datos1.getNumCandidatos() && this.cualidadesRestantes.isEmpty();
	}

	@Override
	public Boolean isValid() {
		// TODO Auto-generated method stub
		return this.index >= 0 && this.index <= (double) Datos1.getNumCandidatos() && this.presupuestoRestante >= 0;
	}

	@Override
	public Boolean goalHasSolution() {
		// TODO Auto-generated method stub
		return this.cualidadesRestantes.isEmpty();
	}

}
