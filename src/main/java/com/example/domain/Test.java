package com.example.domain;

/**
 * @Auther: ld
 * @Date: 2019/5/16 15:50
 * @Param ${tags}
 * @Description:
 */
public class Test {

	/**
	 * meta : {"ret_code":"00466687","ret_msg":"银行卡已签约"}
	 * data : {"trade_no":"1905061634014684","p_agreement_id":"xxxxxxxxxx","mer_id":"90000002","version":"1.0"}
	 */

	private MetaBean meta;
	private DataBean data;

	public MetaBean getMeta() {
		return meta;
	}

	public void setMeta(MetaBean meta) {
		this.meta = meta;
	}

	public DataBean getData() {
		return data;
	}

	public void setData(DataBean data) {
		this.data = data;
	}

	public static class MetaBean {
		/**
		 * ret_code : 00466687
		 * ret_msg : 银行卡已签约
		 */

		private String ret_code;
		private String ret_msg;

		public String getRet_code() {
			return ret_code;
		}

		public void setRet_code(String ret_code) {
			this.ret_code = ret_code;
		}

		public String getRet_msg() {
			return ret_msg;
		}

		public void setRet_msg(String ret_msg) {
			this.ret_msg = ret_msg;
		}
	}

	public static class DataBean {
		/**
		 * trade_no : 1905061634014684
		 * p_agreement_id : xxxxxxxxxx
		 * mer_id : 90000002
		 * version : 1.0
		 */

		private String trade_no;
		private String p_agreement_id;
		private String mer_id;
		private String version;

		public String getTrade_no() {
			return trade_no;
		}

		public void setTrade_no(String trade_no) {
			this.trade_no = trade_no;
		}

		public String getP_agreement_id() {
			return p_agreement_id;
		}

		public void setP_agreement_id(String p_agreement_id) {
			this.p_agreement_id = p_agreement_id;
		}

		public String getMer_id() {
			return mer_id;
		}

		public void setMer_id(String mer_id) {
			this.mer_id = mer_id;
		}

		public String getVersion() {
			return version;
		}

		public void setVersion(String version) {
			this.version = version;
		}
	}
}
