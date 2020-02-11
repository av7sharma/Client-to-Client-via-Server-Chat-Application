/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class message implements Serializable {
    private final String message;
    private final String sender;
    private final String receiver;
    public message(String message,String sender ,String receiver)
    {
        this.message=message;
        this.sender=sender;
        this.receiver=receiver;
    }
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
