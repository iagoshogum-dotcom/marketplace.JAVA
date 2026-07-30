package com.escobar.marketplace.controller;

import com.escobar.marketplace.model.EstoqueDAO;
import com.escobar.marketplace.model.Produto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class EntradaProdutosController {
    @FXML
    private Button salvar;

    @FXML
    private Button cancelar;

    @FXML
    private TextField editNome;

    @FXML
    private TextField editCategoria;

    @FXML
    private TextField editQuantidade;

    @FXML
    private TextField editPreco;

    private final EstoqueDAO dadosEstoque = EstoqueDAO.getInstancia();

    private Produto produtoEmEdicao;

    public void preencherParaEdicao( Produto produto ){
        this.produtoEmEdicao = produto;
        nome.setText(produto.getNome());
        categoria.setText(produto.getCategoria());
        quantidade.setText(String.valueOf(produto.getQuantidade()));
        preco.setText(String.valueOf(produto.getPreco()));
        salvar.setText("Salvar Alterações");
    }
    @FXML
    protected void aoSalvar(ActionEvent event) throws IOException{
        String nome = editNome.getText();
        String categoria = editCategoria.getText();
        if( nome == null || nome.isBlank() || categoria == null || categoria.isBlank()){
            mostrarErro("Informe um nome e uma categoria válida!");
            return;
        }
        int quantidade;
        double preco;
        try {
            quantidade = Integer.parseInt(editQuantidade.getText().trim());
            preco = Double.parseDouble(editPreco.getText().trim().replace(",", "."));
        } catch (NumberFormatException ex ){
            mostrarErro("Quantidade e preço precisam ser números válidos.");
            return;
        }

        if(produtoEmEdicao == null){
            Produto produto = new Produto(0, nome, categoria, quantidade, preco);
            dadosEstoque.adicionar(produto);
            mostrarSucesso(event, "Produto inserido com sucesso!");
        } else {
            produtoEmEdicao.setNome(nome);
            produtoEmEdicao.setCategoria(categoria);
            produtoEmEdicao.setQuantidade(quantidade);
            produtoEmEdicao.setPreco(preco);
            mostrarSucesso(event, "Produto editado com sucesso!");
        }
        System.out.println(dadosEstoque.listarProdutos());
    }
    private void mostrarErro(String mensagem) {
        Alert alerta = new Alert( Alert.AlertType.WARNING, mensagem);
        alerta.setHeaderText(null);
        alerta.showAndWait();
    }
    private void mostrarSucesso(ActionEvent event, String mensagem) throws IOException {
        Alert confirmacao = new Alert(Alert.AlertType.INFORMATION, mensagem );
        confirmacao.setHeaderText(null);
        confirmacao.showAndWait();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/escobar/marketplace/estoque.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Visualizar Estoque");
        stage.show();
    }
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
    protected void voltarTelaLogin(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/escobar/marketplace/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
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
    protected void aoCancelar(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/escobar/marketplace/home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Visualizar Estoque");
        stage.show();
    }


}
