package co.com.foodbank.message.v1.controller;

import java.util.Collection;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import co.com.foodbank.message.dto.MessageDTO;
import co.com.foodbank.message.exception.MessageErrorException;
import co.com.foodbank.message.exception.MessageNotFoundException;
import co.com.foodbank.message.interfaces.IMessage;
import co.com.foodbank.message.service.MessageService;

/**
 * @author mauricio.londono@gmail.com co.com.foodbank.message.v1.controller
 *         9/08/2021
 */
/**
 * @author mauricio.londono@gmail.com co.com.foodbank.message.v1.controller
 *         11/08/2021
 */
@Controller
public class MessageController {

    @Autowired
    private MessageService service;


    /**
     * Method to find a message.
     * 
     * @param id
     * @return {@code IMessage}
     */
    public IMessage findById(@NotBlank @NotNull String id)
            throws MessageNotFoundException {
        return service.findById(id);
    }

    /**
     * Method to create a Message.
     * 
     * @param dto
     * @return {@code IMessage }
     * @throws SDKUserServiceIllegalArgumentException
     * @throws SDKUserServiceException
     * @throws SDKUserServiceNotAvailableException
     * @throws JsonProcessingException
     * @throws JsonMappingException
     */
    public IMessage create(@Valid MessageDTO dto) throws MessageErrorException {
        return service.create(dto);
    }



    /**
     * Method to find all Message
     * 
     * @return {@code IMessage}
     */
    public Collection<IMessage> findByAll() throws MessageNotFoundException {
        return service.findAll();
    }

}
