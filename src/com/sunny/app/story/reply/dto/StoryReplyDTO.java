package com.sunny.app.story.reply.dto;

/*reply_number int unsigned auto_increment primary key,
reply_content varchar(1000) not null,
reply_date datetime,
alter table tbl_story_reply add column reply_viewcnt int unsigned;
story_number int unsigned not null,
user_number int unsigned not null,
*/

public class StoryReplyDTO {
	private int replyNumber;
	private String replyContent;
	private String replyDate;
	private int replyViewcnt;
	private int userNumber;
	private int storyNumber;
	
	public StoryReplyDTO() {}

	public int getReplyNumber() {
		return replyNumber;
	}

	public void setReplyNumber(int replyNumber) {
		this.replyNumber = replyNumber;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getDateTime() {
		return replyDate;
	}

	public void setDateTime(String dateTime) {
		this.replyDate = dateTime;
	}

	public int getReplyViewcnt() {
		return replyViewcnt;
	}

	public void setReplyViewcnt(int replyViewcnt) {
		this.replyViewcnt = replyViewcnt;
	}

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public int getStoryNumber() {
		return storyNumber;
	}

	public void setStoryNumber(int storyNumber) {
		this.storyNumber = storyNumber;
	}

	@Override
	public String toString() {
		return "StoryReplyDTO [replyNumber=" + replyNumber + ", replyContent=" + replyContent + ", replyDate=" + replyDate
				+ ", replyViewcnt=" + replyViewcnt + ", userNumber=" + userNumber + ", storyNumber=" + storyNumber
				+ "]";
	}
}
