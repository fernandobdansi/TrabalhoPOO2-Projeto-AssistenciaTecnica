/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopoo2.servidorsockets;

/**
 *
 * @author Fernando
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadServidor extends Thread {

    ArrayList<String> usuariosOnline = new ArrayList();
    private static Map<String, Socket> clientesMap = new HashMap<>();
    private Socket socket;
    int numCli = 0;

    public ThreadServidor(Socket s) {
        this.socket = s;
    }

    @Override
    public void run() {
        boolean sair = false;
        try {
            while (true) {

                DataInputStream entrada1 = new DataInputStream(socket.getInputStream());
                String cliente;
                cliente = entrada1.readUTF();
                conectar(cliente);
                atualizarUsuarios();
            }
        } catch (IOException ex) {
            Logger.getLogger(ThreadServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void conectar(String mensagem) {
        clientesMap.put(mensagem, socket);
    }

    public void enviarUsuariosOnline(String qtd) throws IOException {

        for (Map.Entry<String, Socket> cliente : clientesMap.entrySet()) {
            DataOutputStream saida = new DataOutputStream(cliente.getValue().getOutputStream());
            saida.writeUTF(qtd);
        }

    }

    public void atualizarUsuarios() throws IOException {
        ArrayList<String> usuariosOnline = new ArrayList();
        int cont = 0;
        for (Map.Entry<String, Socket> cliente : clientesMap.entrySet()) {
            usuariosOnline.add(cliente.getKey());
        }
        System.out.println("Usuarios Online!");

        for (String string : usuariosOnline) {
            System.out.println("Cliente " + cont + " :" + string);
            cont++;
        }
        int quantidade = usuariosOnline.size();
        String qtd = String.valueOf(quantidade);
        enviarUsuariosOnline(qtd);
        numCli++;

    }

}
