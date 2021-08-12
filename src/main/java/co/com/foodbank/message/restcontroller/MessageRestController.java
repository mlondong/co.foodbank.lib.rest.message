package co.com.foodbank.message.restcontroller;

import java.util.Collection;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import co.com.foodbank.message.dto.MessageDTO;
import co.com.foodbank.message.exception.MessageErrorException;
import co.com.foodbank.message.exception.MessageNotFoundException;
import co.com.foodbank.message.interfaces.IMessage;
import co.com.foodbank.message.v1.controller.MessageController;
import co.com.foodbank.message.v1.model.Message;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author mauricio.londono@gmail.com co.com.foodbank.message.restcontroller
 *         9/08/2021
 */
@RestController
@RequestMapping(value = "/message")
@Tag(name = "Message", description = "the Message API")
@Validated
public class MessageRestController {


    @Autowired
    private MessageController controller;



    /**
     * Method to find Message By Id.
     * 
     * @param id
     * @return {@code ResponseEntity<IMessage>}
     * @throws MessageNotFoundException
     */
    @Operation(summary = "Find Message by Id.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200",
                            description = "Message found.",
                            content = {
                                    @Content(mediaType = "application/json")}),
                    @ApiResponse(responseCode = "500",
                            description = "Service not available.",
                            content = @Content),
                    @ApiResponse(responseCode = "400",
                            description = "Bad request.", content = @Content)})
    @GetMapping(path = "/findById/{id-message}")
    public ResponseEntity<IMessage> findById(
            @PathVariable("id-message") @NotBlank @NotNull String id)
            throws MessageNotFoundException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(controller.findById(id));
    }



    /**
     * Method to find Message By Id.
     * 
     * @param id
     * @return {@code ResponseEntity<IMessage>}
     * @throws MessageNotFoundException
     */
    @Operation(summary = "Find All Messages.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200",
                            description = "Message found.",
                            content = {
                                    @Content(mediaType = "application/json")}),
                    @ApiResponse(responseCode = "500",
                            description = "Service not available.",
                            content = @Content),
                    @ApiResponse(responseCode = "400",
                            description = "Bad request.", content = @Content)})
    @GetMapping(path = "/findAll")
    public ResponseEntity<Collection<IMessage>> findById()
            throws MessageNotFoundException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(controller.findByAll());
    }



    @Operation(summary = "Create a new Message", description = "",
            tags = {"message"})
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201",
                            description = "Message created",
                            content = @Content(schema = @Schema(
                                    implementation = Message.class))),
                    @ApiResponse(responseCode = "400",
                            description = "Invalid input"),
                    @ApiResponse(responseCode = "409",
                            description = "Message already exists")})
    @PostMapping(value = "/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<IMessage> create(@RequestBody @Valid MessageDTO dto)
            throws MessageErrorException {
        return new ResponseEntity<IMessage>(controller.create(dto),
                HttpStatus.CREATED);
    }



}
