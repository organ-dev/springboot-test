package com.example.utils.seq;

import com.example.utils.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


/**
 * @Auther: ld
 * @Date: 2019/4/28 11:56
 * @Param ${tags}
 * @Description: 获取唯一标识，由于注入问题，启动有问题
 */
@Service
@Configuration
public class BusinessSeqService {
	/**
	 * 我方系统生成唯一订单流水号前缀
	 **/
	private static final String ORDER_ID_PREFIX = "O";
	/**
	 * 我方系统生成唯一支付流水号前缀
	 **/
	private static final String PAY_ID_PREFIX = "P";

	private static final String MER_NO_PREFIX = "M";

	private static final char PAD_ZERO = '0';
	private static final String MER_USER_PREFIX = "U";

	private static final long MAX_NO_VALUE = 999999999999L;

	private final RedisSequences redisSequences;


	// orderId
	private static final String ORDER_ID_SEQ = "aggrPay:orderId";
	private static final String PAY_ID_SEQ = "aggrPay:payId";
	private static final String MER_NO_SEQ = "aggrPay:aggrMerCustNo";
	private static final String MER_USER_SEQ = "aggrPay:userNo";


	public BusinessSeqService(RedisSequences redisSequences) {
		this.redisSequences = redisSequences;
	}

	@PostConstruct
	public void initialization() {

		redisSequences.setCycleMaxValue(ORDER_ID_SEQ, MAX_NO_VALUE);
		redisSequences.setCycleMaxValue(PAY_ID_SEQ, MAX_NO_VALUE);
		redisSequences.setCycleMaxValue(MER_NO_SEQ, MAX_NO_VALUE);
		redisSequences.setCycleMaxValue(MER_USER_SEQ, MAX_NO_VALUE);

	}

	/**
	 * 聚合支付给商户分配的内部唯一编号
	 *
	 * @return
	 */
	public String getAggrMerCustNo() {
		String merNo = "";
		Long merNoL = redisSequences.nextVal(MER_NO_SEQ);
		if (merNoL == null) {
			return merNo;
		}
		// 不足11位，前面补零
		String zeroMsgId = StringUtils.leftPad(merNoL.toString(), 11, PAD_ZERO);

		// yyyyMMdd
		String date = DateUtil.getCurrentDateString();

		merNo = MER_NO_PREFIX + date.concat(zeroMsgId);
		// 不足位数，返回空
		return merNo;
	}


	/**
	 * 获取orderId<br>
	 * 时间(yyyyMMdd)+随机数(11位，位数不足，前补零)
	 *
	 * @return orderId
	 */
	public String getOrderId() {
		String orderId = "";
		Long orderIdL = redisSequences.nextVal(ORDER_ID_SEQ);
		if (orderIdL == null) {
			return orderId;
		}
		// 不足12位，前面补零
		String zeroMsgId = StringUtils.leftPad(orderIdL.toString(), 11, PAD_ZERO);

		//yyyyMMdd
		String date = DateUtil.getCurrentDateString();

		orderId = ORDER_ID_PREFIX + date.concat(zeroMsgId);
		// 不足位数，返回空
		return orderId;
	}

	/**
	 * 获取支付流水号:PayId<br>
	 * 时间(yyyyMMdd)+随机数(11位，位数不足，前补零)
	 *
	 * @return orderId
	 */
	public String getPayId() {
		String orderId = "";
		Long orderIdL = redisSequences.nextVal(PAY_ID_SEQ);
		if (orderIdL == null) {
			return orderId;
		}
		// 不足12位，前面补零
		String zeroMsgId = StringUtils.leftPad(orderIdL.toString(), 11, PAD_ZERO);

		// yyyyMMdd
		String date = DateUtil.getCurrentDateString();

		orderId = PAY_ID_PREFIX + date.concat(zeroMsgId);
		// 不足位数，返回空
		return orderId;
	}

	public String getUserNo() {
		String userNo = "";
		Long userIdL = redisSequences.nextVal(MER_USER_SEQ);
		if (userIdL == null) {
			return userNo;
		}
		// 不足12位，前面补零
		String zeroMsgId = StringUtils.leftPad(userIdL.toString(), 11, PAD_ZERO);

		// yyyyMMdd
		String date = DateUtil.getCurrentDateString();

		userNo = MER_USER_PREFIX + date.concat(zeroMsgId);
		// 不足位数，返回空
		return userNo;
	}
}
