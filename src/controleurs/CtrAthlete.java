package controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vues.*;
import modeles.*;

public class CtrAthlete implements ActionListener {

	vuesAthlete vAthlete;
	Athlete mathlete;
	
	public CtrAthlete(vuesAthlete vAthlete,	Athlete mathlete) {
		this.vAthlete=vAthlete;
		this.mathlete=mathlete;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
