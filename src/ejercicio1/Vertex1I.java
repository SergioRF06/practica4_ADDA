package ejercicio1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record Vertex1I(Integer index, Set<String> cualidades, Double sueldoAcumulado, List<Integer> elegidos) 
			implements Vertex1 {
	
	public static Vertex1 initial() {
		return new Vertex1I(0, new HashSet<>(), 0., new ArrayList<>());
	}

	@Override
	public List<Integer> actions() {
		// TODO Auto-generated method stub
		List<Integer> alternativas = new ArrayList<>();
		
		if (index < Datos1.getNumCandidatos()) {
			alternativas.add(0);
			
			Double futuroSueldo = sueldoAcumulado + Datos1.getSueldoMin(index);	
			boolean esCompatible = elegidos.stream().noneMatch(e ->
					Datos1.getSonIncompatibles(e, index) || Datos1.getSonIncompatibles(index, e));
			
			if (index < Datos1.getNumCandidatos() - 1) {
				alternativas.add(0);
				if (futuroSueldo <= Datos1.getPresupuestoMax() && esCompatible) {
					alternativas.add(1);
				}
			}
			
			else {
				if (cualidades.containsAll(Datos1.getCualidades())) {
					alternativas.add(0);
				}
				
				if (futuroSueldo <= Datos1.getPresupuestoMax() && esCompatible) {
					Set<String> cualidadesFuturas = new HashSet<>(cualidades);
					cualidadesFuturas.addAll(Datos1.getCualidades());
					
					if(cualidadesFuturas.containsAll(Datos1.getCualidades())) {
						alternativas.add(1);
					}
				}
			}
		}
		return alternativas;
	}

	        @Override
	public Vertex1 neighbor(Integer a) {
		Set<String> nuevasCualidades = new HashSet<>(cualidades);
		Double nuevoSueldo = sueldoAcumulado;
		List<Integer> nuevosElegidos = new ArrayList<>(elegidos);
		
		if (a == 1) {
			nuevasCualidades.addAll(Datos1.getCualidades(index));
			nuevoSueldo += Datos1.getSueldoMin(index);
			nuevosElegidos.add(index);
		}
		
		return new Vertex1I(index +1, nuevasCualidades, nuevoSueldo, nuevosElegidos);
	}

	        @Override
	public Edge1 edge(Integer a) {
		// TODO Auto-generated method stub
		return Edge1.of(this, neighbor(a), a);
	}

	public Boolean isGoal() {
		return index == Datos1.getNumCandidatos() &&
				cualidades.containsAll(Datos1.getCualidades());
	}
}
