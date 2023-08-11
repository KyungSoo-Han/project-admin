package kr.hankyungsoo.admin.article.controller;

import kr.hankyungsoo.admin.article.response.ArticleResponse;
import kr.hankyungsoo.admin.article.service.ArticleManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/management/articles")
@Controller
public class ArticleAdminController {
    private final ArticleManagementService articleManagementService;

    @GetMapping
    public String articles(Model model){
        model.addAttribute("articles", articleManagementService.getArticles().stream().map(ArticleResponse::withoutContent).toList());

        return "management/articles";
    }
}
