import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AccountHolder {
private File data;
private FileReader in;
private FileWriter out;
private int accCount;
private  ArrayList<Account> accountsList;
public AccountHolder() throws IOException{
	data=new File("Accounts.txt");
	out=new FileWriter(data,true);
	in=new FileReader(data);
	BufferedReader read=new BufferedReader(in);
	accountsList=new ArrayList<Account>();
	while(read.ready()){
	String[] fullName=read.readLine().split(" ");
	String login=fullName[0];
	String password=fullName[1];
	accountsList.add(new Account(login,password));
	}
	
}
public void createAccount() throws IOException{
	System.out.println("Type your login:");
	BufferedReader accReader=new BufferedReader(new InputStreamReader(System.in));
	String login=accReader.readLine();
	while(accountsList.stream().anyMatch(login::equals)){
		System.out.println("Account with such login already exists");
		System.out.println("Chose other login:");
		login=accReader.readLine();
	}
	System.out.println("Type your password");
	String password=accReader.readLine();
	accountsList.add(new Account(login,password));
	String fullName=login+" "+password;
	out.write(fullName);
	out.append("\n");
	out.flush();
	accCount++;
	System.out.println("Account succesfully created");
}
private Account logIn(String login, String password) {
return accountsList.stream().filter((p)->p.getLogin().equals(login)).filter((p)->p.getPassword().equals(password)).findAny().orElse(null);
}
public Account logIn() throws IOException{
		BufferedReader logReader=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("login:");
		String loginUs=logReader.readLine();
		System.out.println("password:");
		String passUs=logReader.readLine();
		return logIn(loginUs,passUs);
}
}
