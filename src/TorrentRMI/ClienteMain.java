/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TorrentRMI;

import TorrentRMI.GUIs.TelaInicialCliente;
import java.rmi.RemoteException;

/**
 *
 * @author Salet Pc
 */
public class ClienteMain {
    
    public static void main(String[] args) throws RemoteException {
        InterfaceCli cliente = (InterfaceCli) new Cliente();
        InterfaceServ servidor = cliente.getServer();
        TelaInicialCliente tela = new TelaInicialCliente(cliente,servidor);
    }
    
}
