package kr.hankyungsoo.admin.article.service;

import kr.hankyungsoo.admin.article.dto.ArticleDto;
import kr.hankyungsoo.admin.article.response.ArticleClientResponse;
import kr.hankyungsoo.admin.common.properties.ProjectProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ArticleManagementService {

    private final RestTemplate restTemplate;
    private final ProjectProperties projectProperties;

    public List<ArticleDto> getArticles(){
        URI uri = UriComponentsBuilder.fromHttpUrl(projectProperties.board().url()+"/api/articles")
                .queryParam("size", 10000)
                .build()
                .toUri();

        log.debug("uri ={}", uri);
        ArticleClientResponse response = restTemplate.getForObject(uri, ArticleClientResponse.class);
        System.out.println("response = " + response);

        return Optional.ofNullable(response).orElseGet(ArticleClientResponse::empty).articles();
    }






}
