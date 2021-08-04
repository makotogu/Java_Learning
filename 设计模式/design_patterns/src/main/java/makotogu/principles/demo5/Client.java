package makotogu.principles.demo5;

public class Client {
    public static void main(String[] args) {
        Agent agent = new Agent();
        Star star = new Star();
        star.setName("小明星");
        Fans fans = new Fans();
        fans.setName("大粉丝");
        Company company = new Company();
        company.setName("破公司");
        agent.setCompany(company);
        agent.setFans(fans);
        agent.setStar(star);

        agent.fansMeeting();
        agent.companyBusiness();
    }
}
