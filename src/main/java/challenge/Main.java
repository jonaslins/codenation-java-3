package challenge;

import java.util.List;
import java.util.Map;

import repositorio.RepositorioCSVJogador;
import repositorio.RepositorioJogador;

public class Main {

	
	private RepositorioJogador repositorioJogador = new RepositorioCSVJogador();
	// Quantas nacionalidades (coluna `nationality`) diferentes existem no arquivo?
	public int q1() {
		return repositorioJogador.countByNationality();
	}

	// Quantos clubes (coluna `club`) diferentes existem no arquivo?
	// Obs: Existem jogadores sem clube.
	public int q2() {
		return repositorioJogador.countByClub();
	}

	// Liste o primeiro nome (coluna `full_name`) dos 20 primeiros jogadores.
	public List<String> q3() {
		return repositorioJogador.findFirst20();
	}

	// Quem são os top 10 jogadores que possuem as maiores cláusulas de rescisão?
	// (utilize as colunas `full_name` e `eur_release_clause`)
	public List<String> q4() {
		return repositorioJogador.findTop10ByEurReleaseClauseDesc();
	}

	// Quem são os 10 jogadores mais velhos (use como critério de desempate o campo `eur_wage`)?
	// (utilize as colunas `full_name` e `birth_date`)
	public List<String> q5() {
		return repositorioJogador.findTop10ByBirthDateAscAndEurWageDesc();
	}

	// Conte quantos jogadores existem por idade. Para isso, construa um mapa onde as chaves são as idades e os valores a contagem.
	// (utilize a coluna `age`)
	public Map<Integer, Integer> q6() {
		return null;
	}

}
