package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.annotation.PostConstruct;

@Named(value = "controller")
@SessionScoped
public class Controller implements Serializable {

    InetAddress ip;
    InetAddress mac;
    String IpNom;
    String Nombre;
    String MacAdrees;

    @PostConstruct
    public void Controller() {
        try {
            ip = InetAddress.getLocalHost();
            mac = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
        }
    }

    public void consultarVariables() throws UnknownHostException, SocketException {
        IpNom = String.valueOf(ip.getHostAddress());
        Nombre = String.valueOf(ip.getHostName());

        /* MAC */
 /* busca la interfaz de red asociada la direccion del protocolo de internet (ip) */
        NetworkInterface network = NetworkInterface.getByInetAddress(mac);
        /* Devuelve la dirección de hardware (generalmente MAC) de la interfaz si tiene una y si se puede acceder a ella con los privilegios actuales. */
        byte[] mac = network.getHardwareAddress();
        /* Construye un generador de cadenas sin caracteres y una capacidad inicial de 16 caracteres. */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mac.length; i++) {
            sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
        }
        /* Devuelve una representacio de cadena del objeto */
        MacAdrees = sb.toString();
    }

//    
//    public void macAdress() throws SocketException {
//        NetworkInterface network = NetworkInterface.getByInetAddress(mac);
//        byte[] mac = network.getHardwareAddress(); 
//        StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < mac.length; i++) {
//                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
//            }
//            MacAdrees = sb.toString();
//    }
//    
    public InetAddress getIp() {
        return ip;
    }

    public void setIp(InetAddress ip) {
        this.ip = ip;
    }

    public InetAddress getMac() {
        return mac;
    }

    public void setMac(InetAddress mac) {
        this.mac = mac;
    }

    public String getIpNom() {
        return IpNom;
    }

    public void setIpNom(String IpNom) {
        this.IpNom = IpNom;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getMacAdrees() {
        return MacAdrees;
    }

    public void setMacAdrees(String MacAdrees) {
        this.MacAdrees = MacAdrees;
    }
}
