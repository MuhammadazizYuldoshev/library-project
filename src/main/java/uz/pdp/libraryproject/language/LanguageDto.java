package uz.pdp.libraryproject.language;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LanguageDto {

    private Integer languageIds;

    private String lang;
}
