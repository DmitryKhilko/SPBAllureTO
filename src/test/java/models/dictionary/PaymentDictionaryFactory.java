package models.dictionary;

public class PaymentDictionaryFactory {
    //Билдер для создания тестовых данных с целью заполнения полей диалогового окна добавления, редактирования вида оплаты
    public static PaymentDictionary get(String name) {
        return PaymentDictionary.builder()
                 .name(name)
                 .build();
    }
}
