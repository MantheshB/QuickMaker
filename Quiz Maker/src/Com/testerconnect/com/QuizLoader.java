package Com.testerconnect.com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class QuizLoader {
public Item[] qItems=new Item[13];
	
	public Item[] loadQuestions(String fileName) throws IOException {
			FileReader fr=new FileReader(System.getProperty("user.dir")+"\\Questions\\questions.csv");
			BufferedReader br=new BufferedReader(fr);
			int count=0;
			String line;
			while((line=br.readLine())!= null){
				//System.out.println(line);
				Item i=new Item();
				String arr[]=line.split(",");
				//System.out.println(arr[0]);
				i.qid=arr[0];
				i.question=arr[1];
				i.options[0]=arr[2];
				i.options[1]=arr[3];
				i.options[2]=arr[4];
				i.options[3]=arr[5];
				i.ans=arr[6];
				i.category=arr[7];
				qItems[count]=i;
				count++;
			
			}
			
			System.out.println("There are "+qItems.length+" questions");
			
		
			return qItems;
	}
}
