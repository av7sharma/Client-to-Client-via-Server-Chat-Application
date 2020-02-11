/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.io.Serializable;

/**
 *
 * @author avinash
 * about class: this class helps to encapsulate a message with its name,sender and receiver.
 */
public class message implements Serializable {
    private final String message;
    private final String sender;
    private final String receiver;
    //we need to define constructor since all the data members are private.
    public message(String message,String sender ,String receiver)
    {
        this.message=message;
        this.sender=sender;
        this.receiver=receiver;
    }
    //getter methods to exctract the requisite attribute by other classes, since the data members are private.
    public String getMessage()
    {
        return this.message;
    }
    public String getSender()
    {
        return this.sender;
    }
    public String getReceiver()
    {
        return this.receiver;
    }
    
}
