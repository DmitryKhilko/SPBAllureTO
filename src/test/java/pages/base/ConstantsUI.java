package pages.base;

import org.testng.ITestContext;

import java.util.ArrayList;

public class ConstantsUI extends BasePage{

    //****************************************************************************************************************************************************************************
    //Административная часть КЗ СПБ
    //Константы, связанные с названиями пунктов меню, заголовками страниц, сообщениями
    //****************************************************************************************************************************************************************************

    //страница логина
    public static final String LOGIN_PAGE_TITLE = "Авторизация"; //заголовок страницы
    public static final String LOGIN_LABEL = "Логин"; //название поля для ввода логина
    public static final String PASSWORD_LABEL = "Пароль"; //название поля для ввода пароля


    //раздел "Квалификационный экзамен". Названия пунктов горизонтального, вертикального меню + названия страниц
    public static final String GMENU_01 = "Квалификационный экзамен";
    public static final String VMENU_0101 = "Расписание экзаменов";
    public static final String VMENU_0101_TITLE = "Расписание квалификационных экзаменов";
    public static final String VMENU_0102 = "Контроль за ходом тестирования";
    public static final String VMENU_0102_TITLE = "Контроль за ходом тестирования";
    public static final String VMENU_0103 = "Уведомление претендентов и членов комиссии";
    public static final String VMENU_0103_TITLE = "Уведомление претендентов и членов комиссии";
    public static final String VMENU_0104 = "Фиксирование результатов решения задач";
    public static final String VMENU_0104_TITLE = "Фиксирование результатов решения задач";
    public static final String VMENU_0105 = "Формирование предложений и протоколов";
    public static final String VMENU_0105_TITLE = "Формирование предложений и протоколов";
    public static final String VMENU_0106 = "Формирование ведомостей/уведомлений";
    public static final String VMENU_0106_TITLE = "Формирование ведомостей/уведомлений";

    //Раздел "Квалификационный экзамен". Названия пунктов горизонтального, вертикального меню + названия страниц
    public static final String GMENU_02 = "Подтверждение квалификации";
    public static final String VMENU_0201 = "Расписание экзаменов";
    public static final String VMENU_0201_TITLE = "Расписание экзаменов для подтверждения квалификации профессиональных бухгалтеров";
    public static final String VMENU_0202 = "Контроль за ходом тестирования";
    public static final String VMENU_0202_TITLE = "Контроль за ходом тестирования";
    public static final String VMENU_0203 = "Уведомление проф. бухгалтеров и членов комиссии";
    public static final String VMENU_0203_TITLE = "Уведомление проф. бухгалтеров и членов комиссии";
    public static final String VMENU_0204 = "Формирование предложений и протоколов";
    public static final String VMENU_0204_TITLE = "Формирование предложений и протоколов";
    public static final String VMENU_0205 = "Формирование ведомостей и приказов";
    public static final String VMENU_0205_TITLE = "Формирование ведомостей и приказов"; //наименование вкладки

    //Раздел "Ведение реестра сертификатов". Названия пунктов горизонтального, вертикального меню + названия страниц
    public static final String GMENU_03 = "Ведение реестра сертификатов";
    public static final String VMENU_0301 = "Дела";
    public static final String VMENU_0301_TITLE = "Претенденты"; //наименование вкладки
    public static final String VMENU_0302 = "Реестр оплат";
    public static final String VMENU_0302_TITLE = "Реестр оплат";
    public static final String VMENU_0303 = "Реестр сертификатов";
    public static final String VMENU_0303_TITLE = "Реестр сертификатов";
    public static final String VMENU_0304 = "Приказы о выдаче и об аннулировании";
    public static final String VMENU_0304_TITLE = "Приказы";
    public static final String VMENU_0305 = "Отчеты";
    public static final String VMENU_0305_TITLE = "Отчеты";

    //Раздел "Курирование деятельности по сертификации". Названия пунктов горизонтального, вертикального меню + названия страниц
    public static final String GMENU_04 = "Курирование деятельности по сертификации";
    public static final String VMENU_0401 = "Подтверждение регистрации";
    public static final String VMENU_0401_TITLE = "Список незарегистрированных пользователей";
    public static final String VMENU_0402 = "Ведение состава комиссии";
    public static final String VMENU_0402_TITLE = "Состав квалификационной комиссии";
    public static final String VMENU_0403 = "Документы для квалификационного экзамена";
    public static final String VMENU_0403_TITLE = "Документы";
    public static final String VMENU_0404 = "Документы для подтверждения квалификации";
    public static final String VMENU_0404_TITLE = "Документы";
    public static final String VMENU_GROUP0401 = "Публикация на портале";
    public static final String VMENU_0405 = "Информация о профессиональных бухгалтерах";
    public static final String VMENU_0405_TITLE = "Публикация информации о профессиональных бухгалтерах";
    public static final String VMENU_0406 = "Справочная информация";
    public static final String VMENU_0406_TITLE = "Справочная инфомарция на портале";

