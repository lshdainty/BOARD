package com.example.board.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class PostVO {
	private int post_code;
	private String post_title;
	private String post_content;
	private Date date;
	private String id;
	private int board_code;
}