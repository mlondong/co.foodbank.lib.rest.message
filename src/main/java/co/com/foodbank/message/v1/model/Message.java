package co.com.foodbank.message.v1.model;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import co.com.foodbank.message.dto.IMessage;
import co.com.foodbank.user.model.IUser;

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

    private String description;

    private IUser user;


    /**
     * Default constructor.
     */
    private Message() {}

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
    public IUser getUser() {
        return user;
    }


    public void setUser(IUser user) {
        this.user = user;
    }



}
