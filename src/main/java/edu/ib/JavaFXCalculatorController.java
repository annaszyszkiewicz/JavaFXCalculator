package edu.ib;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * klasa zarzadzajaca wyswietlanym tekstem
 */
public class JavaFXCalculatorController {

    Calculate x = new Calculate();

    private String operation = "";
    private boolean previousStep = true;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textInput;

    @FXML
    private TextField textNext;


    /**
     * metoda zmieniajaca widoczny tekst po kliknieciu "="
     * dodaje wybrana ostatnio liczbe oraz  "=" do zapisanego rownania
     * oraz powoduje wykonanie wybranego wcześniej działania
     *
     * @param event przenosi informacje o wywołaniu metody
     */
    @FXML
    void calculate(ActionEvent event) {
        if (textNext.getText().contains("=")) {
            String o = textNext.getText();
            switch (operation) {
                case "+" -> {
                    textInput.setText(x.add(textInput.getText(), o.substring(o.lastIndexOf("+") + 1, o.length() - 1)));
                    o = o.substring(o.lastIndexOf("+") + 1, o.length() - 1);
                }
                case "-" -> {
                    textInput.setText(x.sub(textInput.getText(), o.substring(o.lastIndexOf("-") + 1, o.length() - 1)));
                    o = o.substring(o.lastIndexOf("-") + 1, o.length() - 1);
                }
                case "/" -> {
                    textInput.setText(x.div(textInput.getText(), o.substring(o.lastIndexOf("/") + 1, o.length() - 1)));
                    o = o.substring(o.lastIndexOf("/") + 1, o.length() - 1);
                }
                case "*" -> {
                    textInput.setText(x.multi(textInput.getText(), o.substring(o.lastIndexOf("*") + 1, o.length() - 1)));
                    o = o.substring(o.lastIndexOf("*") + 1, o.length() - 1);
                }
            }
            if (!textNext.getText().equals("0="))
                textNext.setText(x.getValue() + operation + o + "=");
        } else {
            textNext.setText(textNext.getText() + textInput.getText() + "=");
            switch (operation) {
                case "+" -> textInput.setText(x.add(textInput.getText(), x.getValue()));
                case "-" -> textInput.setText(x.sub(textInput.getText(), x.getValue()));
                case "/" -> textInput.setText(x.div(textInput.getText(), x.getValue()));
                case "*" -> textInput.setText(x.multi(textInput.getText(), x.getValue()));
            }
        }
    }

    /**
     * metoda zmieniajaca widoczny teskt po kliknięciu "<--"
     * usuwa ostatnia widoczna cyfre jesli wynikiem operacji nie jest tylko 0
     *
     * @param event przenosi informacje o wywołaniu metody
     */
    @FXML
    void undo(ActionEvent event) {
        if (!textInput.getText().equals("0")) {
            textInput.setText(textInput.getText().substring(0, textInput.getLength() - 1));
            if (textInput.getText().equals(""))
                textInput.setText("0");
            previousStep = false;
        }
    }

    /**
     * metoda zmieniajaca widoczny teskt po kliknieciu "CE"
     * usuwa ostatni wynik dzialan
     *
     * @param event przenosi informacje o wywołaniu metody
     */
    @FXML
    void clear(ActionEvent event) {
        textInput.setText("0");
        if (operation.equals("="))
            textNext.clear();
    }

    /**
     * metoda zmieniajaca widoczny teskt po kliknieciu "C"
     * resetuje dotychczasowe operacje i ich wyniki
     *
     * @param event przenosi informacje o wywołaniu metody
     */
    @FXML
    void clearAll(ActionEvent event) {
        textInput.setText("0");
        textNext.clear();
        x.setValue("");
        operation = "";
    }

    /**
     * metoda zmieniajaca widoczny teskt po kliknieciu "+"
     * dodaje wybrana ostatnio liczbe oraz  "+" do zapisanego rownania
     * oraz wykonuje działanie dodawania
     *
     * @param event przenosi informacje o wywołaniu metody
     */
    @FXML
    void addition(ActionEvent event) {
        if (textNext.getText().contains("="))
            textNext.setText(x.getValue() + "+");
        else if (!previousStep || !operation.equals("+")) {
            textNext.setText(textNext.getText() + textInput.getText() + "+");
            if (x.getValue().isEmpty())
                x.setValue(textInput.getText());
            else if (!textNext.getText().endsWith("+"))
                textNext.setText(textNext.getText().substring(0, textNext.getLength() - 1) + "+");
            else {
                switch (operation) {
                    case "+" -> textInput.setText(x.add(textInput.getText(), x.getValue()));
                    case "-" -> textInput.setText(x.sub(textInput.getText(), x.getValue()));
                    case "/" -> textInput.setText(x.div(textInput.getText(), x.getValue()));
                    case "*" -> textInput.setText(x.multi(textInput.getText(), x.getValue()));
                }
            }
        }
        operation = "+";
        previousStep = true;
    }

