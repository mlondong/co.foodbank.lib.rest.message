package co.com.foodbank.message.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import co.com.foodbank.message.v1.model.Message;

/**
 * @author mauricio.londono@gmail.com co.com.foodbank.message.repository
 *         9/08/2021
 */
@Repository
public interface MessageRepository extends MongoRepository<Message, String> {

}
