package com.tj.cal_ex;

public class MyCal {
	private int fn;
	public int getFn() {
		return fn;
	}

	public void setFn(int fn) {
		this.fn = fn;
	}

	public int getSn() {
		return sn;
	}

	public void setSn(int sn) {
		this.sn = sn;
	}

	public Calculator getCal() {
		return cal;
	}

	public void setCal(Calculator cal) {
		this.cal = cal;
	}

	private int sn;
	Calculator cal = null;
	
	public int numAdd(int x, int y) {
		return cal.numAdd(x, y);
	}
}
