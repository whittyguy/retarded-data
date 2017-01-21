import java.io.IOException;

public class Appearence {
public static enum hairColor{black,white,gold,brown,red}
public static enum skinColor{white,suntan,aziat,nigga}
public static enum bodyType{ectomorph,mezomorph,endomorph}
private hairColor hair;
private skinColor skin;
private bodyType body;
public Appearence(){
	hair=hairColor.black;
	skin=skinColor.nigga;
	body=bodyType.mezomorph;
}
public Appearence(String hairColor,String skinColor,String bodyType)throws NullPointerException,IllegalArgumentException{
	
	this.hair.valueOf(hairColor);
	this.skin.valueOf(skinColor);
	this.body.valueOf(bodyType);
}
}
