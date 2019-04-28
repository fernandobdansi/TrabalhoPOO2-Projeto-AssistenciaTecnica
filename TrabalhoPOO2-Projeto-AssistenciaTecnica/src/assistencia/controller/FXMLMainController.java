/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistencia.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Fernando
 */
public class FXMLMainController implements Initializable {

    private Label label;
    @FXML
    private MenuItem menuItemCadastrosClientes;
    @FXML
    private MenuItem menuItemProcessosOrdemDeServico;
    @FXML
    private MenuItem menuItemGraficosVendasPorMes;
    @FXML
    private MenuItem menuItemRelatoriosQuantidadeProdutos;
    @FXML
    private MenuItem menuItemRelatoriosQuantidadeProdutosPorCategoria;
    @FXML
    private AnchorPane anchorPane;

    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleMenuItemCadastrosDispositivo(ActionEvent event) throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/assistencia/view/FXMLAnchorPaneCadastrosDispositivos.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    @FXML
    private void handleMenuItemProcessosOrdemDeServico(ActionEvent event) throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/assistencia/view/FXMLAnchorPaneProcessosOrdemDeServico.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    @FXML
    private void handleMenuItemGraficosVendasPorMes(ActionEvent event) {
    }

    @FXML
    private void handleMenuItemRelatoriosQuantidadeProdutos(ActionEvent event) {
    }

    @FXML
    private void handleMenuItemRelatoriosQuantidadeProdutosPorCategoria(ActionEvent event) {
    }

}
