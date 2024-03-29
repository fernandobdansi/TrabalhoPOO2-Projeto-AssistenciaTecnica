/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistencia.controller;

/*import assistencia.model.dao.DispositivoDAO;
 import assistencia.model.database.Database;
 import assistencia.model.database.DatabaseFactory;*/
import assistencia.model.domain.Dispositivo;
import assistencia.service.DispositivoService;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
public class FXMLAnchorPaneCadastrosDispositivosController implements Initializable {

    @FXML
    private TableView<Dispositivo> tableViewDispositivo;
    @FXML
    private TableColumn<Dispositivo, Dispositivo> tableColumnDispositivoClienteNome;
    @FXML
    private TableColumn<Dispositivo, String> tableColumnDispositivoNumSerie;
    @FXML
    private Label labelDispositivoClienteNome;
    @FXML
    private Label labelDispositivoNumSerie;
    @FXML
    private Label labelDispositivoMarca;
    @FXML
    private Label labelDispositivoCodigo;
    @FXML
    private Label labelDispositivoModelo;
    @FXML
    private Label labelDispositivoDescricao;
    @FXML
    private Button buttonAlterar;
    @FXML
    private Button buttonInserir;
    @FXML
    private Button buttonRemover;

    /**
     * Initializes the controller class.
     */
    private List<Dispositivo> listDispositivo;
    private ObservableList<Dispositivo> observableListDispositivo;
    /* private final Database database = DatabaseFactory.getDatabase("postgresql");
     private final Connection connection = database.conectar();
     private final DispositivoDAO dispositivoDAO = new DispositivoDAO();*/

    private final DispositivoService dispositivoService = new DispositivoService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        carregarTableViewDispositivo();

        selecionarItemTableViewDispositivo(null);

        tableViewDispositivo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selecionarItemTableViewDispositivo(newValue));

    }

    @FXML
    private void handleButtonAlterar() throws IOException {
        Dispositivo dispositivo = tableViewDispositivo.getSelectionModel().getSelectedItem();//Obtendo cliente selecionado
        if (dispositivo != null) {
            boolean buttonConfirmarClicked = showFXMLAnchorPaneCadastrosDispositivoDialog(dispositivo);
            if (buttonConfirmarClicked) {
                dispositivoService.alterar(dispositivo);
                carregarTableViewDispositivo();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um Dispositivo na Tabela!");
            alert.show();
        }
    }

    @FXML
    private void handleButtonInserir() throws IOException {
        Dispositivo dispositivo = new Dispositivo();
        boolean buttonConfirmarClicked = showFXMLAnchorPaneCadastrosDispositivoDialog(dispositivo);
        if (buttonConfirmarClicked) {
            System.out.println(dispositivo.getNumSerie());
            dispositivoService.inserir(dispositivo);
            carregarTableViewDispositivo();
        }
    }

    @FXML
    private void handleButtonRemover() throws IOException {
        Dispositivo dispositivo = tableViewDispositivo.getSelectionModel().getSelectedItem();
        Boolean ret = true;
        if (dispositivo != null) {
            dispositivoService.remover(dispositivo);
            carregarTableViewDispositivo();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Erro ao Remover! Selecione um Dispositivo");
            alert.show();
        }
        if (ret) {
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Erro ao Remover! Verifique se não há Dependências em Outras Tabelas!");
            alert.show();
        }
    }

    private void carregarTableViewDispositivo() {
        tableColumnDispositivoClienteNome.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        tableColumnDispositivoNumSerie.setCellValueFactory(new PropertyValueFactory<>("numSerie"));

        listDispositivo = dispositivoService.listar();

        observableListDispositivo = FXCollections.observableArrayList(listDispositivo);
        tableViewDispositivo.setItems(observableListDispositivo);
    }

    private void selecionarItemTableViewDispositivo(Dispositivo dispositivo) {
        if (dispositivo != null) {
            labelDispositivoClienteNome.setText(dispositivo.getCliente().getNome());
            labelDispositivoNumSerie.setText(dispositivo.getNumSerie());
            labelDispositivoMarca.setText(dispositivo.getMarca().getNome());
            labelDispositivoCodigo.setText(String.valueOf(dispositivo.getCdDispositivo()));
            labelDispositivoModelo.setText(dispositivo.getModelo().getNome());
            labelDispositivoDescricao.setText(dispositivo.getDescricao());
        } else {
            labelDispositivoClienteNome.setText("");
            labelDispositivoNumSerie.setText("");
            labelDispositivoMarca.setText("");
            labelDispositivoCodigo.setText("");
            labelDispositivoModelo.setText("");
            labelDispositivoDescricao.setText("");
        }
    }

    public boolean showFXMLAnchorPaneCadastrosDispositivoDialog(Dispositivo dispositivo) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXMLAnchorPaneCadastrosDispositivoDialogController.class.getResource("/fxml/FXMLAnchorPaneCadastrosDispositivoDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro de Dispositivo");

        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        FXMLAnchorPaneCadastrosDispositivoDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setDispositivo(dispositivo);

        dialogStage.setFocused(true);

        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();

    }

}
