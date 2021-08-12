package co.com.foodbank.message.v1.model;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import co.com.foodbank.message.interfaces.IMessage;
import co.com.foodbank.user.request.RequestUserData;

/**
 * Class to handle all message by foodbank.
 * 
 * @author mauricio.londono@gmail.com co.com.foodbank.message.v1.model 9/08/2021
 */
@Document(collection = "Message")
public class Message implements IMessage {

    @Id
    private String id;

    private Date dateMessage;

    private String subject;

    private String description;

    private RequestUserData user;


    /**
     * Default constructor.
     */
    public Message() {}

    @Override
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    @Override
    public Date getDateMessage() {
        return dateMessage;
    }


    public void setDateMessage(Date dateMessage) {
        this.dateMessage = dateMessage;
    }

    @Override
    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public RequestUserData getUser() {
        return user;
    }


    public void setUser(RequestUserData user) {
        this.user = user;
    }

}
