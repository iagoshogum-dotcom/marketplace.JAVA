package com.escobar.marketplace.controller;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicController {
    private static MediaPlayer mediaPlayer;

    public static void iniciarMusica() {

        if (mediaPlayer == null) {

            String caminho = MusicController.class
                    .getResource("/com/escobar/marketplace/music/rise.mp3")
                    .toExternalForm();

            System.out.println("Música encontrada em: " + caminho);

            Media media = new Media(caminho);

            mediaPlayer = new MediaPlayer(media);

            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);


            mediaPlayer.setVolume(0.6);


            mediaPlayer.setOnError(() -> {
                System.out.println("ERRO NO PLAYER: "
                        + mediaPlayer.getError());
            });

            mediaPlayer.setOnReady(() -> {
                System.out.println("MÚSICA PRONTA!");

                mediaPlayer.play();

                System.out.println("Status: "
                        + mediaPlayer.getStatus());
            });
        }
    }
}