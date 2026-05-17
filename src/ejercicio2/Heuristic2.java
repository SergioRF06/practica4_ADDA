package ejercicio2;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Heuristic2 {

	public static Double heuristic(Vertex2 v1, Predicate<Vertex2> goal, Vertex2 v2) {
		if (v1.index() == Datos2.getNumElementos()) {
			return 0.;
		}
		
		Double valoracionAprox = 0.;
		Double liquido = IntStream.range(v1.index(), Datos2.getNumElementos()).mapToDouble(x -> Datos2.getTamElemento(x)).sum();
		List<Integer> capRestanteOrdenada = v1.capRestante().stream().filter(x -> x > 0).sorted().toList();
		
		for (int i = 0; i < capRestanteOrdenada.size(); i++) {
			if (liquido < capRestanteOrdenada.get(i)) break;
			
			liquido -= capRestanteOrdenada.get(i);
			valoracionAprox += 1;
		}
		
		return valoracionAprox;
	}
}
