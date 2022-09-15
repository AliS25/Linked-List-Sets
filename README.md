# Linked-List-Sets
Two implementations of the SimpleUSet(simple unordered set) interface using a linked list as the underlying data structure. 
The first implementation is a straightforward implementation in which the relative positions of elements are unchanged upon search, insertion, and removal. 
The second implementation uses the “move-to-front” heuristic, in which whenever an element in the set is accessed, it is moved to the front of the list. 

Also, there is a program, VocabularyTester, that reads all of the words in a given (presumably large) text file, and reports the number of distinct uncommon words in the file using the two implementations. Specifically, there is a text file containing 10,000 common English words. Given another text file, the program reads all of the words and reports the number of distinct words that do not appear on the list of common words. 

![MTFSimpleUSet time per measuring size of vocabulary operation and LinkedSimpleUSet time per measuring size of vocabulary operation](https://user-images.githubusercontent.com/99061775/190324703-dab3e292-4701-49d4-9e84-547d3c0cc524.png)

