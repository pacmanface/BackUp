package com.headfirst.pacmanface;

public class PhraseOMatic {
    public static String makePhrase(){
        String[] firstPhrase = {"круглосуточный","трех-звенный","30000-футовый","взаимный","обоюдный выигрыш","фронтэнд",
        "на основе вэб-технологий","проникающий","умный","шесть сигм","метод критического пути","динамичный"};
        String[] secondPhrase = {"уполномоченный","трудный","чистый продукт","ориентированный","центральный","распределенный","кластеризованный","фирменный",
        "нестандартный ум","позиционированный","сетевой","сфокусированный","использованный с выгодой","выровненный","нацеленный на","общий","совместный","ускоренный"};
        String[] thirdPhrase = {"процесс","пункт разгрузки","выход из положения","тип структуры","талант","подход","уровень завоеванного внимания",
        "портал","период времени","обзор","образец","пункт следования"};

        int rand1 = (int)(Math.random()*firstPhrase.length);
        int rand2 = (int)(Math.random()*secondPhrase.length);
        int rand3 = (int)(Math.random()*thirdPhrase.length);

        return String.format("all you need is %s, %s, %s.",firstPhrase[rand1],secondPhrase[rand2],thirdPhrase[rand3]);
    }
}