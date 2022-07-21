package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

///extend application
public class Exercise15_4 extends Application{

	///declare the three double's that we will work with before user makes changes.
    double num1 = 0;
    double num2 = 0;
    double ansr = 0;

    @Override /// always override to begin program with Javafx
    public void start(Stage primaryStage) throws Exception {

    	///Make the first horizontal plane that will hold the variables
        HBox numberPane = new HBox();
        numberPane.setSpacing(5);
        numberPane.setAlignment(Pos.CENTER);

        Label field1 = new Label("Number 1:");
        TextField tfNum1 = new TextField();
        ///I found out how to change the width of a field on a Youtube Video I watched a few weeks ago and decided to try it. 
        tfNum1.setPrefWidth(75);

        Label tfNum2 = new Label("Number 2:");
        TextField tfNumber2 = new TextField();
        tfNumber2.setPrefWidth(75);

        Label lblResult = new Label("Result :");
        TextField tfResult = new TextField();
        ///Ensure user can't alter the text field, per lines 44 and 45 LoanCalculator.java on page 610
        tfResult.setEditable(false);
        tfResult.setPrefWidth(75);
        
        ///add these labels and text fields to the actual pane
        numberPane.getChildren().addAll(field1, tfNum1,tfNum2, tfNumber2,lblResult, tfResult);

        
        ///Going to make the four different math possibilities (add, sub, multiply, divide).
        ///Will use Lambda Expressions for these....I hope.
        
        //Make it so that the add button does simple addition
        Button btAdd = new Button("Add");
        btAdd.setOnAction(e -> {
        	ansr = Double.parseDouble(tfNum1.getText()) + Double.parseDouble(tfNumber2.getText());
            tfResult.setText(ansr + "");
        });

        ///pretty much copy the code from above but make it subtract.
        Button btSubtract = new Button("subtract");
        btSubtract.setOnAction(e -> {
        	ansr = Double.parseDouble(tfNum1.getText()) - Double.parseDouble(tfNumber2.getText());
            tfResult.setText(ansr + "");
        });
        
        ///copy paste then make it multiply
        Button btMultiply = new Button("Multiply");
        btMultiply.setOnAction(e -> {
        	ansr = Double.parseDouble(tfNum1.getText()) * Double.parseDouble(tfNumber2.getText());
            tfResult.setText(ansr + "");
        });
        
        ///same code but divide
        Button btDivide = new Button("Divide");
        btDivide.setOnAction(e -> {
        	ansr = Double.parseDouble(tfNum1.getText()) / Double.parseDouble(tfNumber2.getText());
            tfResult.setText(ansr + "");
        });

        ///add the buttons that I just made to the bottom of the pan and setAlignment so they stay at the bottom
        HBox operatorsPane = new HBox();
        operatorsPane.setSpacing(10);
        operatorsPane.setAlignment(Pos.CENTER);
        operatorsPane.getChildren().addAll(btAdd, btSubtract, btMultiply, btDivide);

        BorderPane borderPane = new BorderPane(numberPane);
        BorderPane.setMargin(numberPane, new Insets(5, 5, 5, 5));

        borderPane.setBottom(operatorsPane);
        BorderPane.setMargin(operatorsPane, new Insets(5, 5, 5, 5));
        primaryStage.setScene(new Scene(borderPane, borderPane.getPrefWidth(),borderPane.getPrefWidth()));
        primaryStage.setTitle("Exercise15_04"); //name it
        primaryStage.show(); // claim it!
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}