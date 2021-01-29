import java.util.Scanner;
//Joe Boxberger
//Main class
public class TestQuizzer_5Boxberger {
    public static void main(String args[]){
        GameQuiz quiz = new GameQuiz();
        quiz.askQuestions();
        quiz.displayResults();
    }
}

//Quiz class, holds information and results from quiz, as well as quiz questions and logic for 
class GameQuiz {
    private int score = 0;
    private String name;
    Scanner userInput = new Scanner(System.in);

    //-----methods-----
    //mutators
    public void askQuestions(){
        //Question 1
        System.out.print("1) What is your name? \nAnswer: ");
        name = userInput.nextLine();

        //Question 2
        System.out.println("\n2) What platform do you play games on? \n A) Console (Xbox, Playstation, Switch) \n B) PC \n C) Mobile \n D) Multiple Platforms");
        System.out.print("Answer (A/B/C/D): ");
        String lastAnswer = userInput.nextLine().toUpperCase();
        //verify answer is valid
        while (!(lastAnswer.equals("A") || lastAnswer.equals("B") || lastAnswer.equals("C") || lastAnswer.equals("D"))) {
            System.out.print("Invalid input. The possible choices are A, B, C, or D. Try again: ");
            lastAnswer = userInput.nextLine().toUpperCase();
        }
        if (lastAnswer.equals("A") || lastAnswer.equals("B")) {
            score += 2;
        }
        else if (lastAnswer.equals("C")) {
            score += 1;
        }
        else {
            score += 4;
        }

        //Question 3
        System.out.println("\n3) What genre do you play the most? \n A) FPS \n B) MOBA \n C) Sports \n D) RPG \n E) Sanbox/Survival \n F) Idle");
        System.out.print("Answer (A/B/C/D/E/F): ");
        lastAnswer = userInput.nextLine().toUpperCase();
        //verify answer is valid
        while (!(lastAnswer.equals("A") || lastAnswer.equals("B") || lastAnswer.equals("C") || lastAnswer.equals("D") || lastAnswer.equals("E") || lastAnswer.equals("F"))) {
            System.out.print("Invalid input. The possible choices are A/B/C/D/E/F. Try again: ");
            lastAnswer = userInput.nextLine().toUpperCase();
        }
        if (lastAnswer.equals("A")) {
            score += 5;
        }
        else if (lastAnswer.equals("B")) {
            score += 5;
        }
        else if (lastAnswer.equals("C")) {
            score += 3;
        }
        else if (lastAnswer.equals("D")) {
            score += 4;
        }
        else if (lastAnswer.equals("E")) {
            score += 4;
        }
        else if (lastAnswer.equals("F")) {
            score += 2;
        }

        //Question 4
        System.out.println("\n4) How many hours do you play each day? \n A) I don't play videogames that often \n B) 1-2 \n C) 2-4 \n D) 4+");
        System.out.print("Answer (A/B/C/D): ");
        lastAnswer = userInput.nextLine().toUpperCase();
        //verify answer is valid
        while (!(lastAnswer.equals("A") || lastAnswer.equals("B") || lastAnswer.equals("C") || lastAnswer.equals("D"))) {
            System.out.print("Invalid input. The possible choices are A, B, C, or D. Try again: ");
            lastAnswer = userInput.nextLine().toUpperCase();
        }
        if (lastAnswer.equals("B")){
            score += 2;
        }
        else if (lastAnswer.equals("C")){
            score += 4;
        }
        else if (lastAnswer.equals("D")){
            score += 6;
        }

        //Question 5
        System.out.print("\n5) Do you play videogames in a competitive environment? (Y/N): ");
        lastAnswer = userInput.nextLine().toUpperCase();
        //verify answer is valid
        while (!(lastAnswer.equals("Y") || lastAnswer.equals("N"))) {
            System.out.print("Invalid input. The possible choices are Y or N. Try again: ");
            lastAnswer = userInput.nextLine().toUpperCase();
        }
        if (lastAnswer.equals("Y")) {
            score += 5;
        }
        else {
            score += 1;
        }

        //Question 7
        System.out.print("\n6) Do you consider playing videogames one of your main hobbies or pastimes? (Y/N): ");
        lastAnswer = userInput.nextLine().toUpperCase();
        //verify answer is valid
        while (!(lastAnswer.equals("Y") || lastAnswer.equals("N"))) {
            System.out.print("Invalid input. The possible choices are Y or N. Try again: ");
            lastAnswer = userInput.nextLine().toUpperCase();
        }
        if (lastAnswer.equals("Y")) {
            score += 3;
        }
        else {
            score += 1;
        }

        //Question 7
        System.out.print("\n7) How many years have you been playing video games? \nAnswer (Type a whole number): ");
        score += userInput.nextInt();
    }

    //accessors
    public int getScore() {
        return score;
    }

    public void displayResults() {
        System.out.println("\n" + name + " got a " + score + " on the gaming quiz!");
        if (score >= 30) {
            System.out.println("You're a god gamer! Wow!");
        }
        else if (score >= 20) {
            System.out.println("You're an experienced gamer! Nice!");
        }
        else if (score >= 15) {
            System.out.println("You're an average gamer! Welcome to the club!");
        }
        else if (score >= 10) {
            System.out.println("You like to play video games casually! Hope you keep having fun!");
        }
        else {
            System.out.println("It seems you don't play video games that much, but don't worry there are plenty of games out there for you to try!");
        }
    }
}