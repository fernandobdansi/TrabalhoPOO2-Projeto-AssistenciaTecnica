/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistencia.controller;

//import assistencia.model.dao.TecnicoDAO;
//import assistencia.model.database.Database;
//import assistencia.model.database.DatabaseFactory;
import assistencia.model.domain.Tecnico;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.util.JRLoader;
//import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author Fernando
 */
public class FXMLAnchorPaneRelatoriosTecnicoServicoRealizadoController implements Initializable {

    @FXML
    private TableView<Tecnico> tableViewRelatorio;
    @FXML
    private TableColumn<Tecnico, String> tableColumnNome;
    @FXML
    private TableColumn<Tecnico, String> tableColumnCPF;
    @FXML
    private TableColumn<Tecnico, String> tableColumnTelefone;
    @FXML
    private TableColumn<Tecnico, String> tableColumnTotalServico;
    @FXML
    private Button buttonImprimir;

    private List<Tecnico> listTecnicos;
    private ObservableList<Tecnico> observableListTecnicos;
    //private final Database database = DatabaseFactory.getDatabase("postgresql");
    //private final Connection connection = database.conectar();
    //final TecnicoDAO tecnicoDAO = new TecnicoDAO();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //tecnicoDAO.setConnection(connection);

        carregarTableViewTecnicos();
    }

    private void carregarTableViewTecnicos() {
        /*tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        tableColumnTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        tableColumnTotalServico.setCellValueFactory(new PropertyValueFactory<>("valorFormatado"));

        listTecnicos = tecnicoDAO.listarTecnicoPorOrdem();

        observableListTecnicos = FXCollections.observableArrayList(listTecnicos);
        tableViewRelatorio.setItems(observableListTecnicos);*/
    }

    /*public void handleImprimir() throws JRException {
        URL url = getClass().getResource("/assistencia/relatorios/JAVAFXMVRelatorioTecnicosServico.jasper");
        JasperReport report = (JasperReport) JRLoader.loadObject(url);
        JasperPrint print = JasperFillManager.fillReport(report, null, connection);
        JasperViewer viewer = new JasperViewer(print, false);
        viewer.setVisible(true);
    }*/

}
