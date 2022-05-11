package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {

	public static void main(String[] args) {

		List<GameCharacter> characters = Arrays.asList(
				new GameCharacter("Arthas Menethil", "Lich King", "Icecrown", 80, 1500, Continent.Northrend),
				new GameCharacter("Thrall", "Warchief", "Orgrimmar", 90, 1200, Continent.Kalimdor),
				new GameCharacter("Jaina Proudmoore", "Lord Admiral", "Kul Tiras", 120, 1000,
						Continent.Eastern_Kingdoms),
				new GameCharacter("Tyrande Whisperwind", "Priestess of Elune", "Teldrassil", 120, 1100,
						Continent.Kalimdor),
				new GameCharacter("Sylvanas Windrunner", "Dark Ranger", "Undercity", 120, 1100,
						Continent.Eastern_Kingdoms));

//		Stream<GameCharacter> charactersStream = characters.stream();

		/* ----- 1 ----- */
		ArrayList<GameCharacter> kalidmorCharacters = new ArrayList<>();

		System.out.println("---------kalidmor Characters---------");
		characters.stream().filter((ch) -> ch.getContinent() == Continent.Kalimdor)
				.forEach(ch -> kalidmorCharacters.add(ch));
		List<GameCharacter> list = characters.stream().filter((ch) -> ch.getContinent() == Continent.Kalimdor)
				.collect(Collectors.toList());

		System.out.println(kalidmorCharacters);
		System.out.println(list);

		/* ----- 2 ----- */
		System.out.println("----------before sorting-----------");
		System.out.println(characters);
		
		Collections.sort(characters, (ch1, ch2) -> (int) (ch2.getHitPoints() - ch1.getHitPoints()));
		System.out.println("-----------after sorting-----------");
		System.out.println(characters);

		
		/* ----- 3 ----- */
		System.out.println("-----------average hit points-----------");
		List<Double> hitpoints = characters.stream()
				.filter(ch -> ch.getLevel() == 120)
				.map(ch -> ch.getHitPoints()) // or map(GameCharacter::getHitPoints)
				.collect(Collectors.toList());
//				.reduce(0.0,(curr, next)-> curr + next ); not works

		System.out.println(hitpoints);
		double averege = hitpoints.stream()
				.reduce(0.0, (curr, next) -> curr + next) / hitpoints.size();
		System.out.println("average hit points of characters in level 120 is: " + averege);

		/* ----- 4 ----- */
		System.out.println("-----------new Characters-----------");
		List<GameCharacter> newCharacters = characters.stream()
				.map(ch -> ch.getName())
				.map(ch -> new GameCharacter(ch, null, null, 0, 0, null))
				.collect(Collectors.toList());

		System.out.println(newCharacters);

	}

}
