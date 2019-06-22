/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistencia.controller;

/*import assistencia.model.dao.OrdemDeServicoDAO;
import assistencia.model.database.Database;
import assistencia.model.database.DatabaseFactory;*/
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author Fernando
 */
public class FXMLAnchorPaneGraficosOrdemDeServicoPorMesController implements Initializable {

    @FXML
    private BarChart<String, Integer> barChartOrdens;
    @FXML
    private CategoryAxis categoryAxis;
    @FXML
    private NumberAxis numberAxis;

    private final ObservableList<String> observableListMeses = FXCollections.observableArrayList();
   // private final Database database = DatabaseFactory.getDatabase("postgresql");
    //private final Connection connection = database.conectar();
    //private final OrdemDeServicoDAO ordemDeServicoDAO = new OrdemDeServicoDAO();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String[] arrayMeses = {"Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez"};
        observableListMeses.addAll(Arrays.asList(arrayMeses));
        categoryAxis.setCategories(observableListMeses);

        //ordemDeServicoDAO.setConnection(connection);
        //Map<Integer, ArrayList> dados = ordemDeServicoDAO.listarQuantidadeOrdemDeServicoPorMes();
        /*for (Map.Entry<Integer, ArrayList> dadosItem : dados.entrySet()) {
            XYChart.Series<String, Integer> series = new XYChart.Series<>();
            series.setName(dadosItem.getKey().toString());
            for (int i = 0; i < dadosItem.getValue().size(); i = i + 2) {
                String mes;
                Integer quantidade;
                mes = retornaNomeMes((int) dadosItem.getValue().get(i));
                quantidade = (Integer) dadosItem.getValue().get(i + 1);
                series.getData().add(new XYChart.Data<>(mes, quantidade));
            }
            barChartOrdens.getData().add(series);
        }*/
    }

    public String retornaNomeMes(int mes) {
        switch (mes) {
            case 1:
                return "Jan";
            case 2:
                return "Fev";
            case 3:
                return "Mar";
            case 4:
                return "Abr";
            case 5:
                return "Mai";
            case 6:
                return "Jun";
            case 7:
                return "Jul";
            case 8:
                return "Ago";
            case 9:
                return "Set";
            case 10:
                return "Out";
            case 11:
                return "Nov";
            case 12:
                return "Dez";
            default:
                return "";
        }
    }

}
