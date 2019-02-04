package repositorio;

import java.util.List;
import java.util.Map;

public interface RepositorioJogador {
	
	int countByNationality();
	int countByClub();
	List<String> findFirst20();
	List<String> findTop10ByEurReleaseClauseDesc();
	List<String> findTop10ByBirthDateAscAndEurWageDesc();
	Map<Integer, Integer> groupAndCountByAge();

}
