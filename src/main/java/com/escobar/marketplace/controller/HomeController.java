package com.escobar.marketplace.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    @FXML
    protected void aoVerRelatorio(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/escobar/marketplace/relatorio.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Ver relatório");
        stage.show();
    }
    @FXML
    protected void aoRegistrarProdutos(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/escobar/marketplace/entrada.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Registrar produtos");
        stage.show();
    }
    @FXML
    protected void aoVisualizarEstoque(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/escobar/marketplace/estoque.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Visualizar Estoque");
        stage.show();
    }
    @FXML
    protected void voltarTelaLogin(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/escobar/marketplace/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private MediaView mediaView2;
    @FXML
    private MediaView mediaView3;
    @FXML
    private MediaView mediaView4;

    private MediaPlayer mediaPlayer2;
    private MediaPlayer mediaPlayer3;
    private MediaPlayer mediaPlayer4;

    @FXML
    public void initialize() {

        String caminho2 = getClass()
                .getResource("/com/escobar/marketplace/videos/carro1.mp4")
                .toExternalForm();

        Media media2 = new Media(caminho2);

        mediaPlayer2 = new MediaPlayer(media2);

        mediaView2.setMediaPlayer(mediaPlayer2);

        mediaPlayer2.setCycleCount(MediaPlayer.INDEFINITE);

        mediaPlayer2.play();

        String caminho3 = getClass()
                .getResource("/com/escobar/marketplace/videos/carro2.mp4")
                .toExternalForm();

        Media media3 = new Media(caminho3);

        mediaPlayer3 = new MediaPlayer(media3);

        mediaView3.setMediaPlayer(mediaPlayer3);

        mediaPlayer3.setCycleCount(MediaPlayer.INDEFINITE);

        mediaPlayer3.play();

        String caminho4 = getClass()
                .getResource("/com/escobar/marketplace/videos/carro3.mp4")
                .toExternalForm();

        Media media4 = new Media(caminho4);

        mediaPlayer4 = new MediaPlayer(media4);

        mediaView4.setMediaPlayer(mediaPlayer4);

        mediaPlayer4.setCycleCount(MediaPlayer.INDEFINITE);

        mediaPlayer4.play();
    }
}
