package com.alura.literalura_challenge.service;

import com.alura.literalura_challenge.model.LibroR;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Conversor {
    private ObjectMapper objectMapper = new ObjectMapper();


    public LibroR parsearDato(String json) {
        try {
            return objectMapper.readValue(json, LibroR.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    public List<LibroR> parsearDatos(String json) {
        List<LibroR> lista = new ArrayList<>();
        try {

            JsonNode jsonObject = objectMapper.readTree(json);
            JsonNode resultados = jsonObject.get("results");

            for (JsonNode node : (ArrayNode) resultados) {
                LibroR libro = objectMapper.treeToValue(node, LibroR.class);
                lista.add(libro);
            }

            return lista;

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
