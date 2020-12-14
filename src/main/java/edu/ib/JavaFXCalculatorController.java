package edu.ib;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class JavaFXCalculatorController {
    Calculate x = new Calculate();

    private String operation = "+";
    private boolean previousStep = true;
    private String result = "0";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textInput;

    @FXML
    private TextField textNext;

    @FXML
    private TextArea textHistory;

    @FXML
    void calculate(ActionEvent event) {

    }

    @FXML
    void undo(ActionEvent event) {
        if (!textInput.getText().equals("0")) {
            textInput.setText(textInput.getText().substring(0, textInput.getLength() - 1));
            if (textInput.getText().equals(""))
                textInput.setText("0");
            previousStep = false;
        }
    }

    @FXML
    void clear(ActionEvent event) {
        textInput.setText("0");
        if (operation == "=")
            textNext.clear();
    }

    @FXML
    void clearAll(ActionEvent event) {
        textInput.setText("0");
        textNext.clear();
        result = "0";
    }

    @FXML
    void addition(ActionEvent event) {
        if (previousStep && !textNext.getText().endsWith("+"))
            textNext.setText(textNext.getText().substring(0, textNext.getLength() - 1) + "+");

        else if (textNext.getText().endsWith(operation) && !previousStep) {
            textNext.setText(textNext.getText() + textInput.getText() + "+");
            textInput.setText(result);

        } else if (!previousStep)
            textNext.setText(textNext.getText() + textInput.getText() + "+");

        operation = "+";
        previousStep = true;
        result = textInput.getText();
    }

    @FXML
    void subtraction(ActionEvent event) {
        if (previousStep && !textNext.getText().endsWith("-"))
            textNext.setText(textNext.getText().substring(0, textNext.getLength() - 1) + "-");

        else if (textNext.getText().endsWith(operation) && !previousStep) {
            textNext.setText(textNext.getText() + textInput.getText() + "-");
            textInput.setText(result);

        } else if (!previousStep)
            textNext.setText(textNext.getText() + textInput.getText() + "-");

        operation = "-";
        previousStep = true;
        result = textInput.getText();
    }

    @FXML
    void division(ActionEvent event) {
        if (previousStep && !textNext.getText().endsWith("/"))
            textNext.setText(textNext.getText().substring(0, textNext.getLength() - 1) + "/");

        else if (textNext.getText().endsWith(operation) && !previousStep) {
            textNext.setText(textNext.getText() + textInput.getText() + "/");
            //textInput.setText(result);

        } else if (!previousStep)
            textNext.setText(textNext.getText() + textInput.getText() + "/");

        operation = "/";
        previousStep = true;
        //result = textInput.getText();
        System.out.println(result);
    }

    @FXML
    void multiplication(ActionEvent event) {
        if (previousStep && !textNext.getText().endsWith("*"))
            textNext.setText(textNext.getText().substring(0, textNext.getLength() - 1) + "*");

       else if (textNext.getText().endsWith(operation) && !previousStep) {
            textNext.setText(textNext.getText() + textInput.getText() + "*");
            textInput.setText(result);

        } else if (!previousStep)
            textNext.setText(textNext.getText() + textInput.getText() + "*");

        operation = "*";
        previousStep = true;
        result = textInput.getText();
    }

    @FXML
    void percent(ActionEvent event) {
        textInput.setText(x.pc(textInput.getText()));
        previousStep = true;
    }

    @FXML
    void reciprocal(ActionEvent event) {
        textInput.setText(x.reverse(textInput.getText()));
        previousStep = true;
    }

    @FXML
    void toSquare(ActionEvent event) {
        textInput.setText(x.pow(textInput.getText()));
        previousStep = true;
    }

    @FXML
    void extractRoot(ActionEvent event) {
        textInput.setText(x.sqrt(textInput.getText()));
        previousStep = true;
    }

    @FXML
    void changeOfSign(ActionEvent event) {
        textInput.setText(x.sign(textInput.getText()));
        previousStep = false;
    }

    @FXML
    void zero(ActionEvent event) {
        if (!textInput.getText().equals("0")) {
            textInput.setText(textInput.getText() + "0");
            previousStep = false;
        }
    }

    @FXML
    void write(ActionEvent event) {
        if (operation == "=") {
            textNext.clear();
        }
        switch (((Button) event.getSource()).getText()) {
            case "1":
                if (textInput.getText().equals("0") || previousStep == true) {
                    textInput.setText("1");
                } else {
                    textInput.setText(textInput.getText() + "1");
                }
                break;
            case "2":
                if (textInput.getText().equals("0") || previousStep == true) {
                    textInput.setText("2");
                } else {
                    textInput.setText(textInput.getText() + "2");
                }
                break;
            case "3":
                if (textInput.getText().equals("0") || previousStep) {
                    textInput.setText("3");
                } else {
                    textInput.setText(textInput.getText() + "3");
                }
                break;
            case "4":
                if (textInput.getText().equals("0") || previousStep) {
                    textInput.setText("4");
                } else {
                    textInput.setText(textInput.getText() + "4");
                }
                break;
            case "5":
                if (textInput.getText().equals("0") || previousStep) {
                    textInput.setText("5");
                } else {
                    textInput.setText(textInput.getText() + "5");
                }
                break;
            case "6":
                if (textInput.getText().equals("0") || previousStep) {
                    textInput.setText("6");
                } else {
                    textInput.setText(textInput.getText() + "6");
                }
                break;
            case "7":
                if (textInput.getText().equals("0") || previousStep == true) {
                    textInput.setText("7");
                } else {
                    textInput.setText(textInput.getText() + "7");
                }
                break;
            case "8":
                if (textInput.getText().equals("0") || previousStep == true) {
                    textInput.setText("8");
                } else {
                    textInput.setText(textInput.getText() + "8");
                }
                break;
            case "9":
                if (textInput.getText().equals("0") || previousStep) {
                    textInput.setText("9");
                } else {
                    textInput.setText(textInput.getText() + "9");
                }
                break;
            case ".":
                if (!textInput.getText().contains("."))
                    if (textInput.getText().endsWith(operation) || previousStep)
                        textInput.setText("0.");
                    else
                        textInput.setText(textInput.getText() + ".");

                break;

        }
        previousStep = false;
        switch (operation) {
            case "+" -> result = x.add(result, textInput.getText());
            case "-" -> result = x.sub(result, textInput.getText());
            case "/" -> result = x.div(result, textInput.getText());
            case "*" -> result = x.multi(result, textInput.getText());
        }
    }


    @FXML
    void initialize() {
        assert textInput != null : "fx:id=\"textInput\" was not injected: check your FXML file 'calculator.fxml'.";
        assert textNext != null : "fx:id=\"textNext\" was not injected: check your FXML file 'calculator.fxml'.";
        assert textHistory != null : "fx:id=\"textHistory\" was not injected: check your FXML file 'calculator.fxml'.";

    }
}

