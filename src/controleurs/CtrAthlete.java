package controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vues.*;
import modeles.*;

public class CtrAthlete implements ActionListener {

	VueAthlete vAthlete;
	Athlete mathlete;
	
	public CtrAthlete(VueAthlete vAthlete,	Athlete mathlete) {
		this.vAthlete=vAthlete;
		this.mathlete=mathlete;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
