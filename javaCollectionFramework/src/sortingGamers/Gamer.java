package sortingGamers;

import java.util.Objects;

public class Gamer implements Comparable<Gamer> {

	protected String name;
	protected int score;
	protected String country;
	protected double hours;

	public Gamer(String name, int score, String country, double hours) {
		this.name = name;
		this.score = score;
		this.country = country;
		this.hours = hours;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Gamer gamer = (Gamer) o;
		return Double.compare(gamer.score, score) == 0 && Objects.equals(name, gamer.name);
	}
	
	// Compare two Gamer objects by their score
	@Override
	public int compareTo(Gamer gamer) {
		return gamer.getScore() - this.getScore();
	}

	@Override
	public int hashCode() {
		return Objects.hash(score, name);
	}

	@Override
	public String toString() {
		return "Gamer [name=" + name + ", score=" + score + ", country=" + country + ", hours=" + hours + "]" + "\n";
	}

}
