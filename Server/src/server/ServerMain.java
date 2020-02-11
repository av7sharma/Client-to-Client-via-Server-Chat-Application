/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author avinash
 * about class: this is the main server class which creates server socket and accepts all client socket.
 */
public class ServerMain {
     public static void main(String args[]) {
        
        int port =8080;//port predefined for communicating with server
        try{
        ServerSocket serverSocket = new ServerSocket(port);//creating server socket
        SocketConnects sc=new SocketConnects();//creating object of SocketConnects class in order to add new clients to hash map.
        while(true)//The server should run the entire time
        {
            System.out.println("Server is running");
            Socket clientSocket = serverSocket.accept();//waits for connection
            System.out.println("Client connected");
            InputStream inputstream=clientSocket.getInputStream();//get name of client 
            BufferedReader reader=new BufferedReader(new InputStreamReader(inputstream));//convert it into a buffer
            String user;
            user=reader.readLine();
            sc.addSocket(user, clientSocket);//add the client to hash map
            
            WorkingServer serverworker=new WorkingServer(clientSocket,sc);//create a separate server thread for each client to handle transfer of data and message.
            serverworker.start();//start thread
        
        }
                
        } catch (IOException ex) {
            Logger.getLogger(ServerMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
