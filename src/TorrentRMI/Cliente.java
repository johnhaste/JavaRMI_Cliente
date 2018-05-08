package TorrentRMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente  extends UnicastRemoteObject implements InterfaceCli{

    InterfaceServ refServer;
    Registry servicoNomes;
    String nomeCliente;
    ArrayList<String> meusArquivos;
    
    public Cliente() throws RemoteException{
        try {
            this.servicoNomes = LocateRegistry.getRegistry();
            refServer = (InterfaceServ) this.servicoNomes.lookup("Servidor");
            refServer.chamar(nomeCliente, this);
        } catch (RemoteException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void notificarEvento(String str) throws RemoteException {
        System.out.println(str);    
    }
    public ArrayList<String> getListaArquivos() throws RemoteException{
        return this.refServer.consultarArquivos(this);
    }
    public InterfaceServ getServer() throws RemoteException{
        return this.refServer;
    }
}
