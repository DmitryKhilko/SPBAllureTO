package models.dictionary;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CertificateChangeCauseDictionary {
    //Переменные для создания билдера (для создания тестовых данных с целью заполнения полей диалогового окна создания новой причины изменения сертификата)
    String name; //наименование
    String sign; //признак изменения (выдача, изм, аннул.)
}