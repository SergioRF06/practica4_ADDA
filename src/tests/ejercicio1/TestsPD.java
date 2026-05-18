package tests.ejercicio1;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import ejercicio1.Datos1;
import ejercicio1.HyperEdge1;
import ejercicio1.HyperVertex1;
import us.lsi.graphs.alg.PD;
import us.lsi.graphs.alg.PD.PDType;
import us.lsi.graphs.alg.PD.Sp;
import us.lsi.hypergraphs.GraphTree;
import us.lsi.hypergraphs.SimpleVirtualHyperGraph;

public class TestsPD {

	public static void main(String[] args) throws IOException {
		// TODO Consulte los ejemplos del repositorio


		// Set up
		Locale.setDefault(Locale.of("en", "US"));
		for (Integer id_fichero = 1; id_fichero < 4; id_fichero++) {

			Datos1.iniDatos("datos_entrada/ejercicio1/DatosEntrada" + id_fichero + ".txt");
			System.out.println("=============");
			System.out.println("\tResultados para el test " + id_fichero + "\n");
			
			// V�rtices clave

			HyperVertex1 p = HyperVertex1.start();

			// Grafo

			System.out.println("\n\n#### Algoritmo PD ####");

			// Algoritmo PD
			
			System.out.println(p);				
			SimpleVirtualHyperGraph<HyperVertex1,HyperEdge1,Integer> graph3 = 
					SimpleVirtualHyperGraph.simpleVirtualHyperGraph(p);
			
			PD<HyperVertex1, HyperEdge1, Integer,List<Integer>> a = 
					PD.dynamicProgrammingSearch(graph3,PDType.Max);
			
//			a.withGraph = true;
			a.search();
			
			Map<HyperVertex1, Sp<Integer, HyperEdge1>> s = a.getSolutionsTree();
			
			if (s.get(p) == null) {
				System.out.println("No hay solución");
			} else {			
				GraphTree<HyperVertex1,HyperEdge1,Integer,List<Integer>> tree = 
						GraphTree.graphTree(p,s);

				System.out.println(tree.solution());

//				System.out.println(HyperVertex1I.valor(tree.solution()));
			}
		}

	}
	
}