package nl.corne.marktplaats;

    public class Beheerder extends Gebruiker{

    private final static Beheerder beheerder = new Beheerder();

    private Beheerder() {
        super("admin", "admin123");
        super.setRol(Rol.BEHEERDER);
        GebruikerDao.getGebruikerDao().addGebruiker(this);
    }

    public static Beheerder getBeheerder() {
        return beheerder;
    }
}