    //Раздел "Подготовка базы данных знаний". Названия пунктов горизонтального, вертикального меню + названия страниц
    public static final String GMENU_05 = "Подготовка базы данных знаний";
    public static final String VMENU_0501 = "Электронная библиотека";
    public static final String VMENU_0501_TITLE = "Разделы электронной библиотеки"; //иное наименование раздела
    public static final String VMENU_0502 = "Подготовка вопросов и задач";
    public static final String VMENU_0502_TITLE = "Иерархия"; //наименование вкладки
    public static final String VMENU_0503 = "Вопросы для предварительного тестирования";
    public static final String VMENU_0503_TITLE = "Вопросы для предварительного тестирования"; //иное наименование раздела
    public static final String VMENU_0504 = "Вопросы для квалификационного экзамена";
    public static final String VMENU_0504_TITLE = "Вопросы для квалификационного экзамена"; //иное наименование раздела
    public static final String VMENU_0505 = "Вопросы для предв. подтверждения квалификации";
    public static final String VMENU_0505_TITLE = "Вопросы для предв. подтверждения квалификации"; //иное наименование раздела
    public static final String VMENU_0506 = "Вопросы для подтверждения квалификации";
    public static final String VMENU_0506_TITLE = "Вопросы для подтверждения квалификации"; //иное наименование раздела

    //Раздел "Администрирование". Названия пунктов горизонтального, вертикального меню + названия страниц
    public static final String GMENU_06 = "Администрирование";
    public static final String VMENU_GROUP0601 = "Справочники";
    public static final String VMENU_0601 = "Справочник АТЕ";
    public static final String VMENU_0601_TITLE = "Справочник АТЕ";
    public static final String VMENU_0602 = "Справочник оплат";
    public static final String VMENU_0602_TITLE = "Справочник оплат";
    public static final String VMENU_0603 = "Справочник причин изменения сертификата профессионального бухгалтера";
    public static final String VMENU_0603_TITLE = "Справочник причин изменения сертификата профессионального бухгалтера";
    public static final String VMENU_0604 = "Справочник ролей";
    public static final String VMENU_0604_TITLE = "Справочник ролей";
    public static final String VMENU_0605 = "Справочник типов документов";
    public static final String VMENU_0605_TITLE = "Справочник типов документов";
    public static final String VMENU_0606 = "Справочник типов экзаменов";
    public static final String VMENU_0606_TITLE = "Справочник типов экзаменов";
    public static final String VMENU_0607 = "Справочник статусов документов от внешних пользователей";
    public static final String VMENU_0607_TITLE = "Справочник статусов документов от внешних пользователей";
    public static final String VMENU_0608 = "Справочник типов прочтения сообщений";
    public static final String VMENU_0608_TITLE = "Справочник типов прочтения сообщений";
    public static final String VMENU_GROUP0602 = "Пользователи";
    public static final String VMENU_0609 = "Зарегистрированные";
    public static final String VMENU_0609_TITLE = "Список зарегистрированных пользователей";
    public static final String VMENU_GROUP0603 = "Настройки";
    public static final String VMENU_0610 = "Системные";
    public static final String VMENU_0610_TITLE = "Настройки системные";
    public static final String VMENU_0611 = "Безопасность";
    public static final String VMENU_0611_TITLE = "Настройки безопасности";
    public static final String VMENU_0612 = "Журнал событий";
    public static final String VMENU_0612_TITLE = "Журнал событий";

    //Раздел "Текущий пользователь". Названия пунктов горизонтального, вертикального меню + названия страниц
    public static final String GMENU_07 = "Текущий пользователь";
    public static final String VMENU_0701 = "Профиль";
    public static final String VMENU_0701_TITLE = "Профиль пользователя"; //иное наименование раздела
    public static final String VMENU_0702 = "Изменить пароль";
    public static final String VMENU_0702_TITLE = "Изменение пароля";

    //Раздел "Почта". Названия пунктов горизонтального, вертикального меню + названия страниц
    public static final String VMENU_08 = "Почта";
    public static final String VMENU_0801 = "Новое сообщение";
    public static final String VMENU_0801_TITLE = "Новое сообщение";
    public static final String VMENU_0802 = "Входящие";
    public static final String VMENU_0802_TITLE = "Входящие сообщения";
    public static final String VMENU_0803 = "Исходящие";
    public static final String VMENU_0803_TITLE = "Исходящие сообщения";

    public static final String VMENU_09 = "Выйти";

    //сообщения окон уведомлений
    public static final String MESSAGE_NOTIFICATION_WINDOW_01 = "Ошибка авторизации: Неправильный логин или пароль";

    //сообщение о незаполненных полях ввода
    public static final String INPUT_ERROR_MESSAGE = "Поле обязательно!";


    //****************************************************************************************************************************************************************************
    //Административная часть КЗ СПБ
    //Константы, связанные с названиями пунктов меню, заголовками страниц, сообщениями
    //****************************************************************************************************************************************************************************

    //страница логина
    public static final String PORTAL_LOGIN_PAGE_HYPERLINK = "Войти"; //гиперссылка на стартовой странице для вызова диалогового окна входа
    public static final String PORTAL_LOGIN_LABEL = "Экранное имя"; //название поля для ввода логина
    public static final String PORTAL_PASSWORD_LABEL = "Пароль"; //название поля для ввода пароля

    //Конструктор для использования аттрибутов выполняемого теста (названия теста и т.п.)
    public ConstantsUI(ITestContext context) {
        super(context);
    }
}
