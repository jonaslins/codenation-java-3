package model;

import java.math.BigDecimal;
import java.util.Date;

public class Jogador {
	
	private String nationality;
	private String club;
	private String fullName;
	private Date birthDate;
	private BigDecimal eurReleaseClause;
	private BigDecimal eurWage;
	private Integer age;

	public Jogador(String nationality, String club, String fullName,
			Date birthDate, BigDecimal eurReleaseClause, BigDecimal eurWage,
			Integer age) {
		super();
		this.nationality = nationality;
		this.club = club;
		this.fullName = fullName;
		this.birthDate = birthDate;
		this.eurReleaseClause = eurReleaseClause;
		this.eurWage = eurWage;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Jogador [nationality=" + nationality + ", club=" + club
				+ ", fullName=" + fullName + ", eurReleaseClause="
				+ eurReleaseClause + ", birthDate=" + birthDate + ", eurWage="
				+ eurWage + ", age=" + age + "]";
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public BigDecimal getEurReleaseClause() {
		return eurReleaseClause;
	}

	public void setEurReleaseClause(BigDecimal eurReleaseClause) {
		this.eurReleaseClause = eurReleaseClause;
	}

	public BigDecimal getEurWage() {
		return eurWage;
	}

	public void setEurWage(BigDecimal eurWage) {
		this.eurWage = eurWage;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	
	
}
