package com.example.utils.watchUtil;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Date;

/**
 * @Auther: ld
 * @Date: 2019/7/26 10:56
 * @Param ${tags}
 * @Description:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class XmlMessageHeader {
	//消息类型，event
	@JacksonXmlProperty(localName = "MsgType")
	@JacksonXmlCData
	protected MsgType msgType;
	//开发者微信号
	@JacksonXmlProperty(localName = "ToUserName")
	@JacksonXmlCData
	private String toUser;
	//发送方帐号（一个OpenID）
	@JacksonXmlProperty(localName = "FromUserName")
	@JacksonXmlCData
	private String fromUser;
	//消息创建时间 （整型）
	@JacksonXmlProperty(localName = "CreateTime")
	@JsonDeserialize(using = DateDeserializer.class)
	@JsonSerialize(using = DateSerializer.class)
	private Date createTime;
	//审核不通过原因
	@JacksonXmlProperty(localName = "RefuseReason")
	@JacksonXmlCData
	private String refuseReason;
	//卡券ID
	@JacksonXmlProperty(localName = "CardId")
	@JacksonXmlCData
	private String cardId;
	//code序列号
	@JacksonXmlProperty(localName = "UserCardCode")
	@JacksonXmlCData
	private String userCardCode;
	@JacksonXmlProperty(localName = "UnionId")
	@JacksonXmlCData
	private String unionId;

	public MsgType getMsgType() {
		return msgType;
	}

	public void setMsgType(MsgType msgType) {
		this.msgType = msgType;
	}

	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getRefuseReason() {
		return refuseReason;
	}

	public void setRefuseReason(String refuseReason) {
		this.refuseReason = refuseReason;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getUserCardCode() {
		return userCardCode;
	}

	public void setUserCardCode(String userCardCode) {
		this.userCardCode = userCardCode;
	}

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	@Override
	public String toString() {
		return "XmlMessageHeader{" +
				"msgType=" + msgType +
				", toUser='" + toUser + '\'' +
				", fromUser='" + fromUser + '\'' +
				", createTime=" + createTime +
				", refuseReason='" + refuseReason + '\'' +
				", cardId='" + cardId + '\'' +
				", userCardCode='" + userCardCode + '\'' +
				", unionId='" + unionId + '\'' +
				'}';
	}
}
