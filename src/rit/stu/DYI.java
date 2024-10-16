package rit.stu;

import rit.cs.*;

import java.io.*;
import java.util.*;

/**
 * DYI class that is responsible for reading the text file, parsing it, and computing it.
 * It contains the main function, DYI constructor, processingLoop and parse helper methods.
 * Exceptions are also accounted for by using try and catch.
 *
 * @author RIT CS
 * @author Jimmy Li
 */
public class DYI{
    /**
     * The main program for DYI which welcomes the user and checks if
     * the file in the argument exists. If it exists, it will create a DYI
     * class and call the processingLoop() method which runs the rest of
     * program. If the file doesn't exist, it will print to the user that
     * the file does not exist and end the program.
     *
     * @param args filename of the symbol table
     * @throws DerpException there are not enough tokens for an expression or
     *                          a variable is referenced that does not exist or
     *                          there are too many tokens for an expression
     */
    public static void main(String[] args) throws DerpException {
        System.out.println("Welcome to Derp Your Interpreter v2.0 :)");
        try {
            DYI dyi = new DYI(args[0]);
            dyi.processingLoop();
        }
        catch (IOException e) {
            System.out.println("Symbol table error: " + args[0] + " does not exist!");
        }
    }

    /** The symbol table represented as a HashMap where the key is the variable and the value is its corresponding value. */
    static HashMap<String, Integer> symbolTable = new HashMap<>();

    /**
     * The constructor of DYI which takes a filename and reads it to create
     * a HashMap that represents it. This utilizes the BufferedReader where
     * each line is read and split to be placed into symbolTable. The HashMap's
     * key and value is then printed. If the file doesn't exist, the method will
     * catch it and throw a IOException which the main method will catch.
     *
     * @param filename the filename which has the symbol table
     * @throws IOException file not found
     */
    public DYI(String filename) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                String[] list = line.split(" ");
                symbolTable.put(list[0], Integer.valueOf(list[1]));
                line = reader.readLine();
            }
            reader.close();
            for (String var : symbolTable.keySet()) {
                System.out.println(var + ": " + symbolTable.get(var));
            }
        } catch (FileNotFoundException e) {
            throw new IOException(e);
        }
    }

    /**
     * The loop method that is responsible for reading in prefix expressions from the user
     * until they wish to quit. The user is prompted with ">" and then the program waits
     * for the user to enter the expression. Once entered, the program builds the parse tree,
     * it then emits the inorder string of the expression and displays the evaluation of it.
     * This process is repeated until the user enters "quit" which causes the program to display
     * a closing message and then the program gracefully terminates.
     *
     * @throws DerpException there are not enough tokens for an expression or
     *                          a variable is referenced that does not exist or
     *                          there are too many tokens for an expression
     */
    public void processingLoop() throws DerpException {
        System.out.print("> ");
        Scanner scan = new Scanner(System.in);
        LinkedList<String> linkedList = new LinkedList<>(List.of(scan.nextLine().split(" ")));
        while (!linkedList.contains("quit")) {
            Expression expression = parse(linkedList, true);
            try {
                assert expression != null;
                System.out.println("Emit:" + expression.emit());
                System.out.println("Evaluate: " + expression.evaluate());
            }
            catch (NullPointerException ignored) {

            }
            finally {
                System.out.print("> ");
                linkedList = new LinkedList<>(List.of(scan.nextLine().split(" ")));
            }
        }
        System.out.println("Goodbye! :(");
    }

    /**
     * The helper function for building and returning the parse tree. It takes the current
     * list of tokens as an argument and returns the appropriate Expression node for the
     * token at the front of the list. It is a recursive function that removes the front
     * token from the list, and based on the string, it builds and returns the appropriate
     * concrete Expression node by recursively calling parse to complete the work. This
     * recursive process proceeds until an integer is encountered which is the base case.
     *
     * @param tokens the list of tokens which contains the variable, integers, and expressions
     * @param firstLoop true or false if it's the first recursion in the loop
     * @return the expression from the given tokens
     * @throws DerpException there are not enough tokens for an expression or
     *                          a variable is referenced that does not exist or
     *                          there are too many tokens for an expression
     */
    public static Expression parse(LinkedList<String> tokens, boolean firstLoop) throws DerpException {
        try {
            if (firstLoop) {
                int count = 0;
                for (String token : tokens) {
                    if (token.matches("^[a-zA-Z].*") || token.matches("-?\\d+(\\.\\d+)?")) {
                        count++;
                    }
                }
                if (tokens.size() - count > count - 1) {
                    throw new DerpException("Parse error: Not enough tokens!");
                }
                if (tokens.size() - count < count - 1) {
                    throw new DerpException("Parse error: Extra tokens remain!");
                }
            }
            String token = tokens.remove(0);
            if (token.matches("^[a-zA-Z].*")) {
                try {
                    return new VariableExpression(token, symbolTable.get(token));
                }
                catch (NullPointerException e) {
                    throw new DerpException("Symbol table error: " + token + " does not exist!");
                }
            }
            return switch (token) {
                case "+" -> new AddExpression(parse(tokens, false), parse(tokens, false));
                case "/" -> new DivExpression(parse(tokens, false), parse(tokens, false));
                case "%" -> new ModExpression(parse(tokens, false), parse(tokens, false));
                case "*" -> new MulExpression(parse(tokens, false), parse(tokens, false));
                case "-" -> new SubExpression(parse(tokens, false), parse(tokens, false));
                default -> new IntExpression(Integer.parseInt(token));
            };
        }
        catch (DerpException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
