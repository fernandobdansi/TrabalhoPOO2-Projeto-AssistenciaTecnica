/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistencia.controller;

import assistencia.model.dao.ClienteDAO;
import assistencia.model.dao.MarcaDAO;
import assistencia.model.dao.ModeloDAO;
import assistencia.model.database.Database;
import assistencia.model.database.DatabaseFactory;
import assistencia.model.domain.Cliente;
import assistencia.model.domain.Dispositivo;
import assistencia.model.domain.Marca;
import assistencia.model.domain.Modelo;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Fernando
 */
public class FXMLAnchorPaneCadastrosDispositivoDialogController implements Initializable {

    @FXML
    private ComboBox comboBoxDispositivoCliente;
    @FXML
    private ComboBox comboBoxDispositivoMarca;
    @FXML
    private ComboBox comboBoxDispositivoModelo;
    @FXML
    private TextField textFieldDispositivoDescricao;
    @FXML
    private TextField textFieldDispositivoNumSerie;
    @FXML
    private Button buttonConfirmar;
    @FXML
    private Button buttonCancelar;

    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private Dispositivo dispositivo;

    private List<Cliente> listClientes;
    private ObservableList<Cliente> observableListClientes;
    private List<Marca> listMarca;
    private ObservableList<Marca> observableListMarca;
    private List<Modelo> listModelo;
    private ObservableList<Modelo> observableListModelo;

    //Atributos para manipulação de Banco de Dados
    private final Database database = DatabaseFactory.getDatabase("postgresql");
    private final Connection connection = database.conectar();
    private final ClienteDAO clienteDAO = new ClienteDAO();
    private final MarcaDAO marcaDAO = new MarcaDAO();
    private final ModeloDAO modeloDAO = new ModeloDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clienteDAO.setConnection(connection);
        marcaDAO.setConnection(connection);
        modeloDAO.setConnection(connection);
        carregarComboBoxClientes();
        carregarComboBoxMarca();
    }

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public Dispositivo getDispositivo() {
        return this.dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
        textFieldDispositivoDescricao.setText(dispositivo.getDescricao());
        textFieldDispositivoNumSerie.setText(dispositivo.getNumSerie());
        comboBoxDispositivoCliente.getSelectionModel().select(dispositivo.getCliente());
        comboBoxDispositivoMarca.getSelectionModel().select(dispositivo.getMarca());
        comboBoxDispositivoModelo.getSelectionModel().select(dispositivo.getModelo());
    }

    public boolean isButtonConfirmarClicked() {
        return buttonConfirmarClicked;
    }

    public void handleButtonConfirmar() {
        if (validarEntradaDeDados()) {
            dispositivo.setCliente((Cliente) comboBoxDispositivoCliente.getSelectionModel().getSelectedItem());
            dispositivo.setMarca((Marca) comboBoxDispositivoMarca.getSelectionModel().getSelectedItem());
            dispositivo.setModelo((Modelo) comboBoxDispositivoModelo.getSelectionModel().getSelectedItem());
            dispositivo.setDescricao(textFieldDispositivoDescricao.getText());
            dispositivo.setNumSerie(textFieldDispositivoNumSerie.getText());

            buttonConfirmarClicked = true;
            dialogStage.close();
        }
    }

    public void carregarComboBoxClientes() {
        listClientes = clienteDAO.listar();
        observableListClientes = FXCollections.observableArrayList(listClientes);
        comboBoxDispositivoCliente.setItems(observableListClientes);
    }

    public void carregarComboBoxMarca() {
        listMarca = marcaDAO.listar();
        observableListMarca = FXCollections.observableArrayList(listMarca);
        comboBoxDispositivoMarca.setItems(observableListMarca);
    }

    public void carregarComboBoxModelo() {
        Marca marca = (Marca) comboBoxDispositivoMarca.getSelectionModel().getSelectedItem();
        listModelo = modeloDAO.listarModeloPorMarca(marca);
        observableListModelo = FXCollections.observableArrayList(listModelo);
        comboBoxDispositivoModelo.setItems(observableListModelo);
    }

    public void handleButtonCancelar() {
        getDialogStage().close();
    }

    //Validar entrada de dados para o cadastro
    private boolean validarEntradaDeDados() {
        String errorMessage = "";

        if (textFieldDispositivoDescricao.getText() == null || textFieldDispositivoDescricao.getText().length() == 0 || textFieldDispositivoDescricao.getText().length() > 30) {
            errorMessage += "Descrição inválida!\n";
        }
        if (textFieldDispositivoNumSerie.getText() == null || textFieldDispositivoNumSerie.getText().length() == 0 || textFieldDispositivoNumSerie.getText().length() > 30) {
            errorMessage += "Numero de Série inválido!\n";
        }
        if (comboBoxDispositivoCliente.getSelectionModel().getSelectedItem() == null) {
            errorMessage += "Cliente inválido!\n";
        }
        if (comboBoxDispositivoMarca.getSelectionModel().getSelectedItem() == null) {
            errorMessage += "Marca inválido!\n";
        }
        if (comboBoxDispositivoModelo.getSelectionModel().getSelectedItem() == null) {
            errorMessage += "Modelo inválido!\n";
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
