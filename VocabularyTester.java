import java.util.Random;
//Ali Sbeih 3/5/2022
/*program that reads all the words in a given
(presumably large) text file, and reports the number of
distinct uncommon words in the file.
*/
public class VocabularyTester {
    public static void main(String[] args) {
		//a set for common words
		SimpleUSet<String> commonWordsSet=new MTFSimpleUSet<>();
		//a set for uncommon words
		SimpleUSet<String> uncommonWordsSet=new MTFSimpleUSet<>();
		WordReader commonwr = new WordReader("common-words.txt");
		WordReader uncommonwr= new WordReader(args[0]);
//check if there is a next word then add it
		while (true) {
			String nextWord=commonwr.nextWord();
			if(nextWord!=null) commonWordsSet.add(nextWord);
			else break;
		}
//timer and csvwriter for measuring the time of adding the uncommon words
		RunTimer rt = new RunTimer();
		CSVWriter csv = new CSVWriter("Simple-U-Set.csv");
		csv.addEntry("text size");
		csv.addEntry("time per measuring size of vocabulary operation");
		csv.endLine();
//size variable for counting the total number of words in a text
int size=0;

//check if there is a next word that is not common then add it
		while (true) {
			String nextWord=uncommonwr.nextWord();
			if(nextWord!=null){
				size++;
				rt.start();
				if(commonWordsSet.find(nextWord)==null)
				uncommonWordsSet.add(nextWord);
				rt.stop();
			}
			else break;
		}
		csv.addEntry(size);
		csv.addEntry(rt.getElapsedNanos());
		csv.endLine();

		rt.reset();
        csv.close();

//print number of uncommon words
		System.out.println("The number of distinct uncommon words in the file "+args[0]+" is "+uncommonWordsSet.size()+" words!");



	if (args.length != 1) {
	    System.out.println("Error: received " + args.length +
			       " arguments, expected 1.\n");
	}

    }
}
