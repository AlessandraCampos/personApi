package alessandrafcam.first_project.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLOutput;
import java.util.*;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class FirstProjectApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstProjectApiApplication.class, args);
		// MAP
		System.out.println("Crie um dicionario de carros e com os valores de valores :");
		Map<String,Double>carrospopulares =new HashMap<>(){{
			put("gol", 14.4);
			put("uno", 15.6);
			put("mobi", 16.6);
			put("hb20", 14.5);
			put("corolla", 15.8);
			put("palio", 18.6);

		}};
		System.out.println(carrospopulares);
		System.out.println("Substitua o consumo do gol por 15.2 km");
		carrospopulares.put("gol",15.2);
		System.out.println("Consumo do gol"+ carrospopulares);
		System.out.println("Confirma se o tucson esta na lista : " + carrospopulares.containsKey("tucson"));
		System.out.println("Consumo do uno" +carrospopulares.get("uno"));
		System.out.println("Exiba os modelos  : ");
		Set<String> modelos = carrospopulares.keySet();
		System.out.println(modelos);
		System.out.println("Exiba os valores : ");
		Collection<Double> consumo = carrospopulares.values();
		System.out.println(consumo);
		System.out.println("Retorne o modelo mais economico :");
		Double consumoMaisEficiente =Collections.max(carrospopulares.values());//o valor maior sera inserido na variavel
		Set<Map.Entry<String,Double>> entries= carrospopulares.entrySet();// a lista sera inserida na variavel entries
		String modeloMaisEficiente= "";// variavel vazia
		for(Map.Entry<String,Double>entry: entries){ // ira mapear uma a uma na variavel entry
			if(entry.getValue().equals(consumoMaisEficiente)){// se a entrada do valor for igual ao consumo maximo na variavel
				modeloMaisEficiente= entry.getKey(); // guarde o valor da chave na variavel modelo
				System.out.println("Modelo mais eficiente :"+ modeloMaisEficiente + " e Consumo mais eficiente :"+
						consumoMaisEficiente);
			}
		}
		Iterator<Double>iterator1= carrospopulares.values().iterator();
		while (iterator1.hasNext()){
			if (iterator1.next().equals(15.6))iterator1.remove();
		}
		System.out.println(carrospopulares);

//		System.out.println("Crie uma lista e adicione 7 notas!");
//		List <Double>notas = new ArrayList<>();
//		notas.add(5d);
//		notas.add(8d);
//		notas.add(7d);
//		System.out.println("Minhas lista tem as notas:"+notas);
//		System.out.println(notas.indexOf(5d));
//		System.out.println("Adicione ao indice 3 o elemento 8.5");
//		notas.add(3,8.5);
//		System.out.println(notas);
//		System.out.println("este é o tamanho da lista: "+notas.size());
//		System.out.println("Substitua a nota  5 por 6");
//		notas.set(notas.indexOf(5d),6.0 );
//		System.out.println(notas);
//		System.out.println("A nota 5 esta na lista?" + notas.contains(5d));
//		System.out.println("Exiba na ordem que as notas foram inseridas");
//		for(Double nota: notas ) System.out.println(nota);

	//	System.out.println("Ordem aleatória!");
//
//		List<String> numerosAleatorios=
//				Arrays.asList("1","0","5","2","7","8","10","12");
//
//		numerosAleatorios.forEach(System.out::println);
//		System.out.println("Pegue os 5 primeiros numeros e coloque em um Set!");
//		numerosAleatorios.stream()
//				.limit(5)
//				.collect(Collectors.toSet())
//				.forEach(System.out::println);
////		System.out.println("Transforme em numeros inteiros");
//		List<Integer> listaInteiros= numerosAleatorios.stream()
//				.map(Integer::parseInt)
//				.collect(Collectors.toList());
////		System.out.println(listaInteiros);
////		System.out.println("Pegue os numeros pares e maiores que 2 e coloque em uma lista");
////		List <Integer> numerosPares = numerosAleatorios.stream()
////				.map(Integer::parseInt)
////				.filter( i -> i%2==0 && i>2)
////				.collect(Collectors.toList());
////		System.out.println(numerosPares);
////		System.out.println("Mostre a média dos numeros");
////
////		numerosAleatorios.stream()
////				.mapToInt(Integer::parseInt)
////				.average()
////				.ifPresent(System.out::println);
//
//		System.out.println("Remova os numeros impares");
//		listaInteiros.removeIf(integer -> (integer%2 !=0));
//		System.out.println(listaInteiros);







//		Map<String,Livro> meusLivros = new HashMap<>(){{
//			put("Hawkin, Spephen",new Livro("Uma breve historio do tempo",256));
//			put("Daough, Charles",new Livro("Poder do Hábito",408));
//			put("Harari, Noah",new Livro("21 Licões para o seculo 21",4326));
//
//		}};
//		for (Map.Entry<String,Livro> livro:meusLivros.entrySet())
//			System.out.println(livro.getKey()+ "-"+ livro.getValue().getNome());

//		System.out.println("Ordem de inserção!");
//		Map<String,Livro>meuslivros2 = new LinkedHashMap<>(){{
//			put("Hawkin, Spephen",new Livro("Uma breve historio do tempo",256));
//			put("Daough, Charles",new Livro("Poder do Hábito",408));
//			put("Harari, Noah",new Livro("21 Licões para o seculo 21",4326));
//
//		}};
//		for (Map.Entry<String,Livro> meuslivro2:meusLivros.entrySet())
//			System.out.println(meuslivro2.getKey()+ "-" + meuslivro2.getValue().getNome());
//		System.out.println("Ordem alfabetica autores!");
//		Map<String,Livro> meusLivros3 = new	TreeMap<>(meuslivros2);
//		for(Map.Entry<String,Livro>livro:meusLivros3.entrySet())
//			System.out.println(livro.getKey()+ "-"+ livro.getValue().getNome());
//		System.out.println("Ordenar por paginas!");
	//	Set<Map.Entry><Integer,Livro>>set = new TreeSet<>()

	}
//static class Livro {
//		private String nome;
//		private Integer paginas;
//
//	Livro(String nome, Integer paginas) {
//		this.nome = nome;
//		this.paginas = paginas;
//	}
//
//	public String getNome() {
//		return nome;
//	}
//
//	public Integer getPaginas() {
//		return paginas;
//	}
//}

//
//	@Override
//	public int hashCode() {
//		return super.hashCode();
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		return super.equals(obj);
//	}
//
//	@Override
//	public String toString() {
//		return super.toString();
//	}
}
