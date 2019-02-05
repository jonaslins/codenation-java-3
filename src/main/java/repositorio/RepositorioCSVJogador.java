package repositorio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import io.JogadorCSVReader;
import model.Jogador;

public class RepositorioCSVJogador implements RepositorioJogador{
	
	
	private List<Jogador> jogadores = new ArrayList<>();

	private JogadorCSVReader jogadorCSVReader;
	
	public RepositorioCSVJogador() {
		jogadorCSVReader = new JogadorCSVReader();
		jogadores = jogadorCSVReader.loadListFromFile();
	}

	public int countByNationality() {
		int size = jogadores.stream().collect(
                Collectors.groupingBy(Jogador::getNationality, Collectors.counting())).size();
		return size;
	}
	
	public int countByClub() {
		int size = jogadores.stream().filter( j -> j.getClub() != null ).collect(
                Collectors.groupingBy(Jogador::getClub, Collectors.counting())).size();
		return size;
	}

	@Override
	public List<String> findFirst20() {
		return jogadores.stream()
				.limit(20)
				.map(Jogador::getFullName)
				.collect(Collectors.toList());
	}
	@Override
	public List<String> findTop10ByEurReleaseClauseDesc() {
		return jogadores.stream()
				.filter( j -> j.getEurReleaseClause() != null )
				.sorted(Comparator.comparing(Jogador::getEurReleaseClause).reversed())
				.limit(10)
				.map(Jogador::getFullName)
				.collect(Collectors.toList());
	}
	
	@Override
	public List<String> findTop10ByBirthDateAscAndEurWageDesc() {
		return jogadores.stream()
				.sorted(Comparator.comparing(Jogador::getBirthDate)
						.thenComparing(Comparator.comparing(Jogador::getEurWage).reversed()))
				.limit(10)
				.map(Jogador::getFullName)
				.collect(Collectors.toList());
	}

	@Override
	public Map<Integer, Integer> groupAndCountByAge() {
		return jogadores.stream().collect(Collectors.toMap(Jogador::getAge, j -> 1, Integer::sum));
	}

}
