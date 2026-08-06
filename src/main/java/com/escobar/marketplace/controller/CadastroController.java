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
import javafx.scene.input.MouseEvent;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import java.io.IOException;

public class CadastroController {

    @FXML
    private TextField usuarioCadastrar;

    @FXML
    private PasswordField senhaCadastrar;

    @FXML
    private PasswordField confirmarSenha;

    @FXML
    private TextFlow senhaNaoIguais;

    @FXML
    private TextFlow semNada;

    @FXML
    private TextFlow semSenha;

    private static UsuarioDAO dbUsuario = UsuarioDAO.getInstance();

    @FXML
    protected void aoCadastrar(ActionEvent event) throws IOException {
        String usuario = usuarioCadastrar.getText();
        if (usuario.isBlank()){
            semNada.setVisible(true);
            return;
        }
        String senha = senhaCadastrar.getText();
        if(senha.isBlank()){
            semSenha.setVisible(true);
            return;
        }
        String senhaConfirmacao = confirmarSenha.getText();
        if (!senhaConfirmacao.equals(senha)){
            senhaNaoIguais.setVisible(true);
            return;
        }
        Usuario novoUsuario = new Usuario(usuario,senha);
        dbUsuario.cadastrarUsuario(novoUsuario);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/escobar/marketplace/home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Visual");
        stage.show();

    }
    @FXML
    protected void aoJaTerConta(Event event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/escobar/marketplace/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Visualizar Estoque");
        stage.show();

    }
}
