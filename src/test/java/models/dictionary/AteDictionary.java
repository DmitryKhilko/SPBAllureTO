package models.dictionary;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AteDictionary {
    //Переменные для создания билдера (для создания тестовых данных с целью заполнения полей диалогового окна создания нового АТЕ)
    String parentName; //наименование родителя
    String name; //наименование
    String government; //орган управления
}