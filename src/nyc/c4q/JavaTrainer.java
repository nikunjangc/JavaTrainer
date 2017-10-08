package nyc.c4q;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class JavaTrainer {
    private static HashMap<String, String> definitions = new HashMap<>();
    public static ArrayList<Character> lettersInAlpha = new ArrayList();
    static void startJavaTrainer() {
        promptUserInput();
        checkString();
        startProgram();
    }
    private static void checkString(){
        int num=97;
        for (int i=0; i<26;i++){
            char input=(char) num;
            lettersInAlpha.add(input);
            num++;
        }
    }
    private static void startProgram() {
        initializeMap();
        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        while (scanner.hasNext()) {
            String userTerm = scanner.next().toLowerCase();
            String check = userTerm;
            if (check.toLowerCase().equals("quit") || check.equals("0")) {
                System.out.println("Thanks for playing");
                System.exit(0);
                break;
            }
            if (definitions.containsKey(userTerm)) {
                System.out.println("You typed: " + userTerm);
                System.out.println("Hey do you want to guess the answer. Press y/n ");
                check = scanner.next();
                if (check.toLowerCase().equals("y")) {
                    System.out.println("Enter the definition that you know for the term " + userTerm);
                    String userDef=scanner.next().toLowerCase();
                    userDefinition(userTerm,userDef);
                } else {
                    System.out.println(definitions.get(userTerm));
                }
                System.out.println("Enter another Term.");
                startProgram();
            }
            errorHandling(userTerm);
            System.out.println("Term is not in Database, would you like to add or y/n?");
            String userAnswer = scanner.next();
            if (userAnswer.toLowerCase().equals("y")) {
                System.out.println("Term Entered: " + userTerm);
                String newKey = userTerm;
                System.out.println("Enter a definition: ");
                String newValue = scanner.next().toLowerCase();
                definitions.put(newKey, newValue);
                System.out.println("Term added to the dictionary");
                System.out.println("Enter another Term.");
                startProgram();
            } else {
                System.out.println("Would you like to quit?");
                String answer = scanner.next();
                if (answer.toLowerCase().equals("y")) {
                    System.out.println("Thanks for playing");
                    break;
                } else {
                    promptUserInput();
                }
            }
        }
    }
    private static void initializeMap() {
        definitions.put("array", "A collection of data items, all of the same type, in which each item's position is uniquely designated by an integer. ");
        definitions.put("field", "A data member of a class. Unless specified otherwise, a field is not static. ");
        definitions.put("import", "A Java keyword used at the beginning of a source file that can specify" +
                "classes or entire packages to be referred to later without including their package names in the reference. ");
        definitions.put("keyword", "Java sets aside words as keywords - these words are reserved by the language itself and" +
                "therefore are not available as names for variables or methods. ");
        definitions.put("return", "A Java keyword used to finish the execution of a method. " +
                " It can be followed by a value required by the method definition. \n");
        definitions.put("boolean", "Refers to an expression or variable that can have only a true or false value." +
                " The Java programming language provides the boolean type and the literal values true and false.");
    }
    private static void promptUserInput() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Starting Java-Trainer! Please enter your name.");
        String name = scanner.nextLine();
        System.out.println("Welcome " +name  +" to Java-Trainer 1.0. Please enter a Java term you would like to learn");
        System.out.println("Please enter 0 or type quit to quit.");
        System.out.println("Input a term for its definition:");
    }

    private static void userDefinition(String key, String def) {
        String compare = definitions.get(key);
        if (compare.equals(def)) {
            System.out.println("That's great,you know what " + key + " means");
        }
        else {
            System.out.println("You almost got it, but it's not the correct definition");
            System.out.println("This is the definition for " + key);
            System.out.println(compare);
        }
    }
    private static void errorHandling(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (lettersInAlpha.contains(input.toLowerCase().charAt(i))) {
            } else {
                System.out.println("Invalid Input:Number detected , Enter term name again ");
                startProgram(); //if the user inputs is not valid
            }
        }
    }
}