package models.dictionary;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocumentTypeDictionary {
    //Переменные для создания билдера (для создания тестовых данных с целью заполнения полей диалогового окна изменения типа документов)
    String name; //наименование

}