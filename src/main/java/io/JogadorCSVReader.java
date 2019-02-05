package io;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.opencsv.CSVReader;

import model.Jogador;
import util.DateUtil;

public class JogadorCSVReader {
	
	private String csvFile = "src/main/resources/data.csv";
	
	private static final int FULL_NAME_COL = 2;
	private static final int CLUB_COL = 3;
	private static final int AGE_COL = 6;
	private static final int BIRTH_DATE_COL = 8;
	private static final int NATINALITY_COL = 14;
	private static final int EUR_RELEASE_CLAUSE_COL = 18;
	private static final int EUR_WAGE_COL = 17;
	
	public List<Jogador> loadListFromFile() {
		
		List<Jogador> jogadores = new ArrayList<>();

		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader(csvFile));
			String[] line;

			line = reader.readNext(); // ignore first line

			while ((line = reader.readNext()) != null) {
				String nationality = line[NATINALITY_COL];
				String club = StringUtils.isNotBlank(line[CLUB_COL]) ? line[CLUB_COL]: null;
				String fullName = line[FULL_NAME_COL];
				Date birthDate = null;
				try {
					birthDate = DateUtil.stringToDate(line[BIRTH_DATE_COL]);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				BigDecimal eurReleaseClause = StringUtils.isNotBlank(line[EUR_RELEASE_CLAUSE_COL]) ? new BigDecimal(line[EUR_RELEASE_CLAUSE_COL]): null;
				BigDecimal eurWage = new BigDecimal(line[EUR_WAGE_COL]);
				Integer age = new Integer(line[AGE_COL]);

				Jogador jogador = new Jogador(nationality, club, fullName, birthDate, eurReleaseClause, eurWage, age);
				jogadores.add(jogador);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jogadores;
	}

}

