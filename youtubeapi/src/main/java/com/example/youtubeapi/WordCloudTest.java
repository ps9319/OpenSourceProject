package com.example.youtubeapi;

import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.bg.PixelBoundaryBackground;
import com.kennycason.kumo.font.scale.SqrtFontScalar;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.palette.ColorPalette;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class WordCloudTest {
    public static void main(String[] args) throws IOException {
        final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
        frequencyAnalyzer.setWordFrequenciesToReturn(300);
        final List<WordFrequency> wordFrequencies = frequencyAnalyzer.load("/Users/minkyu/Desktop/SpringStudy/OpenSourceProject/youtubeapi/src/main/resources/20231213.txt");
        final Dimension dimension = new Dimension(500, 500);
        final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
        wordCloud.setPadding(0);
        wordCloud.setBackground(new PixelBoundaryBackground("/Users/minkyu/Desktop/SpringStudy/OpenSourceProject/youtubeapi/src/main/resources/youtubeimage.png"));
        wordCloud.setColorPalette(new ColorPalette(new Color(0xFC5435), new Color(0xFC9A35), new Color(0xFC7735), new Color(0xFF2A38), new Color(0xFCB735), new Color(0xFFFFFF)));
        wordCloud.setFontScalar(new SqrtFontScalar(10, 30));
        wordCloud.build(wordFrequencies);
        wordCloud.writeToFile("/Users/minkyu/Desktop/SpringStudy/OpenSourceProject/youtubeapi/src/main/resources/20231213.png");
    }
}
