package com.escobar.marketplace.controller;

import com.escobar.marketplace.model.EstoqueDAO;
import com.escobar.marketplace.model.Produto;
import com.escobar.marketplace.util.GerenciadorTela;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class EstoqueController {

    @FXML
    private TextField campoBusca;

    @FXML
    private TableView tabelaProdutos;

    @FXML
    private TableColumn colunaId;

    @FXML
    private TableColumn colunaNome;

    @FXML
    private TableColumn colunaCategoria;

    @FXML
    private TableColumn colunaQuantidade;

    @FXML
    private TableColumn colunaPreco;

    private final EstoqueDAO dadosEstoque = EstoqueDAO.getInstancia();
    private FilteredList<Produto> listaFiltrada;

    @FXML
    public void initialize(){

        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colunaQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        colunaPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));

        listaFiltrada = new FilteredList<>(dadosEstoque.listarProdutos(),p -> true);
        tabelaProdutos.setItems(listaFiltrada);
        campoBusca.textProperty().addListener( (obs, textoAntigo, textoNovo)->{
            String filtro = textoNovo == null ? "": textoNovo.toLowerCase();
            listaFiltrada.setPredicate(produto -> filtro.isEmpty() || produto.getNome().toLowerCase().contains(filtro) || produto.getCategoria().toLowerCase().contains(filtro) || String.valueOf(produto.getPreco()).contains(filtro));
        });
    }

    @FXML
    protected void aoAdicionarProdutos(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/escobar/marketplace/entrada.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Adicionar Produtos");
        stage.show();

    }
    @FXML
    protected void aoEditarProdutos(ActionEvent event) throws IOException
    {
        Produto produtoSelecionado = (Produto)tabelaProdutos.getSelectionModel().getSelectedItem();
        if (produtoSelecionado == null){
            mostrarAlerta("Selecione um produto para editar");
            return;
        }
        GerenciadorTela.getInstance().telaDeEdicao(event,"entrada.fxml","Sistema de estoque - EDIÇÃO",(EntradaProdutosController controller) -> controller.preencherParaEdicao(produtoSelecionado));

    }

    public void mostrarAlerta(String mensagem){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION,mensagem);
        alerta.setHeaderText(null);
        alerta.showAndWait();
    }


    @FXML
    protected void aoRemoverProdutos(){
        Produto produtoSelecionado = (Produto) tabelaProdutos.getSelectionModel().getSelectedItem();
        if ( produtoSelecionado == null){
            mostrarAlerta("Selecionar um produto para remover");
            return;
        }
        Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION,"Remover o produto" + produtoSelecionado.getNome() + "do estoque?");
        confirmacao.setHeaderText(null);
        ButtonType btnSim = new ButtonType("Sim");
        ButtonType btnNao = new ButtonType("Não");
        confirmacao.getButtonTypes().setAll(btnSim,btnNao);
        confirmacao.showAndWait().ifPresent(botao -> {dadosEstoque.remover(produtoSelecionado);});

    }
    @FXML
    protected void aoVoltar(){

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
    protected void aoVerRelatorio(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/escobar/marketplace/relatorio.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Ver relatório");
        stage.show();
    }



}
