package mail;

public class Thief implements MailService {

    private final int minValue;

    private int stolenValue;

    public Thief(int minValue) {
        this.minValue = minValue;
        this.stolenValue = 0;
    }

    public int getStolenValue() {
        return stolenValue;
    }
    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage && ((MailPackage) mail).getContent().getPrice() >= minValue) {
            stolenValue += ((MailPackage) mail).getContent().getPrice();
            return new MailPackage(mail.getFrom(), mail.getTo(),
                new Package("stones instead of " + ((MailPackage) mail).getContent().getContent(), 0));
        }
        return mail;
    }
}
