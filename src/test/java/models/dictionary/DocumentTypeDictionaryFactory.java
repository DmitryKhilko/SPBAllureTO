package models.dictionary;

public class DocumentTypeDictionaryFactory {
    //Билдер для создания тестовых данных с целью заполнения полей диалогового окна редактирования типа документов
    public static DocumentTypeDictionary get(String name) {
        return DocumentTypeDictionary.builder()
                 .name(name)
                 .build();
    }
}
