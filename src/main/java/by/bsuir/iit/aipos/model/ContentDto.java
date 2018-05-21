package by.bsuir.iit.aipos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContentDto implements Serializable {

    private static final long serialVersionUID = 6099653246642079233L;

    private String body;
    private String description;

}
