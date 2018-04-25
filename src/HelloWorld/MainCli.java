/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelloWorld;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author John Haste
 */
public class MainCli {
    public static void main(String[] args) {
        
        try {
            Registry servicoNomes = LocateRegistry.getRegistry();
            
            InterfaceCli refCliente = (InterfaceCli) new CliImpl(servicoNomes);   
        } catch (RemoteException ex) {
            Logger.getLogger(MainCli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
