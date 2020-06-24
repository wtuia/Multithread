package futuretask;

public class ResultObj {

	private int flag;
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "ResultObj{" +
				"flag=" + flag +
				", content='" + content + '\'' +
				'}';
	}
}
