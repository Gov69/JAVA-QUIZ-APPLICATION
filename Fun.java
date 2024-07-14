import java.util.Scanner;

public class Fun {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Story story = new Story();
        
        System.out.println("Welcome to the Text Adventure Game!");
        
        story.start(scanner);
        
        System.out.println("Congratulations! You have won the game!");
        scanner.close();
    }
}

class Story {

    public void start(Scanner scanner) {
        System.out.println("You find yourself in a mysterious labyrinth. Do you want to: \n 1. Take the path with the red arrow \n 2. Take the path with the blue arrow");
        int choice = getInput(scanner, 2);
        
        if (choice == 1) {
            redArrowPath(scanner);
        } else {
            blueArrowPath(scanner);
        }
    }
    
    private void redArrowPath(Scanner scanner) {
        System.out.println("You come across a large door. Do you want to:\n1. Open the door\n2. Look for another path");
        int choice = getInput(scanner, 2);
        
        if (choice == 1) {
            System.out.println("You open the door and find yourself in a room filled with dangerous traps. You couldn't escape.");
            endGame();
        } else {
            System.out.println("You find a hidden passage and safely navigate through the labyrinth.");
            afterPassage(scanner);
        }
    }
    
    private void blueArrowPath(Scanner scanner) {
        System.out.println("You encounter a wise old man. Do you want to:\n1. Listen to his advice\n2. Ignore him and move on");
        int choice = getInput(scanner, 2);
        
        if (choice == 1) {
            System.out.println("The old man gives you a magic key that can open any door.");
            afterAdvice(scanner);
        } else {
            System.out.println("You ignore the old man and get lost in the labyrinth.");
            endGame();
        }
    }
    
    private void afterPassage(Scanner scanner) {
        System.out.println("After navigating the passage, you find a beautiful garden. Do you want to:\n1. Explore the garden\n2. Continue through the labyrinth");
        int choice = getInput(scanner, 2);
        
        if (choice == 1) {
            System.out.println("You explore the garden and find a hidden exit that leads you to freedom.");
        } else {
            System.out.println("You continue through the labyrinth and get lost.");
            endGame();
        }
    }
    
    private void afterAdvice(Scanner scanner) {
        System.out.println("After receiving the key, you encounter a locked gate. Do you want to:\n1. Use the magic key\n2. Try to climb over the gate");
        int choice = getInput(scanner, 2);
        
        if (choice == 1) {
            System.out.println("You use the magic key and escape the labyrinth.");
        } else {
            System.out.println("You try to climb over the gate but fall and get injured.");
            endGame();
        }
    }
    
    private void endGame() {
        System.out.println("Game Over. Try again.");
        System.exit(0);
    }

    private int getInput(Scanner scanner, int options) {
        int choice = -1;
        while (choice < 1 || choice > options) {
            System.out.println("Enter a number between 1 and " + options + ":");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice < 1 || choice > options) {
                    System.out.println("Invalid choice. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
        }
        scanner.nextLine(); // Clear the buffer after the correct integer input
        return choice;
    }
}
