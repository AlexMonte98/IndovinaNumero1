package it.polito.tdp.IndovinaNumero1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class FXMLController {
	private final int nMax=100;
	private final int tMax=8;
	private int segreto;
	private int tentativiFatti;
	private boolean inGioco=false;
	
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
    	this.segreto=(int)((Math.random())*nMax)+1;
    	this.tentativiFatti=0;
    	this.inGioco=true;
    	
    	layoutTentativo.setDisable(false);
    	txtMessaggi.clear();
    	txtRimasti.setText(Integer.toString(tMax));
    	 

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
    	this.tentativiFatti++;
    	//pROVARE A LEVARE RIGHE DI CODICE IN PIU'
    	if(tentativo<this.segreto) {
    		txtMessaggi.appendText("Tentativo troppo basso\n");
    	}else {
    		txtMessaggi.appendText("Tentativo troppo alto\n");
    	}
    	this.txtRimasti.setText(Integer.toString(tMax-tentativiFatti));
    	txtTentativi.clear();
    	if(tentativo==segreto) {
    		txtMessaggi.appendText("Hai Vinto, con "+tentativiFatti+" tentativi");
    		layoutTentativo.setDisable(true);
    		this.inGioco=false;    		
    		return;
    	}
    	if(tentativiFatti==tMax) {
    		txtMessaggi.appendText("Perso, era "+ this.segreto);
    		layoutTentativo.setDisable(true);
    		this.inGioco=false;    		
    		return;
    	}
    	
    	

    }

    @FXML
    void initialize() {
        assert btnNuova != null : "fx:id=\"btnNuova\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRimasti != null : "fx:id=\"txtRimasti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert layoutTentativo != null : "fx:id=\"layoutTentativo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTentativi != null : "fx:id=\"txtTentativi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnProva != null : "fx:id=\"btnProva\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMessaggi != null : "fx:id=\"txtMessaggi\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
