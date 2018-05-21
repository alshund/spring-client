package by.bsuir.iit.aipos;

import by.bsuir.iit.aipos.model.ArticleDto;
import by.bsuir.iit.aipos.model.ContentDto;
import by.bsuir.iit.aipos.model.HeaderDto;
import by.bsuir.iit.aipos.service.RestConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private RestConnector restConnector;

    @RequestMapping(value = "/article-list", method = RequestMethod.GET)
    public ModelAndView getArticleList() {

        List<HeaderDto> headerDtoList = restConnector.getArticleList();
        return new ModelAndView("pages/pattern-list.jsp", "articleList", headerDtoList);
    }

    @RequestMapping(value = "/get-article", method = RequestMethod.GET)
    public ModelAndView getArticle(@RequestParam String authorEmail, @RequestParam String patternName) {

        ArticleDto articleDto = restConnector.getArticle(authorEmail, patternName);
        return new ModelAndView("pages/add-article.jsp", "articleDto", articleDto);
    }

    @RequestMapping(value = "/update-article", method = RequestMethod.POST)
    public ModelAndView updateArticle(@RequestParam String updatableName, @RequestParam String updatableEmail,
                                      @RequestParam String patternName, @RequestParam String authorEmail,
                                      @RequestParam String content, @RequestParam String description) {

        HeaderDto headerDto = new HeaderDto(authorEmail, patternName);
        ContentDto contentDto = new ContentDto(content, description);
        restConnector.updateArticle(updatableEmail, updatableName, new ArticleDto(headerDto, contentDto));
        return getArticleList();
    }

    @RequestMapping(value = "/add-article", method = RequestMethod.POST)
    public ModelAndView addArticle(@RequestParam String patternName, @RequestParam String authorEmail,
                                   @RequestParam String content, @RequestParam String description) {

        HeaderDto headerDtoDto = new HeaderDto(authorEmail, patternName);
        ContentDto contentDtoDto = new ContentDto(content, description);
        restConnector.addArticle(new ArticleDto(headerDtoDto, contentDtoDto));
        return getArticleList();
    }

    @RequestMapping(value = "/remove-article", method = RequestMethod.POST)
    public ModelAndView removeArticle(@RequestParam String patternName, @RequestParam String authorEmail) {

        restConnector.removeArticle(new HeaderDto(authorEmail, patternName));
        return getArticleList();
    }

}
