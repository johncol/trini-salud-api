package com.trinisalud.model.certificate.upload;

import java.util.Arrays;

public class UploadSampleRequest {

	Object data;

	public UploadSampleRequest() {
	}

	public UploadSampleRequest(Object data) {
		super();
		this.data = data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	@Override
	public String toString() {
		return "UploadSample [data=" + data + "]";
	}

}
