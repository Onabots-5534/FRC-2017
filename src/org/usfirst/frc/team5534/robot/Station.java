package org.usfirst.frc.team5534.robot;

public class Station {
	
	
	public static void DoNothing() {

	}
	
	
	public static void Baseline() {
		Track.CrossBaseLine();
	}
	
	
	public static void LeftStation() {		
		if      ( Field.Get0() == 'L' ) { Track.LeftSwitchWest();   }
		else if ( Field.Get1() == 'L' ) { Track.LeftScaleWest();    }
		else                            { Track.CrossBaseLine();    }
	}

	
	public static void CenterStation() {
		if      ( Field.Get0() == 'R' ) { Track.RightSwitchSouth(); }
		else if ( Field.Get0() == 'L' ) { Track.LeftSwitchSouth();  }
		else                            { Track.CrossBaseLine();    }
	}


	public static void RightStation() {
		if      ( Field.Get0() == 'R' ) { Track.RightSwitchEast();  }
		else if ( Field.Get1() == 'R' ) { Track.RightScaleEast();   }
		else                            { Track.CrossBaseLine();    }
	}

	
	public static void Testing() {
		
	}

}
