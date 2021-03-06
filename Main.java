import javax.swing.*;
import java.awt.*;

/**Classe principale
@param args Tableau des arguments passées en ligne de commande*/
public class Main {

	/**@param args Tableau des arguments passées en ligne de commande*/
    public static void main(String[] args) {

    	//Récupération de la taille utilisable de l'écran
    	Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    	int windowSizeX = (int)dimension.getWidth();			//Taille horizontale
    	int windowSizeY = (int)dimension.getHeight();			//Taille verticale

    	//Innitialisation de fenêtres
    	Window welcomeWindow = new Window("Welcome",windowSizeX / 3,windowSizeY / 2,windowSizeX / 3,windowSizeY / 4,true);
		Window createWindow = new Window("Create a grid",windowSizeX / 3,windowSizeY / 2,windowSizeX / 3,windowSizeY / 4,true);
		Window mapCreatingWindow = new Window("Create your map",windowSizeX,windowSizeY,0,0,true);
		Window algorithmWindow = new Window("Choose an algorithm",windowSizeX / 3,windowSizeY / 2,windowSizeX / 3,windowSizeY / 4,true);

		//Innitialisation de différents gérants
		MenuActionManagement menuActionManagement = new MenuActionManagement(welcomeWindow,createWindow,mapCreatingWindow,algorithmWindow);
		GridActionManagement gridActionManagement = new GridActionManagement(mapCreatingWindow);

		//Ajout des gérants au fenêtres
		welcomeWindow.setManagement(menuActionManagement);

		createWindow.setManagement(menuActionManagement);

		mapCreatingWindow.setManagement(menuActionManagement);
		mapCreatingWindow.setManagement(gridActionManagement);

		algorithmWindow.setManagement(menuActionManagement);

		//Innitialisation du contenu de welcomeWindow
		welcomeWindow.setGridLayout(3,1);
		welcomeWindow.add(welcomeWindow.getNewJLabel("Welcome! Please, choose an option :",2),BorderLayout.CENTER);
		welcomeWindow.add(welcomeWindow.getNewJLabel("Open a grid","MenuActionManagement",2),BorderLayout.CENTER);
		welcomeWindow.add(welcomeWindow.getNewJLabel("Create a grid","MenuActionManagement",2),BorderLayout.CENTER);

		//Innitialisation du contenu de createWindow
		createWindow.setGridLayout(7,1);
		createWindow.add(createWindow.getNewJLabel("Choose the size of the grid [20x20] :",2),BorderLayout.CENTER);
		createWindow.add(createWindow.getNewJLabel("Bigger","MenuActionManagement",2),BorderLayout.CENTER);
		createWindow.add(createWindow.getNewJLabel("Smaller","MenuActionManagement",2),BorderLayout.CENTER);
		createWindow.add(createWindow.getNewJLabel("Choose how to fill the grid :",2),BorderLayout.CENTER);
		createWindow.add(createWindow.getNewJLabel("Void","MenuActionManagement",2),BorderLayout.CENTER);
		createWindow.add(createWindow.getNewJLabel("Random fill","MenuActionManagement",2),BorderLayout.CENTER);
		createWindow.add(createWindow.getNewJLabel("Done","MenuActionManagement",2),BorderLayout.CENTER);

		//Innitialisation du contenu de mapCreatingWindow
		Panel panel = new Panel();
		panel.setLayout(new GridLayout(10,1));
		panel.add(mapCreatingWindow.getNewJLabel("  Change the map :  ",1));
		panel.add(mapCreatingWindow.getNewJLabel("Reset","MenuActionManagement",1));
		panel.add(mapCreatingWindow.getNewJLabel("Filled with walls","MenuActionManagement",1));
		panel.add(mapCreatingWindow.getNewJLabel("Random fill","MenuActionManagement",1));
		panel.add(mapCreatingWindow.getNewJLabel("Rubber","MenuActionManagement",1));
		panel.add(mapCreatingWindow.getNewJLabel("Put a wall","MenuActionManagement",1));
		panel.add(mapCreatingWindow.getNewJLabel("Put the start","MenuActionManagement",1));
		panel.add(mapCreatingWindow.getNewJLabel("Put the exit","MenuActionManagement",1));
		panel.add(mapCreatingWindow.getNewJLabel("Save the map","MenuActionManagement",1));
		panel.add(mapCreatingWindow.getNewJLabel("Done","MenuActionManagement",1));
		mapCreatingWindow.add(panel,BorderLayout.WEST);

		//Innitialisation du contenu d'algorithmWindow
		algorithmWindow.setGridLayout(9,1);
		algorithmWindow.add(algorithmWindow.getNewJLabel("Choose a maximum of rounds :",2),BorderLayout.CENTER);
		algorithmWindow.add(algorithmWindow.getNewJTextArea("5000"),BorderLayout.CENTER);
		algorithmWindow.add(algorithmWindow.getNewJLabel("Choose an algorithm :",2),BorderLayout.CENTER);
		algorithmWindow.add(algorithmWindow.getNewJLabel("Random","MenuActionManagement",2),BorderLayout.CENTER);
		algorithmWindow.add(algorithmWindow.getNewJLabel("Determinist","MenuActionManagement",2),BorderLayout.CENTER);
		algorithmWindow.add(algorithmWindow.getNewJLabel("Choose a mode :",2),BorderLayout.CENTER);
		algorithmWindow.add(algorithmWindow.getNewJLabel("Manual","MenuActionManagement",2),BorderLayout.CENTER);
		algorithmWindow.add(algorithmWindow.getNewJLabel("Automatic","MenuActionManagement",2),BorderLayout.CENTER);
		algorithmWindow.add(algorithmWindow.getNewJLabel("Done","MenuActionManagement",2),BorderLayout.CENTER);

		welcomeWindow.setVisible(true);							//Affichage de la première fenêtre du programme
	}
}