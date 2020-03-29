package it.polito.tdp.IndovinaNumero1;

import java.net.URL;
import java.security.InvalidParameterException;
import java.util.ResourceBundle;

import it.polito.tdp.IndovinaNumero1.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class FXMLController {
	
	private Model model;
	
	
	@FXML
    private TextArea txtMessaggi;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnNuova;

    @FXML
    private TextField txtRimasti;

    @FXML
    private HBox layoutTentativo;

    @FXML
    private TextField txtTentativi;

    @FXML
    private Button btnProva;

    

    @FXML
    void DoNuova(ActionEvent event) { 
    	this.model.nuovaPartita();
    	layoutTentativo.setDisable(false);
    	txtMessaggi.clear();
    	txtRimasti.setText(Integer.toString(this.model.gettMax()));
    }

    @FXML
    void DoTentativo(ActionEvent event) {
    	
    	String ts=txtTentativi.getText();
    	int tentativo;
    	try {
    	    tentativo= Integer.parseInt(ts);
    	}
    	catch(NumberFormatException e){
    		txtMessaggi.appendText("Devi Inserire un numero\n");
    		return;    		
    	}
    	int risultato=-1;
    	try {
    		risultato=this.model.tentativo(tentativo); 
    	}catch(IllegalStateException se) {
    		txtMessaggi.appendText(se.getMessage());
    		return;
    	}catch(InvalidParameterException te) {
    		txtMessaggi.appendText(te.getMessage());
    		return;
    	}
    	
    	
    	if(risultato==0) {
    		txtMessaggi.appendText("Hai vinto\n");
    	}else if(risultato==-1) {
    		txtMessaggi.appendText("Troppo basso\n");    		
    	}else {
    		txtMessaggi.appendText("Troppo Alto\n");
    	} 
    	txtRimasti.setText(Integer.toString(this.model.gettMax()-this.model.getTentativiFatti()));

    }

    @FXML
    void initialize() {
        assert btnNuova != null : "fx:id=\"btnNuova\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRimasti != null : "fx:id=\"txtRimasti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert layoutTentativo != null : "fx:id=\"layoutTentativo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTentativi != null : "fx:id=\"txtTentativi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnProva != null : "fx:id=\"btnProva\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMessaggi != null : "fx:id=\"txtMessaggi\" was not injected: check your FXML file 'Scene.fxml'.";
        //this.model= new Model();
    }
    public void setModel(Model model) {
    	this.model=model;    	
    }
}
