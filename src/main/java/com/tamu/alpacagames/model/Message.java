package com.tamu.alpacagames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MsgSeq")
	@SequenceGenerator(name = "MsgSeq", sequenceName = "Msg_SEQ" )
	Long messageId;
	private String sendername;
	private String senderemail;
	private String subject;
	private String msg;
	
	public Long getMessageId() {
		return messageId;
	}
	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}
	public String getSendername() {
		return sendername;
	}
	public void setSendername(String sendername) {
		this.sendername = sendername;
	}
	public String getSenderemail() {
		return senderemail;
	}
	public void setSenderemail(String senderemail) {
		this.senderemail = senderemail;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}