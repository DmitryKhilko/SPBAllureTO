package models.dictionary;

import models.dictionary.AteDictionary;

public class AteDictionaryFactory {
    public static AteDictionary get(String parentName, String name, String government) {
        return AteDictionary.builder()
                .parentName(parentName)
                .name(name)
                .government(government)
                .build();
    }
}
