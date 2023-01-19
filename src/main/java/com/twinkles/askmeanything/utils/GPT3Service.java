package com.twinkles.askmeanything.utils;
import com.twinkles.askmeanything.dto.request.Gpt3Request;
import com.twinkles.askmeanything.dto.response.Gpt3Response;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

public class GPT3Service {

        private static final String API_URL = System.getenv("API_URL");
        private static final String API_KEY = System.getenv("API_KEY");

        public static String generateText(String prompt) {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/json");
            headers.set("Authorization", "Bearer " + API_KEY);

            Gpt3Request request = new Gpt3Request();
            request.setPrompt(prompt);
            request.setMax_tokens(250);
            request.setTemperature(1);


            HttpEntity<Gpt3Request> entity = new HttpEntity<>(request, headers);

            Gpt3Response response = restTemplate.postForObject(API_URL, entity, Gpt3Response.class);
            assert response != null;
            for (int i = 0; i < response.getChoices().size(); i++) {
                System.out.println(response.getChoices().get(i));
            }
            return response.getChoices().get(0).getText();
        }
    }


