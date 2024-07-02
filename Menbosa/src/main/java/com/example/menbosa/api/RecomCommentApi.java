package com.example.menbosa.api;

import com.example.menbosa.dto.protector.communicate.CommentListDto;
import com.example.menbosa.dto.protector.communicate.CommentWriteDto;
import com.example.menbosa.dto.protector.page.Criteria;
import com.example.menbosa.dto.protector.page.Slice;
import com.example.menbosa.dto.protector.postscript.RecomCommentListDTO;
import com.example.menbosa.dto.protector.postscript.RecomCommentWriteDTO;
import com.example.menbosa.service.protector.communicate.CommentService;
import com.example.menbosa.service.protector.postscript.RecomCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RecomCommentApi {
    private final RecomCommentService recomCommentService;

    // 댓글작성
    @PostMapping("/v3/communicate/{boardRecomNum}/comment")
    public void commentWrite(@RequestBody RecomCommentWriteDTO recomCommentWriteDTO,
                             @PathVariable("boardRecomNum") Long boardRecomNum,
                             @SessionAttribute("proMemNum") Long proMemNum) {
        recomCommentWriteDTO.setBoardRecomNum(boardRecomNum);
        recomCommentWriteDTO.setProMemNum(proMemNum);
        recomCommentService.registerRecomComment(recomCommentWriteDTO);

        System.out.println(boardRecomNum);
        System.out.println(proMemNum);
        System.out.println(recomCommentWriteDTO);
    }

    //댓글목록
    @GetMapping("/v3/communicate/{boardRecomNum}/comments")
    public List<RecomCommentListDTO> commentList(@PathVariable("boardRecomNum") Long boardRecomNum){
        return recomCommentService.findRecomCommentList(boardRecomNum);
    }

    //페이지네이션
    @GetMapping("/v4/communicate/{boardRecomNum}/comments")
    public Slice<RecomCommentListDTO> commentSlice(@PathVariable("boardRecomNum") Long boardRecomNum, int page){
        Slice<RecomCommentListDTO> slice = recomCommentService.findRecomSlice(new Criteria(page, 5), boardRecomNum);
        System.out.println(slice);
        return slice;
    }

    //댓글삭제
    @DeleteMapping("/v3/communicate/comments/{commentRecomNum}")
    public void deleteComment(@PathVariable("commentRecomNum") Long commentRecomNum){
        recomCommentService.removeRecomComment(commentRecomNum);
    }
}
