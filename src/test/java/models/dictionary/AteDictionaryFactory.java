package models.dictionary;

public class AteDictionaryFactory {
    //Билдер для создания тестовых данных с целью заполнения полей диалогового окна создания нового АТЕ
    public static AteDictionary get(String parentName, String name, String government) {
        return AteDictionary.builder()
                .parentName(parentName)
                .name(name)
                .government(government)
                .build();
    }
}
