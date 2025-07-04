package com.reelvy.domain.video.entity;

import com.reelvy.domain.user.entity.User;
import com.reelvy.domain.video.dto.request.VideoStatusChangeRequest;
import com.reelvy.domain.video.dto.request.VideoUpdateRequest;
import com.reelvy.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Table(name = "videos")
@NoArgsConstructor(access = PROTECTED)
public class Video extends BaseEntity {

    @Id
    @Column(name = "video_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "video_title")
    private String videoTitle;

    @Column(name = "video_desc")
    private String videoDesc;

    @Column(name = "video_path")
    private String videoPath;

    @Column(name = "video_view")
    private long videoView = 0;

    @Column(name = "video_price_per_view")
    private double videoPricePerView = 1.0;

    @Column(name = "video_status")
    @Enumerated(STRING)
    private VideoStatus videoStatus;

    @Column(name="video_size")
    private long videoSize;

    @Builder
    private Video(User user, String videoTitle, String videoDesc, String videoPath, VideoStatus videoStatus, long videoSize) {
        this.user = user;
        this.videoTitle = videoTitle;
        this.videoDesc = videoDesc;
        this.videoPath = videoPath;
        this.videoStatus = videoStatus;
        this.videoSize = videoSize;
    }

    public void updateStatus(VideoStatusChangeRequest videoStatusChangeRequest) {
        this.videoStatus = videoStatusChangeRequest.videoStatus();
    }

    public void updateStatus(VideoStatus videoStatus) {
        this.videoStatus = videoStatus;
    }

    public void viewUpdate() {
        this.videoView++;
    }

    public void changeInfoWith(VideoUpdateRequest videoUpdateRequest) {
        this.videoTitle = videoUpdateRequest.title();
        this.videoDesc = videoUpdateRequest.desc();
        this.videoStatus = videoUpdateRequest.videoStatus();
    }
}
