package com.example.tacocloudch07restclient;

import com.example.tacocloudch07restclient.entity.Ingredient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class RestClient {

    private final RestTemplate rest;

    public RestClient(RestTemplate rest) {
        this.rest = rest;
    }

    public Ingredient getIngredientById(String ingredientId) {
//        return rest.getForObject("http://localhost:8080/data-api/ingredients/{id}",
//                Ingredient.class, ingredientId);

        try {
            ResponseEntity<Ingredient> responseEntity =
                rest.getForEntity("http://localhost:8080/data-api/ingredients/{id}",
                        Ingredient.class, ingredientId);
            log.info("Fetched time: {}",
                    responseEntity.getHeaders().getDate());
            return responseEntity.getBody();
        } catch (HttpClientErrorException e) {
            log.info("Ingredient with id " + ingredientId + " was not found");
        }
        return null;
    }

    public Ingredient createIngredient(Ingredient ingredient) {
        ResponseEntity<Ingredient> responseEntity = rest.postForEntity("http://localhost:8080/data-api/ingredients/",
                 ingredient,
                Ingredient.class);
        log.info("New resource created at {}",
                responseEntity.getHeaders().getLocation());
        return responseEntity.getBody();
    }

    public void deleteIngredient(Ingredient ingredient) {
        rest.delete("http://localhost:8080/data-api/ingredients/{id}",
                ingredient.getId());
    }


}
