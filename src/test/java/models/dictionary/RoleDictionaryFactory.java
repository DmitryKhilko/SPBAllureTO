package models.dictionary;

public class RoleDictionaryFactory {
    //Билдер для создания тестовых данных с целью заполнения полей диалогового окна редактирования роли
    public static RoleDictionary get(String name) {
        return RoleDictionary.builder()
                 .name(name)
                 .build();
    }
}
