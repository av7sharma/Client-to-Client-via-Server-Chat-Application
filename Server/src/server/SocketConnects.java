/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author avinash
 * about class: creates a hash map to list all the connected sockets with client name 
 */
public class SocketConnects {
    private final Map<String,Socket> mp ;
    public SocketConnects(){
        mp=new HashMap<>();
    }
    public void addSocket(String uname ,Socket socket)//method to add socket.
    {
        mp.put(uname,socket);
    }
    
    public Socket getSocket(String uname)//getter method,since mp is private to this class
    {
        return mp.get(uname);
    }
    
}
