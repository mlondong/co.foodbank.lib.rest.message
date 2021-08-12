package co.com.foodbank.message.service;

import java.util.Collection;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.com.foodbank.message.dto.MessageDTO;
import co.com.foodbank.message.exception.MessageErrorException;
import co.com.foodbank.message.exception.MessageNotFoundException;
import co.com.foodbank.message.interfaces.IMessage;
import co.com.foodbank.message.repository.MessageRepository;
import co.com.foodbank.message.v1.model.Message;

/**
 * @author mauricio.londono@gmail.com co.com.foodbank.message.service 9/08/2021
 */
/**
 * @author mauricio.londono@gmail.com co.com.foodbank.message.service 11/08/2021
 */
@Service
@Transactional
public class MessageService {

    @Autowired
    private MessageRepository repository;

    @Autowired
    private ModelMapper modelMapper;


    /**
     * Method to find a message.
     * 
     * @param id
     * @return {@code IMessage}
     */
    public IMessage findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new MessageNotFoundException(id));
    }



    /**
     * Method to create a Message.
     * 
     * @param dto
     * @return {@code IMessage}
     * @throws MessageErrorException
     */
    public IMessage create(MessageDTO dto) throws MessageErrorException {
        Message msg = modelMapper.map(dto, Message.class);
        return repository.save(msg);
    }



    /**
     * Method to find all Message
     * 
     * @return {@code IMessage}
     */
    public Collection<IMessage> findAll() throws MessageNotFoundException {
        return repository.findAll().stream()
                .map(d -> modelMapper.map(d, IMessage.class))
                .collect(Collectors.toList());
    }



}
