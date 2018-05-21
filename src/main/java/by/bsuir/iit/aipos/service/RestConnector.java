package by.bsuir.iit.aipos.service;

import by.bsuir.iit.aipos.model.ArticleDto;
import by.bsuir.iit.aipos.model.HeaderDto;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class RestConnector {

    private static String GET_ARTICLES_URL = "http://localhost:8080/spring-rest-0.0.1-SNAPSHOT/patterns/";
    private static String ADD_ARTICLE_URL = "http://localhost:8080/spring-rest-0.0.1-SNAPSHOT/patterns/add";
    private static String ARTICLE_URL = "http://localhost:8080/spring-rest-0.0.1-SNAPSHOT/patterns/%s/%s";

    public List<HeaderDto> getArticleList() {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        ResponseEntity<HeaderDto[]> response = restTemplate.getForEntity(GET_ARTICLES_URL, HeaderDto[].class);

        return Arrays.asList(response.getBody());
    }

    public ArticleDto getArticle(String email, String name) {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        return restTemplate.getForObject(String.format(ARTICLE_URL, email, name), ArticleDto.class);
    }

    public void addArticle(ArticleDto articleDto) {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        restTemplate.postForObject(ADD_ARTICLE_URL, articleDto, ArticleDto.class);
    }

    public void removeArticle(HeaderDto headerDto) {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(String.format(ARTICLE_URL, headerDto.getAuthorEmail(), headerDto.getPatternName()));
    }

    public void updateArticle(String updatableEmail, String updatableName, ArticleDto articleDto) {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        restTemplate.put(String.format(ARTICLE_URL, updatableEmail, updatableName), articleDto, ArticleDto.class);
    }
}
