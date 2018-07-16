package Com.testerconnect.com;
import java.io.IOException;
import java.util.Scanner;

public class QuizMakerMain {
	static int totalScore = 0;
	static int scoreSports=0;
	static int scoreVerbal=0;
	static int scoreProgramming=0;
	static int scoreAnalytical=0;
		
	// public static Item[] qItems=new Item[13];

	public static void main(String[] args) throws IOException {
		QuizLoader ql = new QuizLoader();

		Item[] qItems = ql.loadQuestions(System.getProperty("user.dir") + "//Questions//questions.csv");

		for (int j = 0; j <= qItems.length - 1; j++) {
			// Print each question
			Scanner sc = new Scanner(System.in);
			System.out.println(qItems[j].qid + ") " + qItems[j].question);
			System.out.println("Options: a) " + qItems[j].options[0] + " b) " + qItems[j].options[1] + " c) "
					+ qItems[j].options[2] + " d) " + qItems[j].options[3]);

			// Get the answer from the user
			String userAns = sc.next();
			if (userAns.equals(qItems[j].ans)) {
				// update the score
				totalScore = totalScore + 10;
				
				//update the Category score
				switch (qItems[j].category) {
				case "Verbal":
					scoreVerbal=scoreVerbal+10;
					break;
					
				case "Sports":
					scoreSports=scoreSports+10;
					break;
					
				case "Programming":
					scoreProgramming=scoreProgramming+10;
					break;
					
				case "Analytical":
					scoreAnalytical=scoreAnalytical+10;
					break;

				default:
					System.out.println("Issue with the Question Category, talk to your co-ordinator");
					break;
				}
			}

			// display the live score
			System.out.println("Your Score is " + totalScore);

		} // End For
		System.out.println("-------- End of Test-------------");
		// Display Score Category wise
		System.out.println("Verbal Score: "+scoreVerbal);
		System.out.println("Sports Score: "+scoreSports);
		System.out.println("Programming Score: "+scoreProgramming);
		System.out.println("Analytical Score: "+scoreAnalytical);
		System.out.println("Your Total Score is " + totalScore);

	}
}
