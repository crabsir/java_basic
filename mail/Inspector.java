package mail;

public class Inspector implements MailService {

    private static final String WEAPONS = "weapons";
    private static final String BANNED_SUBSTANCE = "banned substance";

    public Inspector() {}
    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            String c = ((MailPackage) mail).getContent().getContent();
            if (c.contains(WEAPONS) || c.contains(BANNED_SUBSTANCE)) {
                throw new IllegalPackageException("Illegal content: " + c);
            } else if (c.contains("stones")) {
                throw new StolenPackageException("Stolen content: " + c);
            }
        }
        return mail;
    }
}
