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
import javafx.scene.control.Alert;
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
            datePickerOrdemSaida.setValue(ordemDeServico.getDataSaida());
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
        if (validarEntradaDeDados()) {
            ordemDeServico.setCliente((Cliente) comboBoxOrdemCliente.getSelectionModel().getSelectedItem());
            ordemDeServico.setDataEntrada(datePickerOrdemEntrada.getValue());
            ordemDeServico.setDataSaida(datePickerOrdemSaida.getValue());
            ordemDeServico.setDispositivo((Dispositivo) comboBoxOrdemDispositivo.getSelectionModel().getSelectedItem());
            ordemDeServico.setStatus((Status) comboBoxOrdemStatus.getSelectionModel().getSelectedItem());
            ordemDeServico.setTecnico((Tecnico) comboBoxOrdemTecnico.getSelectionModel().getSelectedItem());
            ordemDeServico.setDescricaoProblema(textFieldOrdemProblema.getText());

            buttonConfirmarClicked = true;
            dialogStage.close();
        }

    }

    @FXML
    public void handleButtonAdicionar() {
        Servico servico;
        ItemServicoOrdem itemServicoOrdem = new ItemServicoOrdem();
        float valor = 10;

        if (comboBoxOrdemServicos.getSelectionModel().getSelectedItem() != null) {
            servico = (Servico) comboBoxOrdemServicos.getSelectionModel().getSelectedItem();

            if (textFieldOrdemValorServico.getText().equals("") || textFieldOrdemValorServico.getText().matches("[a-zA-Z\\s!\"#$%&'()*+,-./:;?@_`{|}~]+")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Problemas no Valor do Serviço!");
                alert.setContentText("O valor e invalido!");
                alert.show();

            } else {
                if (Integer.parseInt(textFieldOrdemValorServico.getText()) >= valor) {
                    itemServicoOrdem.setServico((Servico) comboBoxOrdemServicos.getSelectionModel().getSelectedItem());

                    itemServicoOrdem.setValor(Double.parseDouble((textFieldOrdemValorServico.getText())));

                    ordemDeServico.getItemServicoOrdem().add(itemServicoOrdem);
                    ordemDeServico.setValorTotal(ordemDeServico.getValorTotal() + itemServicoOrdem.getValor());

                    observableListItemServicoOrdems = FXCollections.observableArrayList(ordemDeServico.getItemServicoOrdem());
                    tableViewServicosRealizados.setItems(observableListItemServicoOrdems);

                    textFieldOrdemValorTotal.setText(String.format("%.2f", ordemDeServico.getValorTotal()));
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Problemas na escolha de Serviço!");
                    alert.setContentText("O preço minimo de cada serviço e R$10,00!");
                    alert.show();
                }

            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Problemas na escolha de Serviço!");
            alert.setContentText("Selecione um serviço!");
            alert.show();
        }
    }

    @FXML
    public void handleButtonRemover() {
        ItemServicoOrdem itemServicoOrdem = new ItemServicoOrdem();

        if (tableViewServicosRealizados.getSelectionModel().getSelectedItem() != null) {
            itemServicoOrdem = (ItemServicoOrdem) tableViewServicosRealizados.getSelectionModel().getSelectedItem();

            ordemDeServico.getItemServicoOrdem().remove(itemServicoOrdem);
            ordemDeServico.setValorTotal(ordemDeServico.getValorTotal() - itemServicoOrdem.getValor());

            observableListItemServicoOrdems = FXCollections.observableArrayList(ordemDeServico.getItemServicoOrdem());
            tableViewServicosRealizados.setItems(observableListItemServicoOrdems);

            textFieldOrdemValorTotal.setText(String.format("%.2f", ordemDeServico.getValorTotal()));
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Problemas na escolha do Serviço Realizado");
            alert.setContentText("Você não selecionou um Serviço Realizado na tabela!");
            alert.show();
        }

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

    private boolean validarEntradaDeDados() {
        String errorMessage = "";

        if (textFieldOrdemProblema.getText() == null || textFieldOrdemProblema.getText().length() == 0) {
            errorMessage += "Descrição inválida!\n";
        }

        if (comboBoxOrdemCliente.getSelectionModel().getSelectedItem() == null) {
            errorMessage += "Cliente inválido!\n";
        }
        if (comboBoxOrdemDispositivo.getSelectionModel().getSelectedItem() == null) {
            errorMessage += "Dispositivo inválido!\n";
        }
        if (comboBoxOrdemStatus.getSelectionModel().getSelectedItem() == null) {
            errorMessage += "Status inválido!\n";
        }
        if (comboBoxOrdemTecnico.getSelectionModel().getSelectedItem() == null) {
            errorMessage += "Técnico inválido!\n";
        }
        if (datePickerOrdemEntrada.getValue() == null) {
            errorMessage += "Data de Entrada e Obrigatória\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Mostrando a mensagem de erro
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro no cadastro");
            alert.setHeaderText("Campos inválidos, por favor, corrija...");
            alert.setContentText(errorMessage);
            alert.show();
            return false;
        }
    }

}
