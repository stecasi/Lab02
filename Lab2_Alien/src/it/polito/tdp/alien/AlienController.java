package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	private String stringaInserita;

	private AlienDictionary ad = new AlienDictionary();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInsert;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnClear;

    @FXML
    void doReset(ActionEvent event) {
    	txtInsert.clear();
    	txtResult.clear();
    	ad.getDizionarioM().clear();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	stringaInserita="";
    	stringaInserita = txtInsert.getText();
    	stringaInserita = stringaInserita.toLowerCase();
    	String [] st = stringaInserita.split(" ");
    	
    	if (stringaInserita.matches(".*[a-zA-Z].*")==false){
    	
    	
    	if (st.length==2){
    	String alienWord = st[0];
    	String translation = st[1];
    	
    	ad.addWord(alienWord, translation);
    	
    	txtResult.setText("Parola aggiunta con successo!\n"+ad.getDizionarioM().get(alienWord).getAlienWord()+" "+ad.getDizionarioM().get(alienWord).getTranslation());
    	}
    	
    	if (st.length==1){
    		String alienWord = st[0];
    		if (ad.getDizionarioM().containsKey(alienWord)==false){
    			txtResult.setText("Parola non presente nel dizionario");
    		}
    		else{
    		txtResult.setText(ad.translateWord(alienWord));
    	}
    	}
    
    }
    	
    else{
    	txtResult.setText("Inserisci una parola valida");
    }
    }
    @FXML
    void initialize() {
        assert txtInsert != null : "fx:id=\"txtInsert\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Alien.fxml'.";

    }
}
