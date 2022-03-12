package models.dictionary;

public class CertificateChangeCauseDictionaryFactory {
    //Билдер для создания тестовых данных с целью заполнения полей диалогового окна создания новой причины изменения сертификата
    public static CertificateChangeCauseDictionary get(String name, String sign) {
        return CertificateChangeCauseDictionary.builder()
                .name(name)
                .sign(sign)
                .build();
    }
}
