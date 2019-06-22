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
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Fernando
 */
public class FXMLMenuPrincipalController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button buttonAtalhoDispositivos;
    @FXML
    private Button buttonAtalhoOrdemDeServico;
    @FXML
    private Button buttonAtalhoGrafico;
    @FXML
    private Button buttonAtalhoRelatorio;

    /**
     * Initializes the controller class.
     */
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
    private void handleMenuItemGraficosOrdemPorMes(ActionEvent event) throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/assistencia/view/FXMLAnchorPaneGraficosOrdemDeServicoPorMes.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    @FXML
    private void handleMenuItemRelatoriosTecnicos(ActionEvent event) throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/assistencia/view/FXMLAnchorPaneRelatoriosTecnicoServicoRealizado.fxml"));
        anchorPane.getChildren().setAll(a);
    }
}
