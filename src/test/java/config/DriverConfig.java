package config;

import org.aeonbits.owner.Config;


@Config.Sources({
        "system:properties",
        "classpath:config/${driver}.properties"})
public interface DriverConfig extends Config {

    @Key("is.remote")
    Boolean isRemote();

    @DefaultValue("chrome")
    @Key("browser.name")
    String browserName();

    @DefaultValue("100.0")
    @Key("browser.version")
    String browserVersion();

    @DefaultValue("1920x1080")
    @Key("browser.size")
    String browserSize();

    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
    @Key("browser.remote.url")
    String browserRemoteUrl();

    @DefaultValue("https://www.avito.ru/")
    @Key("browser.base.url")
    String browserBaseUrl();

    @DefaultValue("eager")
    @Key("page.load.strategy")
    String pageLoadStrategy();


}
