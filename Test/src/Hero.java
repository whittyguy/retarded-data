import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hero {
private String characterName;
public enum CharacterClass{Titan, WeaponMaster, ElementMaster}
private CharacterClass Class;
private Appearence characterAppearence;
public Hero(){
	setName();
	try{
	setAppearence();
	}
	catch(IOException e){
		System.out.println("Cannot create character with such Appearence.");
		characterAppearence=new Appearence();
		System.out.println("It setted by default");
	}
	try{
	setClass();
	}
	catch(IOException e){
		System.out.println("there is no such class");
	}
}
public String getName(){
	return characterName;
}
public void Rename(String name){
	this.characterName=name;
}
private void setName(){
	System.out.println("Enter character name:");
	BufferedReader nameReader=new BufferedReader(new InputStreamReader(System.in));
	try {
		String name=nameReader.readLine();
		characterName=name;
	} catch (IOException e) {
		e.printStackTrace();
	}
}
private void setAppearence() throws IOException{
	BufferedReader app=new BufferedReader(new InputStreamReader(System.in));
	System.out.println("To chose type of hair type one of colors in the list:");
	System.out.println("black,white,gold,brown,red");
	String hairColor=app.readLine();
	System.out.println("To chose type of skin type one of colors in the list:");
	System.out.println("white,suntan,aziat,nigga");
	String skinColor=app.readLine();
	System.out.println("To chose type of body type one of colors in the list:");
	System.out.println("ectomorph,mezomorph,endomorph");
	String bodyType=app.readLine();
	try{
	characterAppearence=new Appearence(hairColor,skinColor,bodyType);}
	catch(IllegalArgumentException e){
	System.out.println("Illegal type of appearence. Created as default");
	characterAppearence=new Appearence();
	}
}
private void setClass() throws IOException{
	System.out.println("Type 1 to chose Titan, 2 for WeaponMaster,3 for ElementMaster");
	BufferedReader classRead=new BufferedReader(new InputStreamReader(System.in));
	String strClass=classRead.readLine();
	int classification=Integer.parseInt(strClass);
	switch(classification){
	case 1:
		Class=CharacterClass.Titan;
		break;
	case 2:
		Class=CharacterClass.WeaponMaster;
		break;
	case 3:
		Class=CharacterClass.ElementMaster;
		break;
	default:
		System.out.println("Class chosen as Titan by default");
		Class=CharacterClass.Titan;
		break;
	}
}

}