    /**
     * metoda zmieniajaca widoczny teskt po kliknieciu "-"
     * dodaje wybrana ostatnio liczbe oraz  "-" do zapisanego rownania
     * oraz wykonuje działanie odejmowania
     *
     * @param event przenosi informacje o wywołaniu metody
     */
    @FXML
    void subtraction(ActionEvent event) {
        if (textNext.getText().contains("="))
            textNext.setText(x.getValue() + "-");
        else if (!previousStep || !operation.equals("-")) {
            textNext.setText(textNext.getText() + textInput.getText() + "-");
            if (x.getValue().isEmpty())
                x.setValue(textInput.getText());
            else if (!textNext.getText().endsWith("-"))
                textNext.setText(textNext.getText().substring(0, textNext.getLength() - 1) + "-");
            else {
                switch (operation) {
                    case "+" -> textInput.setText(x.add(textInput.getText(), x.getValue()));
                    case "-" -> textInput.setText(x.sub(textInput.getText(), x.getValue()));
                    case "/" -> textInput.setText(x.div(textInput.getText(), x.getValue()));
                    case "*" -> textInput.setText(x.multi(textInput.getText(), x.getValue()));
                }
            }

        }
        operation = "-";
        previousStep = true;
    }

    /**
     * metoda zmieniajaca widoczny teskt po kliknieciu "/"
     * dodaje wybrana ostatnio liczbe oraz  "-" do zapisanego rownania
     * oraz wykonuje działanie dzielenia
     *
     * @param event przenosi informacje o wywołaniu metody
     */
    @FXML
    void division(ActionEvent event) {
        if (textNext.getText().contains("="))
            textNext.setText(x.getValue() + "/");
        else if (!previousStep || !operation.equals("/")) {
            textNext.setText(textNext.getText() + textInput.getText() + "/");
            if (x.getValue().isEmpty())
                x.setValue(textInput.getText());
            else if (!textNext.getText().endsWith("/"))
                textNext.setText(textNext.getText().substring(0, textNext.getLength() - 1) + "/");
            else {
                switch (operation) {
                    case "+" -> textInput.setText(x.add(textInput.getText(), x.getValue()));
                    case "-" -> textInput.setText(x.sub(textInput.getText(), x.getValue()));
                    case "/" -> textInput.setText(x.div(textInput.getText(), x.getValue()));
                    case "*" -> textInput.setText(x.multi(textInput.getText(), x.getValue()));
                }
            }
        }
        operation = "/";
        previousStep = true;
    }

    /**
     * metoda zmieniajaca widoczny teskt po kliknieciu "*"
     * dodaje wybrana ostatnio liczbe oraz  "*" do zapisanego rownania
     * oraz wykonuje działanie mnożenia
     *
     * @param event przenosi informacje o wywołaniu metody
     */
    @FXML
    void multiplication(ActionEvent event) {
        if (textNext.getText().contains("="))
            textNext.setText(x.getValue() + "*");
        else if (!previousStep || !operation.equals("*")) {
            textNext.setText(textNext.getText() + textInput.getText() + "*");
            if (x.getValue().isEmpty())
                x.setValue(textInput.getText());
            else if (!textNext.getText().endsWith("*"))
                textNext.setText(textNext.getText().substring(0, textNext.getLength() - 1) + "*");
            else {
                switch (operation) {
                    case "+" -> textInput.setText(x.add(textInput.getText(), x.getValue()));
                    case "-" -> textInput.setText(x.sub(textInput.getText(), x.getValue()));
                    case "/" -> textInput.setText(x.div(textInput.getText(), x.getValue()));
                    case "*" -> textInput.setText(x.multi(textInput.getText(), x.getValue()));
                }
            }
        }
        operation = "*";
        previousStep = true;
    }

    /**
     * metoda zmieniajaca widoczny teskt po kliknieciu "%"
     * zamienia wybrana ostatnio liczbę na procent tej liczby (dzieli liczbę przez 100)
     *
     * @param event przenosi informacje o wywołaniu metody
     */
    @FXML
    void percent(ActionEvent event) {
        textInput.setText(x.pc(textInput.getText()));
        previousStep = true;
        textNext.setText(textInput.getText());
    }

