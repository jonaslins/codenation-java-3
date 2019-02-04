package repositorio;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.opencsv.CSVReader;

import model.Jogador;

public class RepositorioCSVJogador implements RepositorioJogador{
	
	
	private List<Jogador> jogadores = new ArrayList<>();
	String csvFile = "src/main/resources/data.csv";
	// Quantas nacionalidades (coluna `nationality`) diferentes existem no arquivo?
	public RepositorioCSVJogador() {

		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader(csvFile));
			String[] line;

			line = reader.readNext();
			System.out.println("[ " + line[14] + ", " + line[1] + " , " + line[2] + "]");
			
			
			while ((line = reader.readNext()) != null) {
				String nationality = line[14];
				String club = StringUtils.isNotBlank(line[3]) ? line[3]: null;;
				String fullName = line[2];
				Date birthDate = stringToDate(line[8]);
				BigDecimal eurReleaseClause = StringUtils.isNotBlank(line[18]) ? new BigDecimal(line[18]): null;
				BigDecimal eurWage = new BigDecimal(line[17]);
				Integer age = new Integer(line[6]);
				//if(line[2].contains("Luka Modr") || age.equals(30)) {
					Jogador jogador = new Jogador(nationality, club, fullName,birthDate, eurReleaseClause, eurWage, age);
					jogadores.add(jogador);
//					System.out.println("[ " + line[14] + ", " + line[1] + " , " + line[2] + "]");
					//System.out.println(jogador.toString());
				//}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	
	public static Date stringToDate(String strToDate){
		Date dataConvertida = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dataConvertida = format.parse(strToDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return dataConvertida;
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
