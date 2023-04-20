package com.PrimerParcial.app.controllers;

import com.PrimerParcial.app.models.ModeloJson;
import com.PrimerParcial.app.models.User;
import com.PrimerParcial.app.services.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import java.io.StringReader;
import java.net.URI;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserServiceImp userServiceImp;
    @GetMapping(value = "/user/{id}")
    public ResponseEntity getById(@PathVariable(name = "id") Long id){
        Map response = new HashMap();
        try {
            response.put("message","Se encontro el usuario");
            response.put("data",userServiceImp.getUserById(id));
            return new ResponseEntity(response,HttpStatus.OK) ;
        }catch (Exception e){
            response.put("message","No se encontro el usuariommgvo");
            response.put("data",e.getMessage());
            return new ResponseEntity(response,HttpStatus.BAD_REQUEST) ;
        }


    }
    @PostMapping(value = "/user")
    public ResponseEntity createUser(@RequestBody User user){
        Map response = new HashMap<>();

        try {
            response.put("message","Usuario Registrado");
            response.put("data",userServiceImp.createUser(user));
            return new ResponseEntity(response,HttpStatus.OK) ;
        }catch (Exception e){
            response.put("message","Usuario No Registrado");
            response.put("data",e.getMessage());
            return new ResponseEntity(response,HttpStatus.BAD_REQUEST) ;
        }
    }
    @GetMapping(value = "/user/list")
    public ResponseEntity listar(){
        Map response = new HashMap<>();
        try{
            response.put("message","Lista de Usuarios");
            response.put("data",userServiceImp.allUsers());
            return new ResponseEntity(response,HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            response.put("message","Lista de Usuarios");
            response.put("data",e.getMessage());
            return new ResponseEntity(response,HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping(value = "/user/{id}")
    public ResponseEntity updateUser(@PathVariable(name="id")Long id, User user){
        Map response = new HashMap();
        try{
            response.put("message","Usuario Actualizado");
            response.put("data",userServiceImp.updateUser(id,user));
            return new ResponseEntity(response,HttpStatus.OK);
        }
        catch (Exception e){
            response.put("message","Usuario no actualizado");
            response.put("data",e.getMessage());
            return new ResponseEntity(response,HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping(value = "/user/api")
    public ResponseEntity apinga() {
        Map<String, Object> response = new HashMap<>();
        try {
            String url = String.format("https://rickandmortyapi.com/api/character/198");
            HttpClient httpClient = HttpClient.newBuilder().build();
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .GET()
                    .build();

            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            String json = httpResponse.body();
            ModeloJson modelo = new Gson().fromJson(json, ModeloJson.class);
            String x = modelo.getName();

            User user = new User();
            user.setLastName(x);
            user.setEmail( modelo.getSpecies());
            User createdUser = userServiceImp.createUser(user);

            response.put("message", "Usuario Actualizado");
            response.put("data", createdUser);

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {
            response.put("message", "Usuario no actualizado");
            response.put("data", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }}

