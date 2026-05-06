public class Main {
    public static void main(String[] args) {
        MemberDAO dao = new MemberDAO();
        dao.insertMember(1001,1234,"곽");

        dao.deleteMember(1001,1234);

    }
}
