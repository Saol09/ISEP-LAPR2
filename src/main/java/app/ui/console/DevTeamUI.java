package app.ui.console;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class DevTeamUI implements Runnable{

    public DevTeamUI()
    {

    }
    public void run()
    {
        System.out.println("\n");
        System.out.printf("Development Team:\n");
        System.out.printf("\t Diogo Cascais - 1200610@isep.ipp.pt \n");
        System.out.printf("\t Paulo Couto - 1200587@isep.ipp.pt \n");
        System.out.printf("\t Sérgio Lopes - 1200625@isep.ipp.pt \n");
        System.out.printf("\t Tiago Silva - 1191938@isep.ipp.pt \n");
        System.out.println("\n");
    }
}
