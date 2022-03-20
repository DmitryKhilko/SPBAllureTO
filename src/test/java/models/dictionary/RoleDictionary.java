package models.dictionary;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleDictionary {
    //Переменные для создания билдера (для создания тестовых данных с целью заполнения полей диалогового окна изменения роли)
    String name; //наименование

}