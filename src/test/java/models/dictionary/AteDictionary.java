package models.dictionary;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AteDictionary {
    String parentName; //наименование родителя
    String name; //наименование
    String government; //орган управления
}