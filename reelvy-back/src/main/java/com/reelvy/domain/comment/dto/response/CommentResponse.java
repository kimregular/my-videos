package com.reelvy.domain.comment.dto.response;

import com.reelvy.domain.comment.dto.CommentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CommentResponse {

    private final int commentCount;
    private final List<CommentDto> comments;
}