    /**
     * metoda zmieniajaca widoczny teskt po kliknieciu "1/x"
     * zamienia wybrana ostatnio liczbę odwrotnosc tej liczby
     *
     * @param event przenosi informacje o wywołaniu metody
     */
    @FXML
    void reciprocal(ActionEvent event) {
        textInput.setText(x.reverse(textInput.getText()));
        previousStep = false;

    }

    /**
     * metoda zmieniajaca widoczny teskt po kliknieciu "x^2"
     * zamienia wybrana ostatnio liczbę na druga potege tej liczby
     *
     * @param event przenosi informacje o wywołaniu metody
     */
    @FXML
    void toSquare(ActionEvent event) {
        textInput.setText(x.pow(textInput.getText()));
        previousStep = false;
    }

    /**
     * metoda zmieniajaca widoczny teskt po kliknieciu "sqrt(x)"
     * zamienia wybrana ostatnio liczbę na pierwiastek drugiego stopnia tej liczby
     *
     * @param event przenosi informacje o wywołaniu metody
     */
    @FXML
    void extractRoot(ActionEvent event) {
        textInput.setText(x.sqrt(textInput.getText()));
        previousStep = false;

    }

    /**
     * metoda zmieniajaca widoczny teskt po kliknieciu "+/-"
     * zamienia znak wybranej licbzy na przeciwny
     *
     * @param event przenosi informacje o wywołaniu metody
     */
    @FXML
    void changeOfSign(ActionEvent event) {
        textInput.setText(x.sign(textInput.getText()));
        previousStep = false;
    }

    /**
     * dopisuje "0" do wpisywanej liczby lub zamienia wynik na "0"
     * @param event przenosi informacje o wywołaniu metody
     */
    @FXML
    void zero(ActionEvent event) {
        if (previousStep) {
            textInput.setText("0");
            previousStep = false;
        } else if (textNext.getText().endsWith("=")) {
            textInput.setText("0");
            textNext.clear();
            previousStep = false;
        } else if (!textInput.getText().equals("0")) {
            textInput.setText(textInput.getText() + "0");
            previousStep = false;
        }
    }

    /**
     * dopisuje cyfrę do wpisywanej liczby lub zamienia wynik na wybraną cyfrę
     * @param event przenosi informacje o wywołaniu metody
     */
    @FXML
    void write(ActionEvent event) {
        if (textNext.getText().endsWith("=")) {
            textInput.clear();
            textNext.clear();
        }

        switch (((Button) event.getSource()).getText()) {
            case "1":
                if (textInput.getText().equals("0") || previousStep)
                    textInput.setText("1");
                else
                    textInput.setText(textInput.getText() + "1");

                break;
            case "2":
                if (textInput.getText().equals("0") || previousStep)
                    textInput.setText("2");
                else
                    textInput.setText(textInput.getText() + "2");

                break;
            case "3":
                if (textInput.getText().equals("0") || previousStep)
                    textInput.setText("3");
                else
                    textInput.setText(textInput.getText() + "3");

                break;
            case "4":
                if (textInput.getText().equals("0") || previousStep)
                    textInput.setText("4");
                else
                    textInput.setText(textInput.getText() + "4");

                break;
            case "5":
                if (textInput.getText().equals("0") || previousStep)
                    textInput.setText("5");
                else
                    textInput.setText(textInput.getText() + "5");

                break;
            case "6":
                if (textInput.getText().equals("0") || previousStep)
                    textInput.setText("6");
                else
                    textInput.setText(textInput.getText() + "6");

                break;
            case "7":
                if (textInput.getText().equals("0") || previousStep)
                    textInput.setText("7");
                else
                    textInput.setText(textInput.getText() + "7");

                break;
            case "8":
                if (textInput.getText().equals("0") || previousStep)
                    textInput.setText("8");
                else
                    textInput.setText(textInput.getText() + "8");

                break;
            case "9":
                if (textInput.getText().equals("0") || previousStep)
                    textInput.setText("9");
                else
                    textInput.setText(textInput.getText() + "9");

                break;
            case ".":
                if (!textInput.getText().contains(".")) {
                    if (textInput.getText().endsWith(operation) || previousStep)
                        textInput.setText("0.");
                    else
                        textInput.setText(textInput.getText() + ".");
                }
                break;

        }

        previousStep = false;
    }

    /**
     * metoda ustawiająca początkowe wartości programu
     */
    @FXML
    void initialize() {
        assert textInput != null : "fx:id=\"textInput\" was not injected: check your FXML file 'calculator.fxml'.";
        assert textNext != null : "fx:id=\"textNext\" was not injected: check your FXML file 'calculator.fxml'.";
    }
}

