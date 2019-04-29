/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistencia.controller;

import assistencia.model.dao.OrdemDeServicoDAO;
import assistencia.model.database.Database;
import assistencia.model.database.DatabaseFactory;
import assistencia.model.domain.ItemServicoOrdem;
import assistencia.model.domain.OrdemDeServico;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Fernando
 */
public class FXMLAnchorPaneProcessosOrdemDeServicoController implements Initializable {

    @FXML
    private TableView<OrdemDeServico> tableViewOrdemDeServico;
    @FXML
    private TableColumn<OrdemDeServico, String> tableColumnOrdemCliente;
    @FXML
    private TableColumn<OrdemDeServico, String> tableColumnOrdemTecnico;
    @FXML
    private TableColumn<OrdemDeServico, String> tableColumnOrdemDispositivo;
    @FXML
    private TableColumn<OrdemDeServico, String> tableColumnOrdemStatus;
    @FXML
    private Button buttonAlterar;
    @FXML
    private Button buttonInserir;
    @FXML
    private Button buttonRemover;
    @FXML
    private Label labelOrdemCodigo;
    @FXML
    private Label labelOrdemDataEntrada;
    @FXML
    private Label labelOrdemDataSaida;
    @FXML
    private Label labelOrdemProblema;
    @FXML
    private Label labelOrdemValorTotal;
    @FXML
    private Label labelOrdemCliente;
    @FXML
    private Label labelOrdemTecnico;
    @FXML
    private Label labelOrdemDispositivo;
    @FXML
    private Label labelOrdemStatus;

    private List<OrdemDeServico> listOrdemDeServicos;
    private ObservableList<OrdemDeServico> observableListDispositivo;
    private final Database database = DatabaseFactory.getDatabase("postgresql");
    private final Connection connection = database.conectar();
    private final OrdemDeServicoDAO ordemDeServicoDAO = new OrdemDeServicoDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ordemDeServicoDAO.setConnection(connection);

        carregarTableViewOrdemDeServico();

        // Limpando a exibição dos detalhes do Dispositivo
        selecionarItemTableViewOrdemDeServico(null);

        // Listen acionado diante de quaisquer alterações na seleção de itens do TableView
        tableViewOrdemDeServico.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableViewOrdemDeServico(newValue));
    }

    private void carregarTableViewOrdemDeServico() {
        tableColumnOrdemCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        tableColumnOrdemDispositivo.setCellValueFactory(new PropertyValueFactory<>("dispositivo"));
        tableColumnOrdemStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        tableColumnOrdemTecnico.setCellValueFactory(new PropertyValueFactory<>("tecnico"));

        listOrdemDeServicos = ordemDeServicoDAO.listar();

        observableListDispositivo = FXCollections.observableArrayList(listOrdemDeServicos);
        tableViewOrdemDeServico.setItems(observableListDispositivo);
    }

    private void selecionarItemTableViewOrdemDeServico(OrdemDeServico ordemDeServico) {
        if (ordemDeServico != null) {
            labelOrdemCodigo.setText(String.valueOf(ordemDeServico.getCdOrdemDeServico()));
            labelOrdemDataEntrada.setText(String.valueOf(ordemDeServico.getDataEntrada()));
            LocalDate localDate = LocalDate.of(1000, 1, 1);
            if (ordemDeServico.getDataSaida().isEqual(localDate)) {
                labelOrdemDataSaida.setText("Não Entregue");
            } else {
                labelOrdemDataSaida.setText(String.valueOf(ordemDeServico.getDataSaida()));
            }
            labelOrdemProblema.setText(String.valueOf(ordemDeServico.getDescricaoProblema()));
            labelOrdemValorTotal.setText(NumberFormat.getCurrencyInstance().format(ordemDeServico.getValorTotal()));
            labelOrdemCliente.setText(String.valueOf(ordemDeServico.getCliente().getNome()));
            labelOrdemTecnico.setText(String.valueOf(ordemDeServico.getTecnico().getNome()));
            labelOrdemDispositivo.setText(String.valueOf(ordemDeServico.getDispositivo().getNumSerie()));
            labelOrdemStatus.setText(String.valueOf(ordemDeServico.getStatus().getDescricao()));
        } else {
            labelOrdemCodigo.setText("");
            labelOrdemDataEntrada.setText("");
            labelOrdemDataSaida.setText("");
            labelOrdemProblema.setText("");
            labelOrdemValorTotal.setText("");
            labelOrdemCliente.setText("");
            labelOrdemTecnico.setText("");
            labelOrdemDispositivo.setText("");
            labelOrdemStatus.setText("");
        }
    }

    @FXML
    public void handleButtonInserir() throws IOException {
        OrdemDeServico ordemDeServico = new OrdemDeServico();
        List<ItemServicoOrdem> listItemServicoOrdems = new ArrayList<>();
        ordemDeServico.setItemServicoOrdem(listItemServicoOrdems);
        ordemDeServico.setDataSaida(LocalDate.of(1000, 1, 1));
        boolean buttonConfirmarClicked = showFXMLAnchorPaneProcessosOrdemDeServicoDialog(ordemDeServico);
    }

    public boolean showFXMLAnchorPaneProcessosOrdemDeServicoDialog(OrdemDeServico ordemDeServico) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXMLAnchorPaneProcessosOrdemDeServicoDialogController.class.getResource("/assistencia/view/FXMLAnchorPaneProcessosOrdemDeServicoDialog.fxml"));

        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Registro de Ordem de Serviço");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando a Venda no Controller.
        FXMLAnchorPaneProcessosOrdemDeServicoDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setOrdemDeServico(ordemDeServico);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();
    }

}