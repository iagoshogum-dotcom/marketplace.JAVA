package com.escobar.marketplace.controller;

import com.escobar.marketplace.model.Usuario;
import com.escobar.marketplace.model.UsuarioDAO;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;


import java.io.IOException;
import java.util.Optional;

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
    private TextFlow senhaErrada;

    @FXML
    private PasswordField senha;

    private final UsuarioDAO bdUsuario = UsuarioDAO.getInstance();

    @FXML
    protected void aoApertarBotao() throws IOException {
        senhaErrada.setVisible(false);
        String udsuarioDigitado = usuario.getText().toLowerCase();
        String senhaDigitada = senha.getText();
        Optional<Usuario> usuarioEncontrado = bdUsuario.buscarPorEmail(udsuarioDigitado);

        if ( usuarioEncontrado.isPresent() && usuarioEncontrado.get().getSenha().equals(senhaDigitada)) {
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
    protected void aoSemCadastro(Event event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/escobar/marketplace/cadastro.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Visualizar Estoque");
        stage.show();
    }
}
