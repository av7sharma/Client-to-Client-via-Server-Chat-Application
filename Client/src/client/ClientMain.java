/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import objects.Filestructure;
import objects.message;

/**
 *
 * @author avinash
 * about class: this class ensures that the data the client wants to send or receive are tranformed in proper manner. 
 */
public class ClientMain {
     private final Socket socket;

    public ClientMain(Socket socket)
    {
        this.socket=socket;
    }
    public void send(message m)//method for sending message from client to server to send to specified server.
    {
        try{
            //in the outputstream send the message as ObjectOutputStream.
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(m);   
        }
         catch(IOException e)
        {
            Throwable cause = e.getCause();
        }
    }
    public void send(Filestructure file)
    {
        try{
            //in the outputstream send the file as ObjectOutputStream.
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(file); 
            System.out.println("file sent");
        }
         catch(IOException e)
        {
            Throwable cause = e.getCause();
        }
    }
    public Object receive() throws ClassNotFoundException
    {
        Object m = null;
        try{
            //in the inputstream receive the message/file as ObjectIntputStream.
        InputStream inputStream=socket.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        m=objectInputStream.readObject();
       
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return m;   
     }
    
}
