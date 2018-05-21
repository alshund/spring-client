package by.bsuir.iit.aipos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeaderDto implements Serializable {

    private static final long serialVersionUID = 4511677019956713586L;

    private String authorEmail;
    private String patternName;
}
