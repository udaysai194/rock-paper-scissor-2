package application;



import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainController {
	
	int userScore=0,comScore=0,comChoice=0;
	@FXML
	private Label userChoiceLabel,comChoiceLabel,userScoreLabel,comScoreLabel;
	@FXML
	private Button rockButton,paperButton,scissorButton;
	private Image scissorImage = new Image(getClass().getResource("images/cartoon-scissors-clipart-1TwoTwo.png").toExternalForm());
	private Image rockImage = new Image(getClass().getResource("images/rock-with-sunglasses-hi.png").toExternalForm());
	private Image paperImage = new Image(getClass().getResource("images/rock-paper-scissors-emoji-cartoon-015-512.png").toExternalForm());
	
	@FXML
	private ImageView userChoiceImage,comChoiceImage;
	
	public void generateRandom(ActionEvent event) {
		String choice = ((Button)event.getSource()).getText();
		
		if(choice.equalsIgnoreCase("rock")) {
			userChoiceLabel.setText("ROCK");
			userChoiceImage.setImage(rockImage);
			randomChoice();
			score(0);
		}
		else if(choice.equalsIgnoreCase("paper")) {
			userChoiceLabel.setText("PAPER");
			userChoiceImage.setImage(paperImage);
			randomChoice();
			score(1);
		}
		else if(choice.equalsIgnoreCase("scissor")) {
			userChoiceLabel.setText("SCISSOR");
			userChoiceImage.setImage(scissorImage);
			randomChoice();
			score(2);
		}
		else {
			userChoiceLabel.setText("UDAY");
		}
	}
	
	public void randomChoice() {
		String[] arrayLabel = {"ROCK","PAPER","SCISSOR"};
		Random rand = new Random();
		comChoice = rand.nextInt(3);
		comChoiceLabel.setText(arrayLabel[comChoice]);
		if(comChoice == 0)
			comChoiceImage.setImage(rockImage);
		else if(comChoice == 1)
			comChoiceImage.setImage(paperImage);
		else
			comChoiceImage.setImage(scissorImage);
	}
	
	public void score(int a) {
		if((a==0 && comChoice==0) || (a==1 && comChoice==1) || (a==2 && comChoice==2)) {
			userScore += 0;
			comScore += 0;
		}
		else if((a==0 && comChoice==1) || (a==1 && comChoice==2) || (a==2 && comChoice==0)) {
			comScore += 1;
		    comScoreLabel.setText(Integer.toString(comScore));
		}
		else if((a==0 && comChoice==2) || (a==1 && comChoice==0) || (a==2 && comChoice==1)) {
			userScore += 1;
			userScoreLabel.setText(Integer.toString(userScore));
		}
	}
	
	
}
