/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import objects.Filestructure;
import objects.message;

/**
 *
 * @author avinash
 * about class: create a separate server thread for each client to handle transfer of data and message.
 */
public class WorkingServer extends Thread {
    private final Socket clientSocket;
    private SocketConnects sc;
    // define constructor,since the data members are private.
    public WorkingServer(Socket clientSocket,SocketConnects sc)
    {
        this.clientSocket=clientSocket;
        this.sc=sc;
    }
    
    public void run()
    {
        try 
        {
            handleClientSocket();
        }
        catch(IOException | InterruptedException e){
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WorkingServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public void send(message m,Socket newclientSocket)//method for sending message from server to specified client.
    {
        try{
            //in the outputstream send the message as ObjectOutputStream.
            OutputStream outputStream = newclientSocket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(m);
        }
         catch(IOException e)
        {
            e.printStackTrace();
        }
    }
       public void send(Filestructure file,Socket newclientSocket)
    {
        try{
            //in the outputstream send the file as ObjectOutputStream.
            OutputStream outputStream = newclientSocket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(file);
        }
         catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public Object receive() throws ClassNotFoundException
    {
        Object m = null ;
        try{
        //in the inputstream receive the message/file as ObjectIntputStream.
        InputStream inputStream=clientSocket.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        m=objectInputStream.readObject();
       
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return m;  
    }
    private void handleClientSocket() throws IOException,InterruptedException, ClassNotFoundException//method to handle dat received from client socket.
    {
       
        while(true)
        {
                Object obj=receive();
                if(obj==null)
                {
                    System.out.println("null object received");
                }
                if(obj instanceof message)
                {
                message m=(message)obj;
                send(m,sc.getSocket(m.getReceiver()));//if object is of message type,extract the receiver from the message,the extract the user from the hash map and send it to that user/client
                }
                else
                {
                    Filestructure file=(Filestructure)obj;
                    send(file,sc.getSocket(file.getReciever()));//reapeating the if case for files.
                }
          
        }
    }
    
}
