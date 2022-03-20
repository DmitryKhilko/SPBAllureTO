package models.dictionary;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentDictionary {
    //Переменные для создания билдера (для создания тестовых данных с целью заполнения полей диалогового окна добавления, изменения вида оплаты)
    String name; //наименование

}