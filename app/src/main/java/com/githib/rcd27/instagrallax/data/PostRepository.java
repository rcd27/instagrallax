package com.githib.rcd27.instagrallax.data;


import java.util.ArrayList;
import java.util.List;

public class PostRepository {

    private static PostRepository instance;
    private final List<String> comments;

    private PostRepository() {
        this.comments = new ArrayList<String>() {{
            add("А, ну, конечно, если всё вокруг сгибается, то виноват робот, созданный для сгибания.");
            add("Вдруг моя жизнь — выдумка чьего-то больного воображения?");
            add("Всё что угодно, кроме бессмертия, — бесполезная трата времени.");
            add("Итак, я богат. Пока, неудачники! Я вас всегда ненавидел.");
            add("Каждый раз, когда я говорил: «Смерть всем людям», шепотом добавлял: «Кроме одного». Им был Фрай. Я так ему и не сказал этого.");
            add("Качание — это всего лишь примитивная разновидность сгибания!");
            add("Мне не нужна выпивка! Я могу бросить в любой момент.");
            add("Мне так стыдно! Хочу, чтобы все умерли!");
            add("На помощь! На помощь! Я слишком ленив, чтобы спасаться!");
            add("Не бейте меня!.. Я предам кого угодно!");
            add("Не люблю тусоваться! Просто у меня шило в жопе, которого я не просил!");
            add("Он напрашивается на сгибание!");
            add("Позёры! Я ненавидел Зойдберга ещё до того, как это стало модным.");
            add("Пока, начинки для гробов.");
            add("Спаси моих друзей… и Зойдберга!");
        }};
    }

    public static PostRepository getInstance() {
        if (null == instance) {
            instance = new PostRepository();
        }
        return instance;
    }

    public List<String> getComments() {
        return comments;
    }
}
