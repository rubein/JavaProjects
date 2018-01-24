package collections;
import java.io.Serializable;
import java.util.ArrayList;

public class Member implements Comparable,Serializable 
{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 546976780749162907L;
	private int memberId;
	private String memberNm;
	
	public Member(int memberId, String memberNm) {
		super();
		this.memberId = memberId;
		this.memberNm = memberNm;
	}

	public int getMemberId() {
		return memberId;
	}

	public String getMemberNm() {
		return memberNm;
	}

	@Override
	public int hashCode() {
		return memberId;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (memberId != other.memberId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberNm=" + memberNm
			 + "]";
	}

	public int compareTo(Object arg0) {
		Integer key1=this.memberId;
		Integer key2=arg0.hashCode();
		//return (key1<key2)?-1:(key1==key2)? 0:1;
		return key1.compareTo(key2);
	}
}
