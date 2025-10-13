public class Main {
  public static void main(String[] args) {
    String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    
    // Best-case: pattern matches at the very beginning
    String bestCase = "A"; // first character of text

    long startTime = System.nanoTime();  
    int index = match(text, bestCase);
    long endTime = System.nanoTime();    
    long elapsedTime = endTime - startTime; 
    
    // Display results for best case
    if (index >= 0)
      System.out.println("best-case input matched at index " + index);
    else
      System.out.println("best-case input unmatched");  
    System.out.println("Elapsed time (ns): " + elapsedTime);

    // Worst-case: pattern matches at the very end or does not exist
    String worstCase = "9"; // last character of text

    startTime = System.nanoTime();  
    index = match(text, worstCase);
    endTime = System.nanoTime();    
    elapsedTime = endTime - startTime; 

    // Display results for worst case
    if (index >= 0)
      System.out.println("worst-case input matched at index " + index);
    else
      System.out.println("worst-case input unmatched");  
    System.out.println("Elapsed time (ns): " + elapsedTime);
  }

  // Return the index of the first match. -1 otherwise.
  public static int match(String text, String pattern) {
    for (int i = 0; i < text.length() - pattern.length() + 1; i++) {
      if (isMatched(i, text, pattern))
        return i;
    }

    return -1;
  }
	
  // Test if pattern matches text starting at index i
  private static boolean isMatched(int i, String text, String pattern) {
    for (int k = 0; k < pattern.length(); k++) {
      if (pattern.charAt(k) != text.charAt(i + k)) {
        return false;
      }
    }
    return true;
  }
}
