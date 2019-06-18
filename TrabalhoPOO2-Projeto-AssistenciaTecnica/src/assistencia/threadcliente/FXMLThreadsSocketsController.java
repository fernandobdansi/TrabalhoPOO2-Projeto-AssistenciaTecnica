/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assistencia.threadcliente;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Fernando
 */
public class FXMLThreadsSocketsController implements Initializable {

    @FXML
    private Text TextNumClientes;
    private Socket socket;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            socket = new Socket("127.0.0.1", 54321);
            DataOutputStream saida1 = new DataOutputStream(socket.getOutputStream());

            Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis());

            String infoCliente = "IP: " + NetworkInfo.getEnderecoIP() + " Mac: " + NetworkInfo.getEnderecoMAC() + " " + dataDeHoje;

            ThreadCliente thread = new ThreadCliente(infoCliente, socket, TextNumClientes);
            thread.setName("Thread Cliente " + infoCliente);
            thread.start();

            saida1.writeUTF(infoCliente);

        } catch (IOException ex) {
            Logger.getLogger(FXMLThreadsSocketsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
