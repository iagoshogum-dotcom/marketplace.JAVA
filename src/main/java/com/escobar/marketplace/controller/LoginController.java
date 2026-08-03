package com.escobar.marketplace.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;


import java.io.IOException;

public class LoginController {
    @FXML
    private MediaView mediaView;

    private MediaPlayer mediaPlayer;

    @FXML
    public void initialize() {

        String caminho = getClass()
                .getResource("/com/escobar/marketplace/videos/carros.mp4")
                .toExternalForm();

        Media media = new Media(caminho);

        mediaPlayer = new MediaPlayer(media);

        mediaView.setMediaPlayer(mediaPlayer);

        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

        mediaPlayer.play();
    }
    @FXML
    private TextField usuario;

    @FXML
    private PasswordField senha;

    @FXML
    private TextFlow senhaErrada;
    private final String usuarioCadastrado = "iago";
    private final String senhaCadastrada = "123";


    @FXML
    protected void aoApertarBotao() throws IOException {
        senhaErrada.setVisible(false);
        if ( usuarioCadastrado.equalsIgnoreCase(usuario.getText()) && senhaCadastrada.equals(senha.getText())){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/escobar/marketplace/home.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("home");
            stage.show();
        }else{
            senhaErrada.setVisible(true);
        }

    }
    @FXML
    protected void aoEsquecerSenha(){
        System.out.println("Voce esqueceu sua senha!");
    }
}
