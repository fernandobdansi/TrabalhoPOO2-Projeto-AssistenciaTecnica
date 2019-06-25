/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistencia.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private MenuItem menuItemThreadsSockets;

    @FXML
    private AnchorPane anchorPane;

    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AnchorPane a;
        try {
            a = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/FXMLMenuPrincipal.fxml"));
            anchorPane.getChildren().setAll(a);

        } catch (IOException ex) {
            Logger.getLogger(FXMLMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleMenuItemCadastrosDispositivo(ActionEvent event) throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/FXMLAnchorPaneCadastrosDispositivos.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    @FXML
    private void handleMenuItemHome(ActionEvent event) throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/FXMLMenuPrincipal.fxml"));
        anchorPane.getChildren().setAll(a);
    }

}
