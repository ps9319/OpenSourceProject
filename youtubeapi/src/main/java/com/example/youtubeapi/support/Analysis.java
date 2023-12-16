package com.example.youtubeapi.support;

import com.example.youtubeapi.domain.MyVideo;
import com.example.youtubeapi.util.KomoranUtil;
import java.util.List;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import org.springframework.stereotype.Component;

@Component
public class Analysis {
    public List<String> extractNoun(MyVideo myVideo) {
        Komoran komoran = KomoranUtil.toInstance();
        String title = myVideo.getTitle();

        KomoranResult analyze = komoran.analyze(title);
        return analyze.getNouns();
    }
}
