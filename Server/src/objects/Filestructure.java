/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author user
 */
public class Filestructure implements Serializable{
    private final String filename;
    private final String filelocation;
    private final String reciever;
    private final String sender;
           public Filestructure(String filename,Path filelocation,String reciever,String sender)
           {
               this.filename=filename;
               this.filelocation=filelocation.toString();
               this.reciever=reciever;
               this.sender=sender;    
           }
   
    public String getFilename()
    {
        return this.filename;
    }
    public String getFilelocation()
    {
        return this.filelocation;
    }
   
    public String getReciever()
    {
        return this.reciever;
    }
    public String getSender()
    {
        return this.sender;
    }
    public byte[] getFilecontent() throws IOException
    {
        byte[] content= Files.readAllBytes(new File(filelocation).toPath());
        if(content==null)
        {
        System.out.println("Byte null");
        }
        return content;
    }
    
}
