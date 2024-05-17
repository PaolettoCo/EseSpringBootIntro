package com.example.demoswagger.person.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class NameController {

    @GetMapping(path = "/{name}")
    @Operation(
            description = "Retrieves a name based on the provided ID",
            operationId = "getName",
            tags = "name",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Name retrieved successfully",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = String.class) // Returning a String
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Name not found",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = ErrorResponse.class)
                                    )
                            }
                    )
            }
    )
    public String name(@PathVariable("name") String name){
        return name;
    }

    @PostMapping(path = "/{name}")
    @Operation(
            description = "Retrieves a name based on the provided ID",
            operationId = "getName",
            tags = "name",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Name retrieved successfully",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = String.class)
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Name not found",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = ErrorResponse.class) 
                                    )
                            }
                    )
            }
    )
    public String reverseName(@PathVariable("name") String name){
        return new StringBuilder(name).reverse().toString();
    }
}
