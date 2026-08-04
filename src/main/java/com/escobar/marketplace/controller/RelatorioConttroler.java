package com.escobar.marketplace.controller;

import com.escobar.marketplace.model.EstoqueDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.control.Label;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

public class RelatorioConttroler {
    @FXML
    private Label lblTotalProdutos;
    @FXML
    private Label lblValorTotal;
    @FXML
    private Label lblEstoqueBaixo;

    private final EstoqueDAO dadosEstoque = EstoqueDAO.getInstancia();

    @FXML
    public void initialize(){
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));

        int totalProdutos = dadosEstoque.listarProdutos().size();
        lblTotalProdutos.setText(String.valueOf(totalProdutos));

        double valorTotalEstoque = dadosEstoque.calcularValorTotalEstoque();
        lblValorTotal.setText(formatoMoeda.format(valorTotalEstoque));

        long estoqueBaixo = dadosEstoque.calcularEstoqueBaixo(10);
        lblEstoqueBaixo.setText(String.valueOf(estoqueBaixo));

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




}
