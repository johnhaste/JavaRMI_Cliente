/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelloWorld;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author John Haste
 */
public class CliImpl  extends UnicastRemoteObject implements InterfaceCli{

    InterfaceServ refServer;
    Registry servicoNomes;
    String nomeCliente;
    
    public CliImpl(Registry servicoNomes) throws RemoteException{
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite o seu nome de cliente boladão: ");
            nomeCliente = scanner.nextLine();
            this.servicoNomes = servicoNomes;
            refServer = (InterfaceServ) this.servicoNomes.lookup("Servidor");
            refServer.chamar(nomeCliente, this);
        } catch (RemoteException ex) {
            Logger.getLogger(CliImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(CliImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void echo(String str) throws RemoteException {
        System.out.println(str);
    }
}
