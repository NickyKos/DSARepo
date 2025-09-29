import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
// Nick Kostura

class Main {
  public static void main(String[] args) {
    Lab2 lab = new Lab2();
    lab.linkedList();
    lab.queue();
    lab.stack();
  }
}

class Lab2 {
  public void linkedList() {
    // 1. Create a LinkedList<String> object called progLanguages
    LinkedList<String> progLanguages = new LinkedList<>();

    // 2. Add elements
    progLanguages.add("Java");
    progLanguages.add("Python");
    progLanguages.add("JavaScript");
    progLanguages.add("C++");

    // 3. Remove "C++"
    progLanguages.remove("C++");

    // 4. Add "HTML" at index 2
    progLanguages.add(2, "HTML");

    // 5. Iterate with Iterator
    Iterator<String> iterator = progLanguages.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
  
  public void queue() {
    // 6. Create a Queue<String> called q
    Queue<String> q = new LinkedList<>();

    // 7. Add 5 first names
    q.add("Nick");
    q.add("Connar");
    q.add("Sam");
    q.add("Dylan");
    q.add("Sarah");

    // 8. Print queue
    System.out.println("Elements of queue: " + q);

    // 9. Remove head
    String removedElement = q.remove();
    System.out.println("Removed element: " + removedElement);

    // 10. Peek head
    System.out.println("Head of queue: " + q.peek());

    // 11. Iterate with for-each
    for (String element : q) {
      System.out.println(element);
    }
  }

  public void stack() {
    // 12. Create a Stack<String> called bookStack
    Stack<String> bookStack = new Stack<>();

    // 13. Push books
    bookStack.push("Clean Code");
    bookStack.push("Design Patterns");
    bookStack.push("Pragmatic Programmer");

    // 14. Pop 1 book
    String poppedBook = bookStack.pop();
    System.out.println("Popped book: " + poppedBook);

    // 15. Peek top
    System.out.println("Top of stack: " + bookStack.peek());

    // 16. Push "Web DB Technologies"
    bookStack.push("Web DB Technologies");

    // 17. Peek again
    System.out.println("Top of stack: " + bookStack.peek());

    // 18. Search for "Design Patterns"
    int position = bookStack.search("Design Patterns");
    System.out.println("Position of 'Design Patterns': " + position);

    // 19. Check if empty
    System.out.println("Is stack empty? " + bookStack.empty());

    // 20. Print all books
    for (String book : bookStack) {
      System.out.println(book);
    }
  }
}