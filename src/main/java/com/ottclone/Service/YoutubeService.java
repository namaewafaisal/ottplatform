package com.ottclone.Service;

import com.ottclone.Entity.Video;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class YoutubeService {

    public List<Video> searchVideos(String query) {

        List<Video> videos = new ArrayList<>();

        try {

            String url = "https://www.youtube.com/results?search_query=" + query;

            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0")
                    .get();

            String html = doc.html();

            String[] parts = html.split("\"videoId\":\"");

            for (int i = 1; i < Math.min(parts.length, 10); i++) {

                String videoId = parts[i].substring(0, 11);

                String videoUrl = "https://www.youtube.com/watch?v=" + videoId;

                String thumbnail =
                        "https://i.ytimg.com/vi/" + videoId + "/hqdefault.jpg";

                String title = "Unknown Title";

                if (parts[i].contains("\"text\":\"")) {

                    String[] titleSplit = parts[i].split("\"text\":\"");

                    if (titleSplit.length > 1) {
                        title = titleSplit[1].split("\"")[0];
                    }
                }

                videos.add(new Video(title, videoUrl, thumbnail));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return videos;
    }
}