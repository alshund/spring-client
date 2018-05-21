package by.bsuir.iit.aipos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto implements Serializable {

    private static final long serialVersionUID = -5289470953643299305L;

    private HeaderDto headerDto;
    private ContentDto contentDto;
}
