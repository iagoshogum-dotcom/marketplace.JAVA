package com.escobar.marketplace.util;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.function.Consumer;

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

    public void trocarTela(ActionEvent event, String telaFXML, String titulo) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/escobar/marketplace/"+telaFXML));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(titulo);
        stage.setScene(scene);
        stage.show();
    }
    public <T> T telaDeEdicao(ActionEvent event, String telaFXML, String titulo, Consumer<T> abrirEdicao) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/escobar/marketplace/"+telaFXML));
        Parent novoRoot = fxmlLoader.load();
        T controler = fxmlLoader.getController();
        if (abrirEdicao != null){
            abrirEdicao.accept(controler);
        }

        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene = stage.getScene();
        scene.setRoot(novoRoot);
        stage.setTitle(titulo);
        stage.setScene(scene);
        stage.show();
        return controler;
    }

    }

