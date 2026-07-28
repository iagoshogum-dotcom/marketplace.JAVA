package com.escobar.marketplace.util;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GerenciadorTela {
    private static GerenciadorTela instancia;
    private GerenciadorTela(){

    }

    public static GerenciadorTela getInstance(){
        if (instancia == null){
            instancia = new GerenciadorTela();

        }
        return instancia;
    }

    public void trocarTela(ActionEvent event, String caminhoFXML, String titulo) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(caminhoFXML));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(titulo);
        stage.setScene(scene);
        stage.show();
    }
    }

