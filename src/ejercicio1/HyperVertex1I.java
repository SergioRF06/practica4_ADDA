package ejercicio1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record HyperVertex1I(Integer index, Set<String> cualidadesACubrir, Double presupRestante, Set<Integer> cand) 
	implements HyperVertex1 {

	@Override
	public List<Integer> actions() {
		// TODO Auto-generated method stub
		List<Integer> alternativas = new ArrayList<>();
		if (this.index < Datos1.getNumCandidatos()) {
            // Acción 0: No contratar siempre es una opción válida
			alternativas.add(0);
            
            // Acción 1: Contratar (verificar presupuesto e incompatibilidad)
            if (this.presupRestante >= Datos1.getSueldoMin(this.index) && 
                !this.cand.contains(index)) {
                alternativas.add(1);
            }
		}	
		return alternativas;
	}

	@Override
	public Boolean isBaseCase() {
		// TODO Auto-generated method stub
		return this.cualidadesACubrir.isEmpty() || this.index == Datos1.getNumCandidatos();	
//		return null;
	}

	@Override
	public Double baseCaseWeight() {
		// TODO Auto-generated method stub
		return this.cualidadesACubrir.isEmpty()? 0.: null;
//		return null;
	}
	
	@Override
	public List<Integer> baseCaseSolution() {
		// TODO Auto-generated method stub
		return this.cualidadesACubrir.isEmpty()? new ArrayList<Integer>(): null;
//		return null;
	}

	@Override
	public Boolean isValid() {
		// TODO Auto-generated method stub
//		return this.index >= 0 && this.index <= Datos1.getNumCandidatos() && this.presupRestante >= 0;
		return null;
	}

	@Override
	public List<Integer> solution(Integer a, List<List<Integer>> solutions) {
		// TODO Auto-generated method stub
		List<Integer> seleccionados = solutions.get(0);
		
		if (a == 1) {
			seleccionados.add(0, this.index);
		}
		
		return seleccionados;
	}

	@Override
	public List<HyperVertex1> neighbors(Integer a) {
		// TODO Auto-generated method stub
		Set<String> nuevoCualidades = new HashSet<>(this.cualidadesACubrir);
		Set<Integer> nuevoIncompatibilidades = new HashSet<>(this.cand);
		Double nuevoPresup = this.presupRestante;
		
		if (a == 1) {
			nuevoCualidades.removeAll(Datos1.getCualidades(this.index));
			nuevoPresup -= Datos1.getSueldoMin(this.index);
			for (int i = this.index; i < Datos1.getNumCandidatos(); i++) {
				if (Datos1.getSonIncompatibles(this.index, i)) nuevoIncompatibilidades.add(i);
			}
		}
		
		return List.of(new HyperVertex1I(index + 1, nuevoCualidades, nuevoPresup, nuevoIncompatibilidades));
	}

	@Override
	public HyperEdge1 edge(Integer a) {
		// TODO Auto-generated method stub
		List<HyperVertex1> targets = this.neighbors(a);
		return HyperEdge1.of(this, targets, a);
	}

	
	
}
