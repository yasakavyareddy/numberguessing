import java.util.Random;
import javax.swing.JOptionPane;

class n {
    public static void main(String[] args) {
        int num1= 1;
        int num2 = 100;
        int totalAttempts = 7;
        int pts = 0;
        boolean playAgain = true;
        
        while (playAgain) {
            int num = randomNumber(num1, num2);
            int attempts = 0;
            
            JOptionPane.showMessageDialog(null, "Welcome to Number Guessing Game!");
            JOptionPane.showMessageDialog(null, "Here you go!");
            while (true) {
                String guessValue = JOptionPane.showInputDialog("Guess a number between " + num1 + " and " + num2 + ":");
                if (guessValue == null) 
                {
                    JOptionPane.showMessageDialog(null, "Game over!");
                    playAgain = false;
                    break;
                }
                
                int guess = Integer.parseInt(guessValue);
                attempts++;
                
                if (guess == num) {
                    int points = totalAttempts - attempts + 10;
                    pts += points;
                    JOptionPane.showMessageDialog(null, "Congratulations! You got the correct answer!\nAttempts: " + attempts + "\nPoints earned: " + points + "\nTotal points: " + pts);
                    break;
                } else if (guess < num) {
                    JOptionPane.showMessageDialog(null, "Too low! Try again");
                } else {
                    JOptionPane.showMessageDialog(null, "Too high! Try again");
                }
                
                if (attempts >= totalAttempts) {
                    JOptionPane.showMessageDialog(null, "Game over! You have reached the max number of attempts.\nThe correct number is: " + num);
                    break;
                }
            }
            
            int option = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "play again", JOptionPane.YES_NO_OPTION);
            
            if (option == JOptionPane.NO_OPTION) {
                playAgain = false;
            }
        }
    }
    
    public static int randomNumber(int num1, int num2) {
        Random r = new Random();
        return r.nextInt(num2 - num1 + 1) + num1;
    }
}