import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
public static void main(String[] str) throws IOException{
	
AccountHolder a=new AccountHolder();
Account cur=null;
boolean sesionOn=true;
BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
while(cur==null){
	System.out.println("1 - to login, 2 - create account");
	String chose=reader.readLine();
switch(chose){
case "1":
	cur=a.logIn();
	break;
case "2":
	a.createAccount();
	break;
default:
	System.out.println("There is no such option");
	break;
}
}
System.out.println("Succesfully logged in");
while(sesionOn==true){
	System.out.println("1 - to show Heroes list , 2 - create Hero, 3 - sort heroes, 4 - delete, else - quit");
	String chose=reader.readLine();
switch(chose){
case "1":
	cur.show();
	break;
case "2":
	cur.createHero();
	break;
case "3":
	cur.sortAlpha();
case "4":
	System.out.println("type a name of hero you want to delete:");
	BufferedReader nameReader=new BufferedReader(new InputStreamReader(System.in));
	String name=nameReader.readLine();
	cur.deleteHero(name);
default:
	System.out.println("Quit");
	sesionOn=true;
	break;
}
}
}
}