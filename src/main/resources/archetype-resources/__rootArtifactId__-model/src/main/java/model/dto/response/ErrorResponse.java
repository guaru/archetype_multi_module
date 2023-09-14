package ${groupId}.model.dto.response;

public enum ErrorResponse {

	ERROR_X_REGION("1000", "Invalid header x-region","Invalid header x-region");

	private String code;
	private String title;
	private String suggestion;

	private ErrorResponse(String code, String title, String suggestion) {
		this.code = code;
		this.title = title;
		this.suggestion = suggestion;
	}

	public String getCode() {
		return this.code;
	}

	public String getTitle() {
		return this.title;
	}

	public String getSuggestion() {
		return this.suggestion;
	}

}
