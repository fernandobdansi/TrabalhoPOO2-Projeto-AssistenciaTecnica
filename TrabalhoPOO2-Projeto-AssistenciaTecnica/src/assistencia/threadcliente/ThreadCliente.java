package assistencia.threadcliente;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.text.Text;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Fernando
 */
public class ThreadCliente extends Thread {

    private Socket socket;
    private String remetente;
    private Text textNumClientes;

    boolean sair = false;

    public ThreadCliente(String r, Socket s, Text TextNumClientes) {
        this.remetente = r;
        this.socket = s;
        this.textNumClientes = TextNumClientes;
    }

    @Override
    public void run() {
        try {
            while (true) {

                Thread.sleep(10000);
                DataInputStream entrada1 = new DataInputStream(socket.getInputStream());

                String qtd;
                qtd = entrada1.readUTF();
                atualizarUsuarios(qtd);

            }
        } catch (IOException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void atualizarUsuarios(String qtd) {

        Platform.runLater(() -> this.textNumClientes.setText(qtd));

    }

}
