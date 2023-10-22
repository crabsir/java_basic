package mail;

import java.util.logging.*;

public class Send {

    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    public static void main(String[] args) {}

    public static class UntrustworthyMailWorker implements MailService {
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

    public static class Spy implements MailService {
        private final Logger logger;

        public Spy(Logger logger) {
            this.logger = logger;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailMessage) {
                if (mail.getFrom().equals(AUSTIN_POWERS) || mail.getTo().equals(AUSTIN_POWERS)) {
                    logger.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                            new Object[]{mail.getFrom(), mail.getTo(), ((MailMessage) mail).getMessage()});
                } else {
                    logger.log(Level.INFO, "Usual correspondence: from {0} to {1}",
                            new Object[]{mail.getFrom(), mail.getTo()});
                }
            }
            return mail;
        }
    }

    public static class Thief implements MailService {
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

    public static class Inspector implements MailService {
        public Inspector() {}
        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                String c = ((MailPackage) mail).getContent().getContent();
                if (c.contains(WEAPONS) || c.contains(BANNED_SUBSTANCE)) {
                    throw new IllegalPackageException();
                } else if (c.contains("stones")) {
                    throw new StolenPackageException();
                }
            }
            return mail;
        }
    }

    public static class IllegalPackageException extends RuntimeException {
        public IllegalPackageException() {}
        public IllegalPackageException(String message) {
            super(message);
        }
    }

    public static class StolenPackageException extends RuntimeException {
        public StolenPackageException() {}
        public StolenPackageException(String message) {
            super(message);
        }
    }


}
