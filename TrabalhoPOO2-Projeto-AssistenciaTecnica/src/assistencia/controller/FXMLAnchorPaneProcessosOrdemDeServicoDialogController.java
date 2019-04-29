/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistencia.controller;

import assistencia.model.dao.ClienteDAO;
import assistencia.model.dao.DispositivoDAO;
import assistencia.model.dao.ItemServicoOrdemDAO;
import assistencia.model.dao.ServicoDAO;
import assistencia.model.dao.StatusDAO;
import assistencia.model.dao.TecnicoDAO;
import assistencia.model.database.Database;
import assistencia.model.database.DatabaseFactory;
import assistencia.model.domain.Cliente;
import assistencia.model.domain.Dispositivo;
import assistencia.model.domain.ItemServicoOrdem;
import assistencia.model.domain.OrdemDeServico;
import assistencia.model.domain.Servico;
import assistencia.model.domain.Status;
import assistencia.model.domain.Tecnico;
import java.net.URL;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Fernando
 */
public class FXMLAnchorPaneProcessosOrdemDeServicoDialogController implements Initializable {

    @FXML
    private Button buttonConfirmar;
    @FXML
    private Button buttonCancelar;
    @FXML
    private ComboBox comboBoxOrdemCliente;
    @FXML
    private ComboBox comboBoxOrdemDispositivo;
    @FXML
    private ComboBox comboBoxOrdemTecnico;
    @FXML
    private ComboBox comboBoxOrdemStatus;
    @FXML
    private DatePicker datePickerOrdemEntrada;
    @FXML
    private DatePicker datePickerOrdemSaida;
    @FXML
    private TextField textFieldOrdemProblema;
    @FXML
    private ComboBox comboBoxOrdemServicos;
    @FXML
    private TextField textFieldOrdemValorServico;
    @FXML
    private Button buttonAddServico;
    @FXML
    private Button buttonRemServico;
    @FXML
    private TableView<ItemServicoOrdem> tableViewServicosRealizados;
    @FXML
    private TableColumn<ItemServicoOrdem, String> tableColumnServico;
    @FXML
    private TableColumn<ItemServicoOrdem, String> tableColumnValor;
    @FXML
    private TextField textFieldOrdemValorTotal;

    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private OrdemDeServico ordemDeServico;

    private List<Cliente> listClientes;
    private ObservableList<Cliente> observableListClientes;
    private List<Tecnico> listTecnico;
    private ObservableList<Tecnico> observableListTecnicos;
    private List<Dispositivo> listDispositivos;
    private ObservableList<Dispositivo> observableListDispositivos;
    private List<Status> listStatuses;
    private ObservableList<Status> observableListStatuses;
    private List<Servico> listServicos;
    private ObservableList<Servico> observableListServicos;
    private List<ItemServicoOrdem> listItemServicoOrdems;
    private ObservableList<ItemServicoOrdem> observableListItemServicoOrdems;

    private final Database database = DatabaseFactory.getDatabase("postgresql");
    private final Connection connection = database.conectar();
    private final ClienteDAO clienteDAO = new ClienteDAO();
    private final DispositivoDAO dispositivoDAO = new DispositivoDAO();
    private final TecnicoDAO tecnicoDAO = new TecnicoDAO();
    private final StatusDAO statusDAO = new StatusDAO();
    private final ServicoDAO servicoDAO = new ServicoDAO();
    private final ItemServicoOrdemDAO itemServicoOrdemDAO = new ItemServicoOrdemDAO();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clienteDAO.setConnection(connection);
        dispositivoDAO.setConnection(connection);
        tecnicoDAO.setConnection(connection);
        statusDAO.setConnection(connection);
        servicoDAO.setConnection(connection);
        itemServicoOrdemDAO.setConnection(connection);

        carregarComboBoxClientes();
        //carregarComboBoxDispositivo();
        carregarComboBoxTecnico();
        carregarComboBoxStatus();
        carregarComboBoxServicos();

        tableColumnServico.setCellValueFactory(new PropertyValueFactory<>("servico"));
        tableColumnValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
    }

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public OrdemDeServico getOrdemDeServico() {
        return this.ordemDeServico;
    }

    public void setOrdemDeServico(OrdemDeServico ordemDeServico) {
        this.ordemDeServico = ordemDeServico;

        //[No caso de alteração] Deixando selecionado os dados da venda escolhida
        comboBoxOrdemCliente.getSelectionModel().select(ordemDeServico.getCliente());
        datePickerOrdemEntrada.setValue(ordemDeServico.getDataEntrada());
        LocalDate localDate = LocalDate.of(1000, 1, 1);
        if (ordemDeServico.getDataSaida().isEqual(localDate)) {
        } else {
            datePickerOrdemEntrada.setValue(ordemDeServico.getDataSaida());
        }
        comboBoxOrdemDispositivo.getSelectionModel().select(ordemDeServico.getDispositivo());
        comboBoxOrdemStatus.getSelectionModel().select(ordemDeServico.getStatus());
        comboBoxOrdemTecnico.getSelectionModel().select(ordemDeServico.getTecnico());

        observableListItemServicoOrdems = FXCollections.observableArrayList(ordemDeServico.getItemServicoOrdem());
        tableViewServicosRealizados.setItems(observableListItemServicoOrdems);
        textFieldOrdemValorTotal.setText(String.format("%.2f", ordemDeServico.getValorTotal()));
        textFieldOrdemProblema.setText(ordemDeServico.getDescricaoProblema());

    }

    public void handleButtonCancelar() {
        getDialogStage().close();
    }

    public void handleButtonConfirmar() {

        buttonConfirmarClicked = true;
        dialogStage.close();

    }

    public boolean isButtonConfirmarClicked() {
        return buttonConfirmarClicked;
    }

    public void carregarComboBoxClientes() {
        listClientes = clienteDAO.listar();
        observableListClientes = FXCollections.observableArrayList(listClientes);
        comboBoxOrdemCliente.setItems(observableListClientes);
    }

    public void carregarComboBoxDispositivo() {
        Cliente cliente = (Cliente) comboBoxOrdemCliente.getSelectionModel().getSelectedItem();
        listDispositivos = dispositivoDAO.listarPorCliente(cliente);
        observableListDispositivos = FXCollections.observableArrayList(listDispositivos);
        comboBoxOrdemDispositivo.setItems(observableListDispositivos);
    }

    public void carregarComboBoxTecnico() {
        listTecnico = tecnicoDAO.listar();
        observableListTecnicos = FXCollections.observableArrayList(listTecnico);
        comboBoxOrdemTecnico.setItems(observableListTecnicos);
    }

    public void carregarComboBoxStatus() {
        listStatuses = statusDAO.listar();
        observableListStatuses = FXCollections.observableArrayList(listStatuses);
        comboBoxOrdemStatus.setItems(observableListStatuses);
    }

    public void carregarComboBoxServicos() {
        listServicos = servicoDAO.listar();
        observableListServicos = FXCollections.observableArrayList(listServicos);
        comboBoxOrdemServicos.setItems(observableListServicos);
    }

}
