package com.example.youtubeapi.util;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import lombok.experimental.UtilityClass;

@UtilityClass
public class KomoranUtil {
    public static Komoran toInstance(){
        return new Komoran(DEFAULT_MODEL.FULL);
    }
}
