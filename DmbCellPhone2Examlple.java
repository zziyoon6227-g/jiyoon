public class DmbCellPhone2Examlple {
    public static void main(String[] args) {
        
        DmbCellPhone2 dmb = new DmbCellPhone2("자바폰","검정",10);

        System.out.println("모델: "+dmb.model);
        System.out.println("색상: "+dmb.color);

        System.out.println("채널: "+dmb.channel);

        dmb.powerOn();
        dmb.bell();
        dmb.sendVoice("여보세요");
        dmb.receiveVoice("안녕하세요! 저는 홍길동인데요");
        dmb.sendVoice("네 반갑습니다.");
        dmb.hangUp();

        dmb.turnOnDmb();
        dmb.changeChannelDmb(12);
        dmb.turnOffDmb();
    }
}
