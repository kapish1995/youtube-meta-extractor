package com.YouTubeTools.controller;

import com.YouTubeTools.Model.VideoDetails;
import com.YouTubeTools.service.ThumbnailService;
import com.YouTubeTools.service.YouTubeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class YouTubeVideoController {

    private final YouTubeService youTubeService;
    private final ThumbnailService service;

    @PostMapping("/youtube/video-details")
    public String fetchVideoDetails(@RequestParam String videoUrlOrId, Model model) {
        String videoId = service.extractVideoId(videoUrlOrId);

        if (videoId == null) {
            model.addAttribute("error", "Invalid URL or ID");
            return "video-details"; // ✅ fixed
        }

        VideoDetails details = youTubeService.getVideoDetails(videoId);

        if (details == null) {
            model.addAttribute("error", "Video not found");
        } else {
            model.addAttribute("videoDetails", details);
        }

        model.addAttribute("videoUrlOrId", videoUrlOrId);
        return "video-details"; // ✅ fixed
    }
}
