package mail;

public class UntrustworthyMailWorker implements MailService {

    private final MailService[] chain;
    private final RealMailService rms;

    public UntrustworthyMailWorker(MailService[] chain) {
        this.chain = chain;
        this.rms = new RealMailService();
    }

    public RealMailService getRealMailService() {
        return rms;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        for (MailService service: chain) {
            mail = service.processMail(mail);
        }
        return getRealMailService().processMail(mail);
    }
}
