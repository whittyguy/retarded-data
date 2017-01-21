import java.util.ArrayList;
import java.util.List;

public class Account {
private String login,password;
private List<Hero> heroList;
public Account (String login,String password){
	this.login=login;
	this.password=password;
	heroList=new ArrayList<Hero>();
}
public void createHero(){
	heroList.add(new Hero());
	System.out.println("Hero created");
}
public void sortAlpha(){
	heroList.stream().sorted((a,b)-> a.getName().compareTo(b.getName()));
}
public void deleteHero(String name){
	heroList.remove(heroList.stream().filter((p)-> p.getName().equals(name)));
}
public void show(){
	for(Hero hero:heroList){
		System.out.println(hero.getName()+" "+hero.getClass());
	}
}
public String getLogin(){
	return login;
}
public String getPassword(){
	return password;
}
}
